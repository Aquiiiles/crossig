package hr.crosig.sample.data.generator.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalService;
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

	public void createUsers() {

		// adds sample agent

		_addUser(
			UserDataConstants.SAMPLE_AGENT_JOHN_FIRST_NAME,
			UserDataConstants.DEFAULT_AGENT_LAST_NAME,
			UserDataConstants.SAMPLE_AGENT_JOHN_EMAIL_ADDRESS,
			UserDataConstants.DEFAULT_USER_PASSWORD,
			UserDataConstants.USER_GROUP_AGENT_TYPE);

		// adds sample manager

		_addUser(
			UserDataConstants.SAMPLE_MANAGER_JACK_FIRST_NAME,
			UserDataConstants.DEFAULT_MANAGER_LAST_NAME,
			UserDataConstants.SAMPLE_MANAGER_JACK_EMAIL_ADDRESS,
			UserDataConstants.DEFAULT_USER_PASSWORD,
			UserDataConstants.USER_GROUP_MANAGER_TYPE);

		// adds VESSEL_ALL and MOTOR_ALL role to the sample manager

		_addRoleToUser(
			ContentSetupConstants.VESSEL_ROLE_ALL,
			UserDataConstants.SAMPLE_MANAGER_JACK_EMAIL_ADDRESS);

		_addRoleToUser(
				ContentSetupConstants.MOTOR_ROLE_ALL,
				UserDataConstants.SAMPLE_MANAGER_JACK_EMAIL_ADDRESS);

		// adds another sample agent

		_addUser(
			UserDataConstants.SAMPLE_AGENT_SCOTT_FIRST_NAME,
			UserDataConstants.DEFAULT_AGENT_LAST_NAME,
			UserDataConstants.SAMPLE_AGENT_SCOTT_EMAIL_ADDRESS,
			UserDataConstants.DEFAULT_USER_PASSWORD,
			UserDataConstants.USER_GROUP_AGENT_TYPE);

		// adds VESSEL_SELL and MOTOR_ALL role to the sample agent

		_addRoleToUser(
			ContentSetupConstants.VESSEL_ROLE_SELL,
			UserDataConstants.SAMPLE_AGENT_SCOTT_EMAIL_ADDRESS);

		_addRoleToUser(
				ContentSetupConstants.MOTOR_ROLE_ALL,
				UserDataConstants.SAMPLE_AGENT_SCOTT_EMAIL_ADDRESS);
	}

	/**
	 * Adds a Role to a User
	 * @param roleName
	 * @param userEmailAddress
	 */
	private void _addRoleToUser(String roleName, String userEmailAddress) {
		try {

			// default company id

			long defaultCompanyId = PortalUtil.getDefaultCompanyId();

			// gets the role

			Role role = _roleLocalService.getRole(defaultCompanyId, roleName);

			// gets the user

			User user = _userLocalService.getUserByEmailAddress(
				defaultCompanyId, userEmailAddress);

			// adds the role to the user

			_userLocalService.addRoleUser(role.getRoleId(), user.getUserId());
		}
		catch (Exception exception) {
			_log.error(exception);
		}
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
		String firstName, String lastName, String emailAddress, String password,
		String userGroupName) {

		try {

			// default company id

			long defaultCompanyId = PortalUtil.getDefaultCompanyId();

			// default user id

			long defaultUserId = _userLocalService.getDefaultUserId(
				defaultCompanyId);

			// calls the service to add the user

			return _userLocalService.addUser(
				defaultUserId, defaultCompanyId, false, password, password,
				true, null, emailAddress,
				LocaleUtil.fromLanguageId(
					UpgradeProcessUtil.getDefaultLanguageId(defaultCompanyId)),
				firstName, null, lastName, -1, -1, true,
				LocalDateTime.now(
				).getMonthValue() - 1,
				LocalDateTime.now(
				).getDayOfMonth(),
				LocalDateTime.now(
				).getYear(),
				null, _getAgentPortalGroupId(), new long[0], new long[0],
				_getUserGroupId(userGroupName), false,
				GeneratorUtilities.getDefaultServiceContext(defaultUserId));
		}
		catch (Exception exception) {
			_log.error(exception);

			return null;
		}
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

		if (group != null) {
			return new long[] {group.getGroupId()};
		}

		return new long[0];
	}

	/**
	 * Gets the User Group Id related to its name
	 * @param userGroupName
	 * @return
	 */
	private long[] _getUserGroupId(String userGroupName)
		throws PortalException {

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

			if (userGroup != null) {
				return new long[] {userGroup.getUserGroupId()};
			}

			return new long[0];
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
		}
		else if (!Validator.isEmailAddress(emailAddress)) {
			throw new PortalException("Invalid E-mail Address");
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UserDataGeneratorImpl.class);

	@Reference
	private RoleLocalService _roleLocalService;

	@Reference
	private UserGroupLocalService _userGroupLocalService;

	@Reference
	private UserLocalService _userLocalService;

}