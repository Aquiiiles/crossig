package hr.crosig.sample.data.generator.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.service.UserGroupLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.upgrade.util.UpgradeProcessUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import hr.crosig.sample.data.generator.api.UserDataGenerator;
import hr.crosig.sample.data.generator.util.GeneratorUtilities;
import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * @author marcelo.mazurky
 */
@Component(
        immediate = true,
        service = UserDataGenerator.class
)
public class UserDataGeneratorImpl implements UserDataGenerator {
    @Reference
    private UserLocalService _userLocalService;
    @Reference
    private UserGroupLocalService _userGroupLocalService;


    /**
     * Adds a Regular User to the system
     */
    @Override
    public void addRegularUser(String firstName, String lastName, String emailAddress, String password, String userGroupName) throws PortalException, SQLException {
        // validates the email address
        _validateEmailAddress(emailAddress);
        // adds the user
        _addUser(firstName, lastName, emailAddress, password, userGroupName);
    }

    /***
     * Adds the user
     * @param firstName
     * @param lastName
     * @param emailAddress
     * @param password
     * @param userGroupName
     * @throws PortalException
     * @throws SQLException
     */
    private void _addUser(String firstName, String lastName, String emailAddress, String password, String userGroupName) throws PortalException, SQLException {
        // gets the user group id by the user group name (if it was informed)
        Long userGroupId = _getUserGroupId(userGroupName);
        // default company id
        long defaultCompanyId = PortalUtil.getDefaultCompanyId();
        // default user id
        long defaultUserId = _userLocalService.getDefaultUserId(defaultCompanyId);

        // calls the service to add the user
        _userLocalService.addUser(
                defaultUserId,
                defaultCompanyId,
                false,
                password,
                password,
                true,
                null,
                emailAddress,
                LocaleUtil.fromLanguageId(UpgradeProcessUtil.getDefaultLanguageId(defaultCompanyId)),
                firstName,
                null,
                lastName,
                -1,
                -1,
                true,
                LocalDateTime.now().getMonthValue() - 1,
                LocalDateTime.now().getDayOfMonth(),
                LocalDateTime.now().getYear(),
                null,
                new long[0],
                new long[0],
                new long[0],
                userGroupId != null ? new long[]{userGroupId} : new long[0],
                false,
                GeneratorUtilities.getDefaultServiceContext(defaultUserId));
    }

    /**
     * Gets the User Group Id related to its name
     * @param userGroupName
     * @return
     * @throws PortalException
     */
    private Long _getUserGroupId(String userGroupName) throws PortalException {
        // if the User Group Name was informed
        if (StringUtils.isNotEmpty(userGroupName)) {
            // default company id
            long defaultCompanyId = PortalUtil.getDefaultCompanyId();
            // gets the user group by its name
            UserGroup userGroup = _userGroupLocalService.fetchUserGroup(defaultCompanyId, userGroupName);

            // if it doesn't exist, creates a new User Group
            if (Validator.isNull(userGroup)) {
                // default user id
                long defaultUserId = _userLocalService.getDefaultUserId(defaultCompanyId);
                // creates a new User Group
                userGroup = _userGroupLocalService.addUserGroup(defaultUserId, defaultCompanyId, userGroupName, null, GeneratorUtilities.getDefaultServiceContext(defaultUserId));
            }

            return userGroup.getUserGroupId();
        }

        return null;
    }

    /**
     * Validates the e-mail address
     * @param emailAddress
     * @throws UserEmailAddressException.MustNotBeDuplicate
     */
    private void _validateEmailAddress(String emailAddress) throws UserEmailAddressException.MustNotBeDuplicate {
        // gets the User by its Email Address
        User user = _userLocalService.fetchUserByEmailAddress(PortalUtil.getDefaultCompanyId(), emailAddress);

        // if it was not found, throw a new Exception
        if (Validator.isNotNull(user)) {
            throw new UserEmailAddressException.MustNotBeDuplicate(user.getUserId(), emailAddress);
        }
    }
}