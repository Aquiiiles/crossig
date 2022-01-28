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
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import hr.crosig.contact.constants.CityConstants;
import hr.crosig.contact.model.City;
import hr.crosig.contact.service.base.CityLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=" + CityConstants.MODEL_CLASS_NAME,
	service = AopService.class
)
public class CityLocalServiceImpl extends CityLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	public City addCity(City city) {
		return city;
	}

	@Indexable(type = IndexableType.REINDEX)
	public City updateCity(City city) {
		return city;
	}

	@Indexable(type = IndexableType.DELETE)
	public void deleteCity(City city) {
	}
}