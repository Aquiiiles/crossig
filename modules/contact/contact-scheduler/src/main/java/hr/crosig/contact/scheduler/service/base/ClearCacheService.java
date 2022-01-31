package hr.crosig.contact.scheduler.service.base;

/**
 * @author victor.catanante
 */
public interface ClearCacheService {

	void _clearIndexCache(String index);

	void _clearAllIndicesCache();

}