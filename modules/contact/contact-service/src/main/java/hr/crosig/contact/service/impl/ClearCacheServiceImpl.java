package hr.crosig.contact.service.impl;

import hr.crosig.contact.scheduler.enums.IndexType;
import hr.crosig.contact.service.CityLocalService;
import hr.crosig.contact.service.ClearCacheService;
import hr.crosig.contact.service.StreetLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;

/**
 * @author victor.catanante
 */
@Component(immediate = true, service = ClearCacheService.class)
public class ClearCacheServiceImpl implements ClearCacheService {

	@Override
	public void clearAllIndicesCache() {
		Arrays.stream(
			IndexType.values()
		).forEach(
			indexType -> clearIndexCache(indexType.getName())
		);
	}

	@Override
	public void clearIndexCache(String index) {
		_cityLocalService.deleteAllCities();
		_streetLocalService.deleteAllStreets();
	}

	@Reference
	private CityLocalService _cityLocalService;

	@Reference
	private StreetLocalService _streetLocalService;

}