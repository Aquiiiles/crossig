package hr.crosig.contact.scheduler.listener;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.scheduler.*;
import hr.crosig.contact.scheduler.configuration.CacheConfiguration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.Map;

/**
 * @author victor.catanante
 */
public class CacheScheduler implements MessageListener {
    @Override
    public void receive(Message message) throws MessageListenerException {
        // TODO
    }

    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
        CacheConfiguration cacheConfiguration = ConfigurableUtil.createConfigurable(
                CacheConfiguration.class, properties);

        String listenerClass = getClass().getName();

        Trigger jobTrigger = _triggerFactory.createTrigger(
                listenerClass, listenerClass, new Date(), null, cacheConfiguration.cronExpression());

        SchedulerEntry schedulerEntry = new SchedulerEntryImpl(getClass().getName(), jobTrigger);

        _schedulerEngineHelper.register(this, schedulerEntry, DestinationNames.SCHEDULER_DISPATCH);
    }

    @Deactivate
    protected void deactivate() {
        _schedulerEngineHelper.unregister(this);
    }

    @Reference
    private SchedulerEngineHelper _schedulerEngineHelper;

    @Reference
    private TriggerFactory _triggerFactory;
}


