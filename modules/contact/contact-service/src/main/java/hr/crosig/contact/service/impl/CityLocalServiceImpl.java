/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package hr.crosig.contact.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.search.document.Document;
import com.liferay.portal.search.hits.SearchHit;
import com.liferay.portal.search.hits.SearchHits;
import com.liferay.portal.search.query.BooleanQuery;
import com.liferay.portal.search.query.MatchPhrasePrefixQuery;
import com.liferay.portal.search.query.MatchQuery;
import com.liferay.portal.search.query.Queries;
import com.liferay.portal.search.searcher.SearchRequest;
import com.liferay.portal.search.searcher.SearchRequestBuilder;
import com.liferay.portal.search.searcher.SearchRequestBuilderFactory;
import com.liferay.portal.search.searcher.SearchResponse;
import com.liferay.portal.search.searcher.Searcher;
import hr.crosig.contact.constants.CityConstants;
import hr.crosig.contact.model.City;
import hr.crosig.contact.service.base.CityLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Guilherme Kfouri
 */
@Component(
	property = "model.class.name=" + CityConstants.MODEL_CLASS_NAME,
	service = AopService.class
)
public class CityLocalServiceImpl extends CityLocalServiceBaseImpl {

	@Override
	@Indexable(type = IndexableType.REINDEX)
	public City addCity(City city) {
		return city;
	}

	@Override
	@Indexable(type = IndexableType.REINDEX)
	public City updateCity(City city) {
		return city;
	}

	@Override
	@Indexable(type = IndexableType.DELETE)
	public City deleteCity(City city) {
		return city;
	}

	public List<String> getCitiesNamesByName(String cityName, int start, int end) {

		MatchQuery entryClassQuery = queries.match(Field.ENTRY_CLASS_NAME, CityConstants.MODEL_CLASS_NAME);
		MatchPhrasePrefixQuery nameQuery = queries.matchPhrasePrefix(CityConstants.FIELD_CITY_NAME, cityName);

		BooleanQuery booleanQuery = queries.booleanQuery();
		booleanQuery.addMustQueryClauses(entryClassQuery, nameQuery);

		SearchRequest searchRequest = createSearchRequest(booleanQuery, start, end);

		List<SearchHit> searchHitsList = getSearchHits(searchRequest);

		return getCitiesNames(searchHitsList);
	}

	private SearchRequest createSearchRequest(BooleanQuery booleanQuery, int start, int end) {
		long defaultCompanyId = PortalUtil.getDefaultCompanyId();

		SearchRequestBuilder searchRequestBuilder =
				searchRequestBuilderFactory.builder();
		searchRequestBuilder.emptySearchEnabled(true);
		searchRequestBuilder.withSearchContext(
				searchContext -> {
					searchContext.setCompanyId(defaultCompanyId);
					searchContext.setEntryClassNames(new String[] {CityConstants.MODEL_CLASS_NAME});
					searchContext.setStart(start);
					searchContext.setEnd(end);
				});

		return searchRequestBuilder.query(booleanQuery).build();
	}

	private List<SearchHit> getSearchHits(SearchRequest searchRequest) {
		SearchResponse searchResponse = searcher.search(searchRequest);
		SearchHits searchHits = searchResponse.getSearchHits();
		return searchHits.getSearchHits();
	}

	private List<String> getCitiesNames(List<SearchHit> searchHitsList) {
		List<String> citiesNames = new ArrayList<>();
		searchHitsList.forEach(
				searchHit -> {
					Document doc = searchHit.getDocument();
					String name = doc.getString(CityConstants.FIELD_CITY_NAME);
					citiesNames.add(name);
				});
		return citiesNames;
	}

	@Reference
	protected Queries queries;

	@Reference
	protected Searcher searcher;

	@Reference
	protected SearchRequestBuilderFactory searchRequestBuilderFactory;

}