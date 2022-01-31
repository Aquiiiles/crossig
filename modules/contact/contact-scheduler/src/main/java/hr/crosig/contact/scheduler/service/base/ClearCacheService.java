package hr.crosig.contact.scheduler.service.base;

/**
 * @author victor.catanante
 */
public interface ClearCacheService {
    void clearIndexCache(String index);
    void clearAllIndicesCache();
}
