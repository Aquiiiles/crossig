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
import hr.crosig.contact.constants.StreetConstants;
import hr.crosig.contact.constants.StreetMessages;
import hr.crosig.contact.dto.StreetDTO;
import hr.crosig.contact.exception.StreetException;
import hr.crosig.contact.model.Street;
import hr.crosig.contact.service.base.StreetLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Guilherme Kfouri
 */
@Component(
	property = "model.class.name=" + StreetConstants.MODEL_CLASS_NAME,
	service = AopService.class
)
public class StreetLocalServiceImpl extends StreetLocalServiceBaseImpl {

	public void addOrUpdateStreets(List<StreetDTO> streets) {
		streets.forEach(
			streetDTO -> {
				Street street = createStreet(streetDTO);

				street.setNew(!streetExists(streetDTO.getStreetId()));

				streetLocalService.updateStreet(street);
			});
	}

	public Street addStreet(StreetDTO streetDTO) throws StreetException {
		validateStreet(streetDTO.getStreetId());

		Street street = createStreet(streetDTO);

		return streetLocalService.updateStreet(street);
	}

	public void deleteAllStreets() {
		List<Street> streets = streetLocalService.getStreets(-1, -1);

		streets.forEach(street -> streetLocalService.deleteStreet(street));
	}

	public List<String> searchStreetsNamesByNameAndCityId(
			String streetName, long cityId, int start, int end)
		throws Exception {

		validateSearchStreetName(streetName);

		MatchQuery entryClassQuery = _queries.match(
			Field.ENTRY_CLASS_NAME, StreetConstants.MODEL_CLASS_NAME);
		MatchPhrasePrefixQuery nameQuery = _queries.matchPhrasePrefix(
			StreetConstants.FIELD_STREET_NAME, streetName);
		MatchQuery cityIdQuery = _queries.match(
			CityConstants.FIELD_CITY_ID, cityId);

		BooleanQuery booleanQuery = _queries.booleanQuery();

		booleanQuery.addMustQueryClauses(
			entryClassQuery, nameQuery, cityIdQuery);

		SearchRequest searchRequest = createSearchRequest(
			booleanQuery, start, end);

		List<SearchHit> searchHitsList = getSearchHits(searchRequest);

		return getStreetsNames(searchHitsList);
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
					new String[] {StreetConstants.MODEL_CLASS_NAME});
				searchContext.setStart(start);
			});

		return searchRequestBuilder.query(
			query
		).build();
	}

	protected Street createStreet(StreetDTO streetDTO) {
		Street street = streetLocalService.createStreet(
			streetDTO.getStreetId());

		street.setName(streetDTO.getStreetName());
		street.setCityId(streetDTO.getCityId());
		street.setCompanyId(PortalUtil.getDefaultCompanyId());

		return street;
	}

	protected List<SearchHit> getSearchHits(SearchRequest searchRequest) {
		SearchResponse searchResponse = _searcher.search(searchRequest);

		SearchHits searchHits = searchResponse.getSearchHits();

		return searchHits.getSearchHits();
	}

	protected List<String> getStreetsNames(List<SearchHit> searchHitsList) {
		List<String> streetsNames = new ArrayList<>();

		searchHitsList.forEach(
			searchHit -> {
				Document doc = searchHit.getDocument();

				String name = doc.getString(StreetConstants.FIELD_STREET_NAME);

				streetsNames.add(name);
			});

		return streetsNames;
	}

	protected boolean streetExists(long streetId) {
		Street street = streetLocalService.fetchStreet(streetId);

		return !Objects.isNull(street);
	}

	protected void validateSearchStreetName(String streetName)
		throws StreetException {

		if (streetName.length() < StreetConstants.STREET_NAME_MINIMUM_LENGTH)

			throw new StreetException(StreetMessages.INSUFICIENT_NAME_LENGTH);
	}

	protected void validateStreet(long streetId) throws StreetException {
		if (streetExists(streetId))

			throw new StreetException(
				StreetMessages.STREET_WITH_THIS_ID_ALREADY_EXISTS + streetId);
	}

	@Reference
	private Queries _queries;

	@Reference
	private Searcher _searcher;

	@Reference
	private SearchRequestBuilderFactory _searchRequestBuilderFactory;

}