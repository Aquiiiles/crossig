package hr.crosig.contact.scheduler.executor;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;

import hr.crosig.contact.service.IndexManagementLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author victor.catanante
 */
@Component(
	immediate = true,
	property = "background.task.executor.class.name=" + IndexManagementBackgroundTask.EXECUTOR_CLASS_NAME,
	service = IndexManagementBackgroundTask.class
)
public class IndexManagementBackgroundTask extends BaseBackgroundTaskExecutor {

	@Override
	public BackgroundTaskExecutor clone() {
		return new IndexManagementBackgroundTask();
	}

	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) {
		_indexManagementLocalService.clearAllIndicesCache();

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

	protected static final String EXECUTOR_CLASS_NAME =
		"hr.crosig.contact.scheduler.executor.IndexManagementBackgroundTask";

	@Reference(unbind = "-")
	private IndexManagementLocalService _indexManagementLocalService;

}