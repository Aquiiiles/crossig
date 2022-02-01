package hr.crosig.contact.internal.search.model.query.contributor;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import hr.crosig.contact.constants.CityConstants;
import hr.crosig.contact.constants.StreetConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Guilherme Kfouri
 */
@Component(
	immediate = true,
	property = "indexer.class.name=" + StreetConstants.MODEL_CLASS_NAME,
	service = KeywordQueryContributor.class
)
public class StreetKeywordQueryContributor implements KeywordQueryContributor {

	@Override
	public void contribute(
		String keywords, BooleanQuery booleanQuery,
		KeywordQueryContributorHelper keywordQueryContributorHelper) {

		queryHelper.addSearchTerm(
			booleanQuery, keywordQueryContributorHelper.getSearchContext(),
			StreetConstants.FIELD_STREET_NAME, true);

		queryHelper.addSearchTerm(
				booleanQuery, keywordQueryContributorHelper.getSearchContext(),
				CityConstants.FIELD_CITY_ID, true);
	}

	@Reference
	protected QueryHelper queryHelper;

}