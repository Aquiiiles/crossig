package hr.crosig.contact.scheduler.executor;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplayFactoryUtil;

import hr.crosig.contact.service.IndexManagementLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author victor.catanante
 */
@Component(
	immediate = true,
	property = "background.task.executor.class.name=" + IndexManagementBackgroundTask.EXECUTOR_CLASS_NAME,
	service = BackgroundTaskExecutor.class
)
public class IndexManagementBackgroundTask extends BaseBackgroundTaskExecutor {

	public static final String EXECUTOR_CLASS_NAME =
		"hr.crosig.contact.scheduler.executor.IndexManagementBackgroundTask";

	public IndexManagementBackgroundTask(
		IndexManagementLocalService indexManagementLocalService) {
			_indexManagementLocalService = indexManagementLocalService;
	}

	public IndexManagementBackgroundTask() {}

	@Override
	public BackgroundTaskExecutor clone() {
		return new IndexManagementBackgroundTask(_indexManagementLocalService);
	}

	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) {
		_indexManagementLocalService.clearAllIndicesCache();
		_indexManagementLocalService.populateAllIndices();

		return BackgroundTaskResult.SUCCESS;
	}

	@Override
	public BackgroundTaskDisplay getBackgroundTaskDisplay(
		BackgroundTask backgroundTask) {

		return BackgroundTaskDisplayFactoryUtil.getBackgroundTaskDisplay(
			backgroundTask);
	}

	@Override
	public boolean isSerial() {
		return true;
	}

	@Reference(unbind = "-")
	protected void setIndexManagementLocalService(IndexManagementLocalService indexManagementLocalService) {
		_indexManagementLocalService = indexManagementLocalService;
	}

	private IndexManagementLocalService _indexManagementLocalService;

}