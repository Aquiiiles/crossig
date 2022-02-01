package hr.crosig.contact.internal.search.model.index.contributor;

import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import hr.crosig.contact.constants.StreetConstants;
import hr.crosig.contact.model.Street;
import hr.crosig.contact.service.StreetLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Guilherme Kfouri
 */
@Component(
	immediate = true,
	property = "indexer.class.name=" + StreetConstants.MODEL_CLASS_NAME,
	service = ModelIndexerWriterContributor.class
)
public class StreetModelIndexerWriterContributor
	implements ModelIndexerWriterContributor<Street> {

	@Override
	public void customize(
		BatchIndexingActionable batchIndexingActionable,
		ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

		batchIndexingActionable.setPerformActionMethod(
			(Street entry) -> batchIndexingActionable.addDocuments(
				modelIndexerWriterDocumentHelper.getDocument(entry)));
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return dynamicQueryBatchIndexingActionableFactory.
			getBatchIndexingActionable(
				streetLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(Street entry) {
		return entry.getCompanyId();
	}

	@Reference
	protected StreetLocalService streetLocalService;

	@Reference
	protected DynamicQueryBatchIndexingActionableFactory
		dynamicQueryBatchIndexingActionableFactory;

}