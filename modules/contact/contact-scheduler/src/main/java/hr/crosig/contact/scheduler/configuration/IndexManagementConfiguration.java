package hr.crosig.contact.scheduler.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author victor.catanante
 */
@ExtendedObjectClassDefinition(category = "agent-portal")
@Meta.OCD(id = IndexManagementConfiguration.OCD_ID)
public interface IndexManagementConfiguration {

	public static final String OCD_ID =
		"hr.crosig.contact.scheduler.configuration." +
				"IndexManagementConfiguration";

	@Meta.AD(deflt = "true", name = "Enable Scheduler", required = false)
	Boolean _enable();

	@Meta.AD(deflt = "0 0 1 * * ?", name = "Cron Expression", required = false)
	String _cronExpression();

}