package hr.crosig.content.setup.upgrade.common;

import com.liferay.portal.kernel.exception.DuplicateRoleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.LayoutSetLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserGroupLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PrefsProps;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/**
 * @author Guilherme Kfouri
 */
public abstract class BaseUpgradeProcess extends UpgradeProcess {

	public BaseUpgradeProcess(DependencyProvider dependencyProvider) {
		this.dependencyProvider = dependencyProvider;

		layoutLocalService = dependencyProvider.layoutLocalService;
		groupLocalService = dependencyProvider.groupLocalService;
		userGroupLocalService = dependencyProvider.userGroupLocalService;
		userLocalService = dependencyProvider.userLocalService;
		companyLocalService = dependencyProvider.companyLocalService;
		roleLocalService = dependencyProvider.roleLocalService;
		prefsProps = dependencyProvider.prefsProps;
		layoutSetLocalService = dependencyProvider.layoutSetLocalService;
	}

	protected Layout addPage(
			Long userId, Long groupId, Boolean privatePage, Long parentLayoutId,
			String pageName, String title, String description, String type,
			Boolean hidden, String friendlyUrl, ServiceContext serviceContext)
		throws PortalException {

		Layout layout = layoutLocalService.fetchLayoutByFriendlyURL(
			groupId, privatePage, friendlyUrl);

		if (!Objects.isNull(layout)) {
			log.info(
				"Page with friendly url: " + friendlyUrl + " already exists");

			return layout;
		}

		return layoutLocalService.addLayout(
			userId, groupId, privatePage, parentLayoutId, pageName, title,
			description, type, hidden, friendlyUrl, serviceContext);
	}

	protected void addPortletToPage(
		Layout layout, Long userId, String portletId, String columnId,
		Integer columnPos) {

		LayoutTypePortlet layoutTypePortlet =
			(LayoutTypePortlet)layout.getLayoutType();

		try {
			layoutTypePortlet.addPortletId(
				userId, portletId, columnId, columnPos);
		}
		catch (Exception exception) {
			log.error(exception);
		}
	}

	protected void addRole(
		String roleName, String roleTitle, String roleDescription,
		int roleType) {

		try {
			long companyId = getDefaultCompanyId();

			long userId = getAdminUserId(companyId);

			roleLocalService.addRole(
				userId, null, 0, roleName, getMap(roleTitle),
				getMap(roleDescription), roleType, null,
				getDefaultServiceContext(companyId, userId));
		}
		catch (DuplicateRoleException duplicateRoleException) {
			log.info("Role: " + roleName + " already exists");
		}
		catch (Exception exception) {
			log.error(exception);
		}
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
			Group.class.getName(), userId, GroupConstants.DEFAULT_LIVE_GROUP_ID,
			nameMap, descriptionMap, type, true,
			GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION, friendlyURL, true,
			false, true, serviceContext);

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

	protected void setPageLayoutTemplateId(
		Layout layout, Long userId, String newLayoutTemplateId) {

		LayoutTypePortlet layoutTypePortlet =
			(LayoutTypePortlet)layout.getLayoutType();

		layoutTypePortlet.setLayoutTemplateId(userId, newLayoutTemplateId);
	}

	protected void setupAdminUpgrade() throws PortalException {
		PermissionChecker originalPermissionChecker =
			PermissionThreadLocal.getPermissionChecker();
		String originalName = PrincipalThreadLocal.getName();

		this.originalPermissionChecker = originalPermissionChecker;
		this.originalName = originalName;

		long companyId = getDefaultCompanyId();

		Role adminRole = roleLocalService.getRole(
			companyId, RoleConstants.ADMINISTRATOR);

		User adminUser = userLocalService.getRoleUsers(
			adminRole.getRoleId()
		).get(
			0
		);

		PrincipalThreadLocal.setName(adminUser.getUserId());

		PermissionChecker adminPermissionChecker =
			PermissionCheckerFactoryUtil.create(adminUser);

		PermissionThreadLocal.setPermissionChecker(adminPermissionChecker);
	}

	protected void teardownAdminUpgrade() {
		PrincipalThreadLocal.setName(originalName);
		PermissionThreadLocal.setPermissionChecker(originalPermissionChecker);
	}

	protected void updatePage(Layout layout) throws PortalException {
		layoutLocalService.updateLayout(
			layout.getGroupId(), layout.isPrivateLayout(), layout.getLayoutId(),
			layout.getTypeSettings());
	}

	protected static final Log log = LogFactoryUtil.getLog(
		BaseUpgradeProcess.class);

	protected CompanyLocalService companyLocalService;
	protected final DependencyProvider dependencyProvider;
	protected GroupLocalService groupLocalService;
	protected LayoutLocalService layoutLocalService;
	protected LayoutSetLocalService layoutSetLocalService;
	protected String originalName;
	protected PermissionChecker originalPermissionChecker;
	protected PrefsProps prefsProps;
	protected RoleLocalService roleLocalService;
	protected UserGroupLocalService userGroupLocalService;
	protected UserLocalService userLocalService;

}