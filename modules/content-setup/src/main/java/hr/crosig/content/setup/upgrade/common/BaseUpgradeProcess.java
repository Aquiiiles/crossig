package hr.crosig.content.setup.upgrade.common;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserGroupLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
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
		UserLocalService userLocalService) {

		this.groupLocalService = groupLocalService;
		this.companyLocalService = companyLocalService;
		this.userLocalService = userLocalService;
	}

	protected Group addSite(
			String name, String description, String friendlyURL, int type)
		throws PortalException {

		long companyId = getDefaultCompanyId();

		Group group = groupLocalService.fetchFriendlyURLGroup(
				companyId, friendlyURL);

		if (group != null) {
			log.info("Site already exists: " + name);

			return group;
		}

		long userId = getAdminUserId(companyId);
		Map<Locale, String> nameMap = getMap(name);
		Map<Locale, String> descriptionMap = getMap(description);
		ServiceContext serviceContext = getDefaultServiceContext(
				companyId, userId);

		group = groupLocalService.addGroup(
			userId, GroupConstants.DEFAULT_PARENT_GROUP_ID,
			Group.class.getName(), userId,
			GroupConstants.DEFAULT_LIVE_GROUP_ID, nameMap, descriptionMap, type,
			true, GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION, friendlyURL,
			true, false, true, serviceContext);

		log.info("Site created: " + name);

		return group;
	}

	protected UserGroup addUserGroup(String name, String description)
		throws PortalException {

		long companyId = getDefaultCompanyId();

		UserGroup userGroup = userGroupLocalService.fetchUserGroup(
				companyId, name);

		if (userGroup != null) {
			log.info("User Group already exists: " + name);

			return userGroup;
		}

		long userId = getAdminUserId(companyId);

		ServiceContext serviceContext = getDefaultServiceContext(
				companyId, userId);

		userGroup = userGroupLocalService.addUserGroup(
			userId, companyId, name, description, serviceContext);

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
	protected UserGroupLocalService userGroupLocalService;
	protected UserLocalService userLocalService;

}