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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
import hr.crosig.contact.model.City;
import hr.crosig.contact.service.base.CityLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Guilherme Kfouri
 */
@Component(
	property = "model.class.name=" + CityConstants.MODEL_CLASS_NAME,
	service = AopService.class
)
public class CityLocalServiceImpl extends CityLocalServiceBaseImpl {

	public void addCities(Map<Long, String> cities) {
		Set<Long> citiesIds = cities.keySet();

		citiesIds.forEach(
			cityId -> {
				String cityName = cities.get(cityId);

				try {
					addCity(cityId, cityName);
				}
				catch (CityException cityException) {
					_log.error(
						CityMessages.CITY_WITH_THIS_ID_ALREADY_EXISTS + cityId);
				}
			});
	}

	public City addCity(long cityId, String cityName) throws CityException {
		validateCity(cityId);

		City city = createCity(cityId, cityName);

		return cityLocalService.updateCity(city);
	}

	public void addOrUpdateCities(Map<Long, String> cities) {
		Set<Long> citiesIds = cities.keySet();

		citiesIds.forEach(
			cityId -> {
				City city = cityLocalService.fetchCity(cityId);
				String cityName = cities.get(cityId);

				if (Objects.isNull(city)) {
					city = createCity(cityId, cityName);

					addCity(city);
				}
				else {
					city.setName(cityName);

					cityLocalService.updateCity(city);
				}
			});
	}

	public void deleteAllCities() {
		List<City> cities = cityLocalService.getCities(-1, -1);

		cities.forEach(city -> cityLocalService.deleteCity(city));
	}

	public List<String> searchCitiesNamesByName(
			String cityName, int start, int end)
		throws Exception {

		validateSearchCityName(cityName);

		MatchQuery entryClassQuery = queries.match(
			Field.ENTRY_CLASS_NAME, CityConstants.MODEL_CLASS_NAME);
		MatchPhrasePrefixQuery nameQuery = queries.matchPhrasePrefix(
			CityConstants.FIELD_CITY_NAME, cityName);

		BooleanQuery booleanQuery = queries.booleanQuery();

		booleanQuery.addMustQueryClauses(entryClassQuery, nameQuery);

		SearchRequest searchRequest = createSearchRequest(
			booleanQuery, start, end);

		List<SearchHit> searchHitsList = getSearchHits(searchRequest);

		return getCitiesNames(searchHitsList);
	}

	protected City createCity(long cityId, String cityName) {
		City city = cityLocalService.createCity(cityId);

		city.setName(cityName);
		city.setCompanyId(PortalUtil.getDefaultCompanyId());

		return city;
	}

	protected SearchRequest createSearchRequest(
		Query query, int start, int end) {

		long defaultCompanyId = PortalUtil.getDefaultCompanyId();

		SearchRequestBuilder searchRequestBuilder =
			searchRequestBuilderFactory.builder();

		searchRequestBuilder.emptySearchEnabled(true);
		searchRequestBuilder.withSearchContext(
			searchContext -> {
				searchContext.setCompanyId(defaultCompanyId);
				searchContext.setEnd(end);
				searchContext.setEntryClassNames(
					new String[] {CityConstants.MODEL_CLASS_NAME});
				searchContext.setStart(start);
			});

		return searchRequestBuilder.query(
			query
		).build();
	}

	protected List<String> getCitiesNames(List<SearchHit> searchHitsList) {
		List<String> citiesNames = new ArrayList<>();

		searchHitsList.forEach(
			searchHit -> {
				Document doc = searchHit.getDocument();

				String name = doc.getString(CityConstants.FIELD_CITY_NAME);

				citiesNames.add(name);
			});

		return citiesNames;
	}

	protected List<SearchHit> getSearchHits(SearchRequest searchRequest) {
		SearchResponse searchResponse = searcher.search(searchRequest);

		SearchHits searchHits = searchResponse.getSearchHits();

		return searchHits.getSearchHits();
	}

	protected void validateCity(long cityId) throws CityException {
		City city = cityLocalService.fetchCity(cityId);

		if (!Objects.isNull(city))

			throw new CityException(
				CityMessages.CITY_WITH_THIS_ID_ALREADY_EXISTS + cityId);
	}

	protected void validateSearchCityName(String cityName)
		throws CityException {

		if (cityName.length() < 3)

			throw new CityException(CityMessages.INSUFICIENT_NAME_LENGTH);
	}

	@Reference
	protected Queries queries;

	@Reference
	protected Searcher searcher;

	@Reference
	protected SearchRequestBuilderFactory searchRequestBuilderFactory;

	private static final Log _log = LogFactoryUtil.getLog(
		CityLocalServiceImpl.class);

}