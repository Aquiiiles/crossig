package hr.crosig.contact.service.impl;

import hr.crosig.contact.scheduler.enums.IndexType;
import hr.crosig.contact.service.ClearCacheService;

import java.util.Arrays;

import org.osgi.service.component.annotations.Component;

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

		// TODO call Kfouri's clear index cache service method.

	}

}