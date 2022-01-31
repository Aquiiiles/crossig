package hr.crosig.contact.scheduler.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Optional;

/**
 * @author victor.catanante
 */
public abstract class UserUtil {

    public static User getAdminUser() {
        final Long companyId = PortalUtil.getDefaultCompanyId();

        try {
            Role role = RoleLocalServiceUtil.getRole(companyId, RoleConstants.ADMINISTRATOR);
            Optional<User> adminUser = UserLocalServiceUtil.getRoleUsers(role.getRoleId())
                                            .stream()
                                            .findFirst();
            if (adminUser.isPresent()) {
                return adminUser.get();
            }

        } catch (PortalException e) {
            e.printStackTrace();
        }

        return null;
    }
}
