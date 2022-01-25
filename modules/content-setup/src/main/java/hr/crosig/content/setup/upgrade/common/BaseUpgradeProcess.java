package hr.crosig.content.setup.upgrade.common;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.Portal;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public abstract class BaseUpgradeProcess extends UpgradeProcess {
    public BaseUpgradeProcess(
            GroupLocalService groupLocalService, Portal portal, UserLocalService userLocalService,
            RoleLocalService roleLocalService) {
        _groupLocalService = groupLocalService;
        _portal = portal;
        _userLocalService = userLocalService;
        _roleLocalService = roleLocalService;
    }

    protected Group addSite(
            String name, String description, String friendlyURL, int type)
            throws PortalException {

        long companyId = getDefaultCompanyId();

        Group group = _groupLocalService.fetchFriendlyURLGroup(
                companyId, friendlyURL);

        if (group != null) {
            _log.info("Site already exists: " + name);

            return group;
        }

        long userId = getAdminUserId();
        Map<Locale, String> nameMap = getMap(name);
        Map<Locale, String> descriptionMap = getMap(description);
        ServiceContext serviceContext = getDefaultServiceContext(companyId, userId);

        try {
            group = _groupLocalService.addGroup(
                    userId, GroupConstants.DEFAULT_PARENT_GROUP_ID, Group.class.getName(), userId,
                    GroupConstants.DEFAULT_LIVE_GROUP_ID, nameMap, descriptionMap, type, true,
                    GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION, friendlyURL,
                    true, false, true, serviceContext);
        }
        catch (PortalException pe) {
            _log.error("Failed to create site: " + name, pe);

            throw pe;
        }
        _log.info("Site created: " + name);

        return group;
    }

    protected long getDefaultCompanyId() {
        return _portal.getDefaultCompanyId();
    }

    protected long getAdminUserId() {
        long companyId = getDefaultCompanyId();
        try {
            Role role = _roleLocalService.getRole(companyId, RoleConstants.ADMINISTRATOR);
            List<User> users = _userLocalService.getRoleUsers(role.getRoleId());
            return users.get(0).getUserId();
        } catch (PortalException pe) {
            _log.error("Failed to get admin user Id", pe);
        }
        return 0;
    }

    protected Map<Locale, String> getMap(String name) {
        Locale locale = Locale.getDefault();

        Map<Locale, String> map = new HashMap<>();
        map.put(locale, name);
        return map;
    }

    protected ServiceContext getDefaultServiceContext(long companyId, long userId) {
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setCompanyId(companyId);
        serviceContext.setUserId(userId);
        return serviceContext;
    }

    protected static final Log _log = LogFactoryUtil.getLog(BaseUpgradeProcess.class);

    protected GroupLocalService _groupLocalService;

    protected Portal _portal;

    protected UserLocalService _userLocalService;

    protected RoleLocalService _roleLocalService;
}
