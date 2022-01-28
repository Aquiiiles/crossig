package hr.crosig.contact.scheduler.listener;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.scheduler.*;
import hr.crosig.contact.scheduler.configuration.CacheConfiguration;
import hr.crosig.contact.scheduler.util.SchedulerLogUtil;
import org.osgi.service.component.annotations.*;

import java.util.Date;
import java.util.Map;

/**
 * @author victor.catanante
 */
@Component(
    configurationPid = "hr.crosig.contact.scheduler.configuration.CacheConfiguration",
    immediate = true
)
public class CacheScheduler implements MessageListener {

    @Override
    public void receive(Message message) throws MessageListenerException {
        SchedulerLogUtil.logListenerActionTriggered(getClass());

        // TODO

        SchedulerLogUtil.logListenerActionSucceeded(getClass());
    }

    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
        _cacheConfiguration = ConfigurableUtil.createConfigurable(CacheConfiguration.class, properties);

        if (_cacheConfiguration.enable()) {
            String listenerClass = getClass().getName();

            Trigger jobTrigger = _triggerFactory.createTrigger(
                    listenerClass, listenerClass, new Date(), null, _cacheConfiguration.cronExpression());

            SchedulerEntry schedulerEntry = new SchedulerEntryImpl(getClass().getName(), jobTrigger);

            _schedulerEngineHelper.register(this, schedulerEntry, DestinationNames.SCHEDULER_DISPATCH);

            SchedulerLogUtil.logListenerInitialized(getClass(), _cacheConfiguration.cronExpression());
        } else {
            deactivate();
        }
    }

    @Deactivate
    protected void deactivate() {
        _schedulerEngineHelper.unregister(this);
        SchedulerLogUtil.logListenerDisabled(getClass());
    }

    private static volatile CacheConfiguration _cacheConfiguration;

    @Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
    private volatile ModuleServiceLifecycle _moduleServiceLifecycle;

    @Reference(unbind = "-")
    private volatile SchedulerEngineHelper _schedulerEngineHelper;

    @Reference(unbind = "-")
    private volatile TriggerFactory _triggerFactory;
}


