package hr.crosig.sample.data.generator.web.command.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import hr.crosig.sample.data.generator.api.UserDataGenerator;
import hr.crosig.sample.data.generator.web.constants.SampleDataGeneratorWebCommandNames;
import hr.crosig.sample.data.generator.web.constants.SampleDataGeneratorWebPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

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
public class CreateUsersMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse) {

		try {

			// calls the service to create users

			_userDataGenerator.createUsers();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			SessionErrors.add(actionRequest, exception.getClass());
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CreateUsersMVCActionCommand.class);

	@Reference
	private UserDataGenerator _userDataGenerator;

}