package hr.crosig.sample.data.generator.web.command.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import hr.crosig.sample.data.generator.api.UserDataGenerator;
import hr.crosig.sample.data.generator.web.constants.CreateUserMVCActionConstants;
import hr.crosig.sample.data.generator.web.constants.SampleDataGeneratorWebCommandNames;
import hr.crosig.sample.data.generator.web.constants.SampleDataGeneratorWebPortletKeys;
import hr.crosig.sample.data.generator.web.dto.UserDTO;
import hr.crosig.sample.data.generator.web.enums.UserAttributeEnum;
import hr.crosig.sample.data.generator.web.util.ActionUtilities;
import hr.crosig.sample.data.generator.web.util.UserDTOUtilities;

import java.sql.SQLException;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author marcelo.mazurky
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SampleDataGeneratorWebPortletKeys.SAMPLE_DATA_GENERATOR_WEB_PORTLET,
		"mvc.command.name=" + SampleDataGeneratorWebCommandNames.ACTION_CREATE_USER
	},
	service = MVCActionCommand.class
)
public class CreateUserMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse) {

		try {

			// gets the users' json from request

			String usersJSON = ParamUtil.getString(
				actionRequest, CreateUserMVCActionConstants.USERS_JSON);

			// handles the users' creation

			_handleCreateUser(usersJSON);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			SessionErrors.add(actionRequest, exception.getClass());
		}
	}

	/**
	 * Adds a Regular User to the System
	 * @param user
	 * @throws PortalException
	 * @throws SQLException
	 */
	private void _addRegularUser(UserDTO user)
		throws PortalException, SQLException {

		String firstName = user.getUserAttributeValue(
			UserAttributeEnum.FIRST_NAME);
		String lastName = user.getUserAttributeValue(
			UserAttributeEnum.LAST_NAME);
		String emailAddress = user.getUserAttributeValue(
			UserAttributeEnum.EMAIL_ADDRESS);
		String password = user.getUserAttributeValue(
			UserAttributeEnum.PASSWORD);
		String userGroupName = user.getUserAttributeValue(
			UserAttributeEnum.USER_GROUP_NAME);

		_userDataGenerator.addRegularUser(
			firstName, lastName, emailAddress, password, userGroupName);
	}

	/**
	 * Handles the User's creation
	 *
	 * @param usersJSON
	 * @throws PortalException
	 * @throws SQLException
	 */
	private void _handleCreateUser(String usersJSON)
		throws PortalException, SQLException {

		// check if it was multiple users to create

		boolean multipleUsers = ActionUtilities.isJsonArray(usersJSON);

		if (multipleUsers) {

			// gets the user map list from the users json

			List<UserDTO> users = UserDTOUtilities.getUserDTOListFromJSONString(
				usersJSON);

			for (UserDTO user : users) {

				// creates the user

				_addRegularUser(user);
			}
		}
		else {

			// gets the user map from the users json

			UserDTO user = UserDTOUtilities.getUserDTOFromJSONString(usersJSON);

			// creates the user

			_addRegularUser(user);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CreateUserMVCActionCommand.class);

	@Reference
	private UserDataGenerator _userDataGenerator;

}