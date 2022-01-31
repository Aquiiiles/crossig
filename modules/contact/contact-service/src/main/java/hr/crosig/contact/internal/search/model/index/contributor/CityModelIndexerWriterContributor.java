package hr.crosig.contact.internal.search.model.index.contributor;

import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import hr.crosig.contact.constants.CityConstants;
import hr.crosig.contact.model.City;
import hr.crosig.contact.service.CityLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Guilherme Kfouri
 */
@Component(
	immediate = true,
	property = "indexer.class.name=" + CityConstants.MODEL_CLASS_NAME,
	service = ModelIndexerWriterContributor.class
)
public class CityModelIndexerWriterContributor
	implements ModelIndexerWriterContributor<City> {

	@Override
	public void customize(
		BatchIndexingActionable batchIndexingActionable,
		ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

		batchIndexingActionable.setPerformActionMethod(
			(City entry) -> batchIndexingActionable.addDocuments(
				modelIndexerWriterDocumentHelper.getDocument(entry)));
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return dynamicQueryBatchIndexingActionableFactory.
			getBatchIndexingActionable(
				cityLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(City entry) {
		return entry.getCompanyId();
	}

	@Reference
	protected CityLocalService cityLocalService;

	@Reference
	protected DynamicQueryBatchIndexingActionableFactory
		dynamicQueryBatchIndexingActionableFactory;

}