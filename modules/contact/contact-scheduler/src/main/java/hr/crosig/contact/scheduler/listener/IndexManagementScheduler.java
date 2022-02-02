package hr.crosig.contact.scheduler.listener;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.background.task.service.BackgroundTaskLocalServiceUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.PortalUtil;

import hr.crosig.contact.scheduler.configuration.IndexManagementConfiguration;
import hr.crosig.contact.scheduler.constants.SchedulerConstants;
import hr.crosig.contact.scheduler.executor.IndexManagementBackgroundTask;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author victor.catanante
 */
@Component(configurationPid = IndexManagementConfiguration.OCD_ID, immediate = true)
public class IndexManagementScheduler implements MessageListener {

	@Override
	public void receive(Message message) {
		_log.info(SchedulerConstants.SCHEDULER_TRIGGERED);

		try {
			User adminUser = _getAdminUser();

			BackgroundTaskLocalServiceUtil.addBackgroundTask(
				adminUser.getUserId(), adminUser.getGroupId(), StringPool.BLANK,
				IndexManagementBackgroundTask.class.getName(), new HashMap<>(),
				new ServiceContext());

			_log.info(SchedulerConstants.SCHEDULER_SUCCESSFULLY_TRIGGERED);
		}
		catch (PortalException portalException) {
			_log.error(
				SchedulerConstants.SCHEDULER_FAILED_WHEN_TRIGGERED,
				portalException);
		}
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_indexManagementConfiguration = ConfigurableUtil.createConfigurable(
			IndexManagementConfiguration.class, properties);

		if (_indexManagementConfiguration._enable()) {
			String cronExpression = _indexManagementConfiguration._cronExpression();
			String className = IndexManagementScheduler.class.getName();

			Trigger jobTrigger = _triggerFactory.createTrigger(
				className, className, new Date(), null, cronExpression);

			SchedulerEntry schedulerEntry = new SchedulerEntryImpl(
				className, jobTrigger);

			_schedulerEngineHelper.register(
				this, schedulerEntry, DestinationNames.SCHEDULER_DISPATCH);

			_log.info(
				String.format(
					SchedulerConstants.SCHEDULER_ENABLED, cronExpression));
		}
	}

	@Deactivate
	protected void deactivate() {
		_schedulerEngineHelper.unregister(this);
		_log.info(SchedulerConstants.SCHEDULER_DISABLED);
	}

	private User _getAdminUser() {
		final Long companyId = PortalUtil.getDefaultCompanyId();

		try {
			return _userLocalService.getUser(
				_userLocalService.getDefaultUserId(companyId));
		}
		catch (PortalException portalException) {
			_log.error(
				SchedulerConstants.SCHEDULER_FAILED_WHEN_TRIGGERED,
				portalException);
		}

		return null;
	}

	private static final Log _log = LogFactoryUtil.getLog(IndexManagementScheduler.class);

	private static volatile IndexManagementConfiguration _indexManagementConfiguration;

	@Reference(unbind = "-")
	private volatile SchedulerEngineHelper _schedulerEngineHelper;

	@Reference(unbind = "-")
	private volatile TriggerFactory _triggerFactory;

	@Reference(unbind = "-")
	private UserLocalService _userLocalService;

}