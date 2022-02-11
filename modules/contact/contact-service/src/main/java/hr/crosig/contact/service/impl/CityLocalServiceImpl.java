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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.service.UserLocalService;
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
import hr.crosig.contact.dto.CityDTO;
import hr.crosig.contact.exception.CityException;
import hr.crosig.contact.model.City;
import hr.crosig.contact.model.impl.CityModelImpl;
import hr.crosig.contact.model.impl.StreetModelImpl;
import hr.crosig.contact.service.base.CityLocalServiceBaseImpl;
import hr.crosig.contact.util.BulkHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Guilherme Kfouri
 */
@Component(
	property = "model.class.name=" + CityConstants.MODEL_CLASS_NAME,
	service = AopService.class
)
public class CityLocalServiceImpl extends CityLocalServiceBaseImpl {

	public List<CityDTO> addCities(List<CityDTO> cities) {
		long companyId = PortalUtil.getDefaultCompanyId();

		cities.forEach(
			cityDTO -> {
				City city = createCity(cityDTO, companyId);

				city = cityLocalService.updateCity(city);

				cityDTO.setCityId(city.getCityId());
			});

		return cities;
	}

	public City addCity(CityDTO cityDTO) throws CityException {
		validateCity(cityDTO.getCityId(), cityDTO.getCityName());

		City city = createCity(cityDTO, PortalUtil.getDefaultCompanyId());

		return cityLocalService.updateCity(city);
	}

	public void deleteAllCities() throws PortalException {
		BulkHelper.bulkDeleteAll(
			cityPersistence.getCurrentSession(), CityModelImpl.TABLE_NAME);
		reindex();
	}

	public List<City> deleteCitiesByName(String cityName)
		throws PortalException {

		List<City> cities = cityPersistence.findByName(cityName);

		String externalCitiesIds = cities.stream(
		).map(
			city -> String.valueOf(city.getCityId())
		).collect(
			Collectors.joining(",")
		);

		BulkHelper.bulkDeleteByColumnValues(
			cityPersistence.getCurrentSession(), CityModelImpl.TABLE_NAME,
			CityConstants.FIELD_CITY_ID, externalCitiesIds);
		BulkHelper.bulkDeleteByColumnValues(
			cityPersistence.getCurrentSession(), StreetModelImpl.TABLE_NAME,
			CityConstants.FIELD_CITY_ID, externalCitiesIds);

		reindex();

		return cities;
	}

	public City deleteCityByExternalId(long externalId) {
		City city = cityPersistence.fetchByPrimaryKey(externalId);

		if (!Objects.isNull(city)) {
			cityLocalService.deleteCity(city);

			BulkHelper.bulkDeleteByColumnValues(
				cityPersistence.getCurrentSession(), StreetModelImpl.TABLE_NAME,
				CityConstants.FIELD_CITY_ID, String.valueOf(externalId));
		}

		return city;
	}

	public List<CityDTO> searchCitiesNamesByName(String cityName)
		throws CityException {

		return searchCitiesNamesByName(cityName, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<CityDTO> searchCitiesNamesByName(
			String cityName, int start, int end)
		throws CityException {

		validateSearchCityName(cityName);

		MatchQuery entryClassQuery = _queries.match(
			Field.ENTRY_CLASS_NAME, CityConstants.MODEL_CLASS_NAME);
		MatchPhrasePrefixQuery nameQuery = _queries.matchPhrasePrefix(
			CityConstants.FIELD_CITY_NAME, cityName);

		BooleanQuery booleanQuery = _queries.booleanQuery();

		booleanQuery.addMustQueryClauses(entryClassQuery, nameQuery);

		SearchRequest searchRequest = createSearchRequest(
			booleanQuery, start, end);

		List<SearchHit> searchHitsList = getSearchHits(searchRequest);

		return getCities(searchHitsList);
	}

	protected boolean cityExists(long cityId) {
		City city = cityPersistence.fetchByPrimaryKey(cityId);

		return !Objects.isNull(city);
	}

	protected boolean cityExists(String cityName) {
		City city = cityPersistence.fetchByName_First(cityName, null);

		return !Objects.isNull(city);
	}

	protected City createCity(CityDTO cityDTO, long companyId) {
		City city = cityLocalService.createCity(
			counterLocalService.increment(City.class.getName()));

		city.setExternalId(cityDTO.getExternalCityId());
		city.setName(cityDTO.getCityName());
		city.setZipCode(cityDTO.getZipCode());
		city.setBoxNumber(cityDTO.getBoxNumber());
		city.setPostName(cityDTO.getPostName());
		city.setCompanyId(companyId);

		return city;
	}

	protected SearchRequest createSearchRequest(
		Query query, int start, int end) {

		long defaultCompanyId = PortalUtil.getDefaultCompanyId();

		SearchRequestBuilder searchRequestBuilder =
			_searchRequestBuilderFactory.builder();

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

	protected List<CityDTO> getCities(List<SearchHit> searchHitsList) {
		List<CityDTO> cities = new ArrayList<>();

		searchHitsList.forEach(
			searchHit -> {
				Document doc = searchHit.getDocument();
				CityDTO city = new CityDTO();

				long cityId = doc.getLong(CityConstants.FIELD_CITY_ID);
				String name = doc.getString(CityConstants.FIELD_CITY_NAME);

				city.setCityId(cityId);
				city.setCityName(name);

				cities.add(city);
			});

		return cities;
	}

	protected List<SearchHit> getSearchHits(SearchRequest searchRequest) {
		SearchResponse searchResponse = _searcher.search(searchRequest);

		SearchHits searchHits = searchResponse.getSearchHits();

		return searchHits.getSearchHits();
	}

	protected void validateCity(long cityId, String cityName)
		throws CityException {

		if (cityExists(cityId))

			throw new CityException(
				CityMessages.CITY_WITH_THIS_ID_ALREADY_EXISTS + cityId);

		if (cityExists(cityName))

			throw new CityException(
				CityMessages.CITY_WITH_THIS_NAME_ALREADY_EXISTS + cityName);
	}

	protected void validateSearchCityName(String cityName)
		throws CityException {

		if (cityName.length() < CityConstants.CITY_NAME_MINIMUM_LENGTH)

			throw new CityException(CityMessages.INSUFICIENT_NAME_LENGTH);
	}

	private void reindex() throws PortalException {
		long companyId = PortalUtil.getDefaultCompanyId();

		_indexWriterHelper.reindex(
			_userLocalService.getDefaultUserId(companyId),
			"reindex", new long[] {companyId},
			CityConstants.MODEL_CLASS_NAME, new HashMap<>());
	}

	@Reference
	private IndexWriterHelper _indexWriterHelper;

	@Reference
	private Queries _queries;

	@Reference
	private Searcher _searcher;

	@Reference
	private SearchRequestBuilderFactory _searchRequestBuilderFactory;

	@Reference
	private UserLocalService _userLocalService;

}