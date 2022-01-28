package hr.crosig.contact.scheduler.service.impl;

import hr.crosig.contact.scheduler.service.base.ClearCacheService;
import org.osgi.service.component.annotations.Component;

/**
 * @author victor.catanante
 */
@Component(immediate = true, service = ClearCacheService.class)
public class ClearCacheServiceImpl implements ClearCacheService {

    @Override
    public void clearIndexCache(String index) {
        // TODO
    }

    @Override
    public void clearAllIndicesCache() {
        // TODO
    }
}
