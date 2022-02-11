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
import hr.crosig.sample.data.generator.web.constants.UserJsonConstants;
import hr.crosig.sample.data.generator.web.util.ActionUtilities;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

    private static final Log _log = LogFactoryUtil.getLog(
            CreateUserMVCActionCommand.class);
    @Reference
    private UserDataGenerator _userDataGenerator;

    @Override
    protected void doProcessAction(
            ActionRequest actionRequest, ActionResponse actionResponse) {

        try {
            // gets the users' json from request
            String usersJson = ParamUtil.getString(actionRequest, CreateUserMVCActionConstants.USERS_JSON);

            // handles the users' creation
            handleCreateUser(usersJson);
        } catch (Exception exception) {
            _log.error(exception, exception);

            SessionErrors.add(actionRequest, exception.getClass());
        }
    }

    /**
     * Handles the User's creation
     *
     * @param usersJson
     * @throws PortalException
     * @throws SQLException
     */
    private void handleCreateUser(String usersJson) throws PortalException, SQLException {
        // check if it was multiple users to create
        boolean multipleUsers = ActionUtilities.isJsonList(usersJson);

        if (multipleUsers) {
            // gets the user map list from the users json
            List<Map> users = ActionUtilities.getMapListFromJson(usersJson);

            for (Map user : users) {
                // creates the user
                _addRegularUser(user);
            }
        } else {
            // gets the user map from the users json
            Map user = ActionUtilities.getMapFromJson(usersJson);

            // creates the user
            _addRegularUser(user);
        }

    }

    /**
     * Adds a Regular User to the System
     * @param user
     * @throws PortalException
     * @throws SQLException
     */
    private void _addRegularUser(Map user) throws PortalException, SQLException {
        String firstName = ActionUtilities.retrieveStringFromMap(UserJsonConstants.FIRST_NAME_KEY, user);
        String lastName = ActionUtilities.retrieveStringFromMap(UserJsonConstants.LAST_NAME_KEY, user);
        String emailAddress = ActionUtilities.retrieveStringFromMap(UserJsonConstants.EMAIL_ADDRESS_KEY, user);
        String password = ActionUtilities.retrieveStringFromMap(UserJsonConstants.PASSWORD_KEY, user);
        String userGroupName = ActionUtilities.retrieveStringFromMap(UserJsonConstants.USER_GROUP_NAME_KEY, user);

        _userDataGenerator.addRegularUser(firstName, lastName, emailAddress, password, userGroupName);
    }
}