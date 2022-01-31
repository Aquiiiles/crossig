package hr.crosig.content.setup.upgrade.common;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.*;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author Guilherme Kfouri
 */
public abstract class BaseUpgradeProcess extends UpgradeProcess {

	public BaseUpgradeProcess(
		CompanyLocalService companyLocalService,
		GroupLocalService groupLocalService, UserLocalService userLocalService,
		UserGroupLocalService userGroupLocalService) {

		this.companyLocalService = companyLocalService;
		this.groupLocalService = groupLocalService;
		this.userLocalService = userLocalService;
		this.userGroupLocalService = userGroupLocalService;
	}

	public BaseUpgradeProcess(
		GroupLocalService groupLocalService,
		CompanyLocalService companyLocalService,
		UserLocalService userLocalService, RoleLocalService roleLocalService) {

		this.groupLocalService = groupLocalService;
		this.companyLocalService = companyLocalService;
		this.userLocalService = userLocalService;
		this.roleLocalService = roleLocalService;
	}

	protected Group addSite(
			String name, String description, String friendlyURL, int type)
		throws PortalException {

		_companyId = getDefaultCompanyId();

		Group group = groupLocalService.fetchFriendlyURLGroup(
			_companyId, friendlyURL);

		if (group != null) {
			log.info("Site already exists: " + name);

			return group;
		}

		_userId = getAdminUserId(_companyId);
		Map<Locale, String> nameMap = getMap(name);
		Map<Locale, String> descriptionMap = getMap(description);
		ServiceContext serviceContext = getDefaultServiceContext(
			_companyId, _userId);

		group = groupLocalService.addGroup(
			_userId, GroupConstants.DEFAULT_PARENT_GROUP_ID,
			Group.class.getName(), _userId,
			GroupConstants.DEFAULT_LIVE_GROUP_ID, nameMap, descriptionMap, type,
			true, GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION, friendlyURL,
			true, false, true, serviceContext);

		log.info("Site created: " + name);

		return group;
	}

	protected UserGroup addUserGroup(String name, String description)
		throws PortalException {

		_companyId = getDefaultCompanyId();

		UserGroup userGroup = userGroupLocalService.fetchUserGroup(
			_companyId, name);

		if (userGroup != null) {
			log.info("User Group already exists: " + name);

			return userGroup;
		}

		_userId = getAdminUserId(_companyId);

		ServiceContext serviceContext = getDefaultServiceContext(
			_companyId, _userId);

		userGroup = userGroupLocalService.addUserGroup(
			_userId, _companyId, name, description, serviceContext);

		log.info("User Group created: " + name);

		return userGroup;
	}

	protected long getAdminUserId(long companyId) throws PortalException {
		User adminUser = userLocalService.getDefaultUser(companyId);

		return adminUser.getUserId();
	}

	protected long getDefaultCompanyId() throws PortalException {
		String webId = PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID);

		Company company = companyLocalService.getCompanyByWebId(webId);

		return company.getCompanyId();
	}

	protected ServiceContext getDefaultServiceContext(
		long companyId, long userId) {

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(companyId);
		serviceContext.setUserId(userId);

		return serviceContext;
	}

	protected Map<Locale, String> getMap(String name) {
		Locale locale = LocaleUtil.getDefault();

		Map<Locale, String> map = new HashMap<>();

		map.put(locale, name);

		return map;
	}

	protected static final Log log = LogFactoryUtil.getLog(
		BaseUpgradeProcess.class);

	protected CompanyLocalService companyLocalService;
	protected GroupLocalService groupLocalService;
	protected RoleLocalService roleLocalService;
	protected UserGroupLocalService userGroupLocalService;
	protected UserLocalService userLocalService;

	private Long _companyId;
	private Long _userId;

}