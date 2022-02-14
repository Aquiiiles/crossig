package hr.crosig.sample.data.generator.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.upgrade.util.UpgradeProcessUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import hr.crosig.content.setup.constants.ContentSetupConstants;
import hr.crosig.sample.data.generator.api.UserDataGenerator;
import hr.crosig.sample.data.generator.api.constants.UserDataConstants;
import hr.crosig.sample.data.generator.util.GeneratorUtilities;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * @author marcelo.mazurky
 */
@Component(immediate = true, service = UserDataGenerator.class)
public class UserDataGeneratorImpl implements UserDataGenerator {

	/**
	 * Adds a Regular User to the system
	 * @return
	 */
	@Override
	public User addRegularUser(
			String firstName, String lastName, String emailAddress,
			String password, String userGroupName)
		throws PortalException, SQLException {

		// validates the email address

		_validateEmailAddress(emailAddress);

		// adds and return the user

		return _addUser(
			firstName, lastName, emailAddress, password, userGroupName);
	}

	/**
	 * Adds the user
	 * @param firstName
	 * @param lastName
	 * @param emailAddress
	 * @param password
	 * @param userGroupName
	 * @return
	 */
	private User _addUser(
			String firstName, String lastName, String emailAddress,
			String password, String userGroupName)
		throws PortalException, SQLException {

		// default company id

		long defaultCompanyId = PortalUtil.getDefaultCompanyId();

		// default user id

		long defaultUserId = _userLocalService.getDefaultUserId(
			defaultCompanyId);

		// calls the service to add the user

		return _userLocalService.addUser(
			defaultUserId, defaultCompanyId, false, password, password, true,
			null, emailAddress,
			LocaleUtil.fromLanguageId(
				UpgradeProcessUtil.getDefaultLanguageId(defaultCompanyId)),
			firstName, null, lastName, -1, -1, true,
			LocalDateTime.now(
			).getMonthValue() - 1,
			LocalDateTime.now(
			).getDayOfMonth(),
			LocalDateTime.now(
			).getYear(),
			null,
			_getAgentPortalGroupId(),
			new long[0], new long[0],
			_getUserGroupId(userGroupName),
			false, GeneratorUtilities.getDefaultServiceContext(defaultUserId));
	}

	/**
	 * Gets the Agent Portal's Group Id
	 * @return
	 */
	private long[] _getAgentPortalGroupId() {

		// default company id

		long defaultCompanyId = PortalUtil.getDefaultCompanyId();

		// tries to get the Group

		Group group = GroupLocalServiceUtil.fetchGroup(
			defaultCompanyId, ContentSetupConstants.AGENT_PORTAL_SITE_NAME);

		return (group != null) ? new long[] {group.getGroupId()} : new long[0];
	}

	/**
	 * Gets the User Group Id related to its name
	 * @param userGroupName
	 * @return
	 */
	private long[] _getUserGroupId(String userGroupName) throws PortalException {

		// if the User Group Name was informed

		if (Validator.isNotNull(userGroupName)) {

			// default company id

			long defaultCompanyId = PortalUtil.getDefaultCompanyId();

			// gets the user group by its name

			UserGroup userGroup = _userGroupLocalService.fetchUserGroup(
				defaultCompanyId, userGroupName);

			if (Validator.isNull(userGroup)) {
				throw new PortalException("User Group not found");
			}

			return userGroup != null ? new long[] {userGroup.getUserGroupId()} : new long[0];
		}

		return new long[0];
	}

	/**
	 * Validates the e-mail address
	 * @param emailAddress
	 * @throws UserEmailAddressException.MustNotBeDuplicate
	 */
	private void _validateEmailAddress(String emailAddress)
			throws PortalException {

		// gets the User by its Email Address

		User user = _userLocalService.fetchUserByEmailAddress(
			PortalUtil.getDefaultCompanyId(), emailAddress);

		if (Validator.isNotNull(user)) {
			throw new UserEmailAddressException.MustNotBeDuplicate(
				user.getUserId(), emailAddress);
		} else if (!Validator.isEmailAddress(emailAddress)){
			throw new PortalException("Invalid E-mail Address");
		}
	}

	public void createUsers() throws SQLException, PortalException {
		// adds sample agent
		_addUser(UserDataConstants.SAMPLE_AGENT_FIRST_NAME, UserDataConstants.SAMPLE_AGENT_LAST_NAME, UserDataConstants.SAMPLE_AGENT_EMAIL_ADDRESS, UserDataConstants.DEFAULT_USER_PASSWORD, UserDataConstants.USER_GROUP_AGENT_TYPE);
		// adds sample manager
		_addUser(UserDataConstants.SAMPLE_MANAGER_FIRST_NAME, UserDataConstants.SAMPLE_MANAGER_LAST_NAME, UserDataConstants.SAMPLE_MANAGER_EMAIL_ADDRESS, UserDataConstants.DEFAULT_USER_PASSWORD, UserDataConstants.USER_GROUP_MANAGER_TYPE);
	}

	@Reference
	private UserGroupLocalService _userGroupLocalService;

	@Reference
	private UserLocalService _userLocalService;

}