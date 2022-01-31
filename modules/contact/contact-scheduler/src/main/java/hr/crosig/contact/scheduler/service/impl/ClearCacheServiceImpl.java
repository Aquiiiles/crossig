package hr.crosig.contact.scheduler.service.impl;

import hr.crosig.contact.scheduler.enums.IndexType;
import hr.crosig.contact.scheduler.service.base.ClearCacheService;

import java.util.Arrays;

import org.osgi.service.component.annotations.Component;

/**
 * @author victor.catanante
 */
@Component(immediate = true, service = ClearCacheService.class)
public class ClearCacheServiceImpl implements ClearCacheService {

	@Override
	public void _clearAllIndicesCache() {
		Arrays.stream(
			IndexType.values()
		).forEach(
			indexType -> _clearIndexCache(indexType.getName())
		);
	}

	@Override
	public void _clearIndexCache(String index) {

		// TODO call Kfouri's clear index cache service method.

	}

}