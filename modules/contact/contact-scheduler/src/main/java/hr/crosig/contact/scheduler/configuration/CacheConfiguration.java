package hr.crosig.contact.scheduler.configuration;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = CacheConfiguration.OCD_ID)
public interface CacheConfiguration {

    public static final String OCD_ID = "hr.crosig.contact.scheduler.configuration.CacheConfiguration";

    @Meta.AD(deflt = "true", required=false, name="Enable Scheduler")
    Boolean enable();

    @Meta.AD(deflt = "0 00 19 ? * * *", required=false, name="Cron Expression")
    String cronExpression();
}
