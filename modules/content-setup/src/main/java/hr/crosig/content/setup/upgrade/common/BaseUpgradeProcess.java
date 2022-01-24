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
import org.osgi.service.component.annotations.Reference;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public abstract class BaseUpgradeProcess extends UpgradeProcess {

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

        try {
            group = _groupLocalService.addGroup(
                    userId, 0L, null, 0L, 0L, nameMap, descriptionMap, type, true,
                    GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION, friendlyURL,
                    true, true, getDefaultServiceContext());
        }
        catch (PortalException pe) {
            _log.error("Failed to create site: " + name, pe);

            throw pe;
        }
        _log.info("Site created: " + name);

        return group;
    }

    private long getDefaultCompanyId() {
        return _portal.getDefaultCompanyId();
    }

    private long getAdminUserId() {
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

    private Map<Locale, String> getMap(String name) {
        Map<Locale, String> map = new HashMap<>();
        map.put(Locale.ENGLISH, name);
        return map;
    }

    private ServiceContext getDefaultServiceContext() {
        return new ServiceContext();
    }

    private static final Log _log = LogFactoryUtil.getLog(BaseUpgradeProcess.class);

    @Reference
    private GroupLocalService _groupLocalService;

    @Reference
    private UserLocalService _userLocalService;

    @Reference
    private RoleLocalService _roleLocalService;

    @Reference
    private Portal _portal;
}
