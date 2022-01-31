package hr.crosig.contact.scheduler.service.impl;

import hr.crosig.contact.scheduler.enums.IndexType;
import hr.crosig.contact.scheduler.service.base.ClearCacheService;
import org.osgi.service.component.annotations.Component;

import java.util.Arrays;

/**
 * @author victor.catanante
 */
@Component(immediate = true, service = ClearCacheService.class)
public class ClearCacheServiceImpl implements ClearCacheService {

    @Override
    public void clearIndexCache(String index) {
        // TODO call Kfouri's clear index cache service method.
    }

    @Override
    public void clearAllIndicesCache() {
        Arrays.stream(IndexType.values())
            .forEach(indexType -> clearIndexCache(indexType.getName()));
    }
}
