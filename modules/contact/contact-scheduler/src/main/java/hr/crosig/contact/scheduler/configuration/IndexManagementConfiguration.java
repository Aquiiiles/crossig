package hr.crosig.contact.scheduler.configuration;

import aQute.bnd.annotation.metatype.Meta;

/**
 * @author victor.catanante
 */
@Meta.OCD(id = IndexManagementConfiguration.OCD_ID)
public interface IndexManagementConfiguration {

	public static final String OCD_ID =
		"hr.crosig.contact.scheduler.configuration.IndexManagementConfiguration";

	@Meta.AD(deflt = "true", name = "Enable Scheduler", required = false)
	Boolean _enable();

	@Meta.AD(
		deflt = "0 00 19 ? * * *", name = "Cron Expression", required = false
	)
	String _cronExpression();

}