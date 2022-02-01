package hr.crosig.contact.scheduler.executor;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;

import hr.crosig.contact.service.ClearCacheService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author victor.catanante
 */
@Component(
	immediate = true,
	property = "background.task.executor.class.name=hr.crosig.contact.scheduler.executor.ClearCacheBackgroundTask",
	service = ClearCacheBackgroundTask.class
)
public class ClearCacheBackgroundTask extends BaseBackgroundTaskExecutor {

	@Override
	public BackgroundTaskExecutor clone() {
		return new ClearCacheBackgroundTask();
	}

	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) {
		_clearCacheService.clearAllIndicesCache();

		return BackgroundTaskResult.SUCCESS;
	}

	@Override
	public BackgroundTaskDisplay getBackgroundTaskDisplay(
		BackgroundTask backgroundTask) {

		return null;
	}

	@Override
	public boolean isSerial() {
		return true;
	}

	@Reference(unbind = "-")
	private ClearCacheService _clearCacheService;

}