package hr.crosig.contact.scheduler.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author victor.catanante
 */
public abstract class SchedulerLogUtil {

    private static final Log _log = LogFactoryUtil.getLog("scheduler");

    public static void logListenerInitialized(Class<?> job, String cronExpression) {
        _log.info(job.getName() + " is enabled with cronExpression " + cronExpression + ".");
    }

    public static void logListenerDisabled(Class<?> job) {
        _log.info(job.getName() + " is disabled.");
    }

    public static void logListenerActionTriggered(Class<?> job) {
        _log.info(job.getName() + " triggered.");
    }

    public static void logListenerActionSucceeded(Class<?> job) {
        _log.info(job.getName() + " trigger finished successfully.");
    }

    public static void logListenerActionFailed(Class<?> job, Exception exception) {
        _log.error(job.getName() + " failed when triggered. StackTrace: ");
        exception.printStackTrace();
    }
}
