package hr.crosig.contact.scheduler.configuration;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "hr.crosig.contact.scheduler.configuration.CacheConfiguration")
public interface CacheConfiguration {
    @Meta.AD(deflt = "true", required=false, name="Enable Scheduler")
    Boolean enable();

    @Meta.AD(deflt = "0 00 19 ? * * *", required=false, name="Cron Expression")
    String cronExpression();
}
