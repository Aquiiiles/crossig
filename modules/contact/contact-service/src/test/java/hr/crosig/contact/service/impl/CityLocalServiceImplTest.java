package hr.crosig.contact.service.impl;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.search.document.Document;
import com.liferay.portal.search.hits.SearchHit;
import com.liferay.portal.search.hits.SearchHits;
import com.liferay.portal.search.query.BooleanQuery;
import com.liferay.portal.search.query.MatchPhrasePrefixQuery;
import com.liferay.portal.search.query.MatchQuery;
import com.liferay.portal.search.query.Queries;
import com.liferay.portal.search.query.Query;
import com.liferay.portal.search.searcher.SearchRequest;
import com.liferay.portal.search.searcher.SearchRequestBuilder;
import com.liferay.portal.search.searcher.SearchRequestBuilderFactory;
import com.liferay.portal.search.searcher.SearchResponse;
import com.liferay.portal.search.searcher.Searcher;

import hr.crosig.contact.constants.CityConstants;
import hr.crosig.contact.constants.CityMessages;
import hr.crosig.contact.exception.CityException;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 * @author Guilherme Kfouri
 */
@PrepareForTest(
	fullyQualifiedNames = "hr.crosig.contact.service.impl.CityLocalServiceImpl"
)
@RunWith(PowerMockRunner.class)
@SuppressStaticInitializationFor({"com.liferay.portal.kernel.util.PortalUtil"})
public class CityLocalServiceImplTest {

	@Test
	public void searchCities_With1Letter() throws Exception {
		expectedException.expect(CityException.class);
		expectedException.expectMessage(CityMessages.INSUFICIENT_NAME_LENGTH);

		_cityLocalServiceImpl.searchCitiesNamesByName("c", -1, -1);
	}

	@Test
	public void searchCities_With2Letters() throws Exception {
		expectedException.expect(CityException.class);
		expectedException.expectMessage(CityMessages.INSUFICIENT_NAME_LENGTH);

		_cityLocalServiceImpl.searchCitiesNamesByName("ci", -1, -1);
	}

	@Test
	public void searchCities_With3Letters() throws Exception {
		Query query = _mockQueries();

		_mockSearchers(query);

		List<String> cityNames = _cityLocalServiceImpl.searchCitiesNamesByName(
			"cit", -1, -1);

		Assert.assertEquals(1, cityNames.size());
		Assert.assertEquals("cityName", cityNames.get(0));
	}

	@Test
	public void searchCities_WithEmptyName() throws Exception {
		expectedException.expect(CityException.class);
		expectedException.expectMessage(CityMessages.INSUFICIENT_NAME_LENGTH);

		_cityLocalServiceImpl.searchCitiesNamesByName("", -1, -1);
	}

	@Before
	public void setUp() {
		_mockStaticUtilClasses();
		_injectMocks();
	}

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	private void _injectMocks() {
		Whitebox.setInternalState(_cityLocalServiceImpl, "_queries", _queries);
		Whitebox.setInternalState(
			_cityLocalServiceImpl, "_searcher", _searcher);
		Whitebox.setInternalState(
			_cityLocalServiceImpl, "_searchRequestBuilderFactory",
			_searchRequestBuilderFactory);
	}

	private Query _mockQueries() {
		MatchQuery matchQuery = Mockito.mock(MatchQuery.class);
		MatchPhrasePrefixQuery matchPhrasePrefixQuery = Mockito.mock(
			MatchPhrasePrefixQuery.class);
		BooleanQuery booleanQuery = Mockito.mock(BooleanQuery.class);

		Mockito.when(
			_queries.match(
				Field.ENTRY_CLASS_NAME, CityConstants.MODEL_CLASS_NAME)
		).thenReturn(
			matchQuery
		);
		Mockito.when(
			_queries.matchPhrasePrefix(CityConstants.FIELD_CITY_NAME, _cityName)
		).thenReturn(
			matchPhrasePrefixQuery
		);
		Mockito.when(
			_queries.booleanQuery()
		).thenReturn(
			booleanQuery
		);

		return booleanQuery;
	}

	private void _mockSearchers(Query query) {
		SearchRequestBuilder searchRequestBuilder = Mockito.mock(
			SearchRequestBuilder.class);

		SearchRequest searchRequest = Mockito.mock(SearchRequest.class);

		SearchResponse searchResponse = Mockito.mock(SearchResponse.class);

		SearchHits searchHits = Mockito.mock(SearchHits.class);

		SearchHit searchHit = Mockito.mock(SearchHit.class);

		List<SearchHit> searchHitList = Collections.singletonList(searchHit);

		Document document = Mockito.mock(Document.class);

		Mockito.when(
			_searchRequestBuilderFactory.builder()
		).thenReturn(
			searchRequestBuilder
		);
		Mockito.when(
			searchRequestBuilder.query(query)
		).thenReturn(
			searchRequestBuilder
		);
		Mockito.when(
			searchRequestBuilder.build()
		).thenReturn(
			searchRequest
		);
		Mockito.when(
			_searcher.search(searchRequest)
		).thenReturn(
			searchResponse
		);
		Mockito.when(
			searchResponse.getSearchHits()
		).thenReturn(
			searchHits
		);
		Mockito.when(
			searchHits.getSearchHits()
		).thenReturn(
			searchHitList
		);
		Mockito.when(
			searchHit.getDocument()
		).thenReturn(
			document
		);
		Mockito.when(
			document.getString(CityConstants.FIELD_CITY_NAME)
		).thenReturn(
			_cityName
		);
	}

	private void _mockStaticUtilClasses() {
		PowerMockito.mockStatic(PortalUtil.class);
	}

	private final CityLocalServiceImpl _cityLocalServiceImpl =
		new CityLocalServiceImpl();
	private final String _cityName = "cityName";

	@Mock
	private Queries _queries;

	@Mock
	private Searcher _searcher;

	@Mock
	private SearchRequestBuilderFactory _searchRequestBuilderFactory;

}