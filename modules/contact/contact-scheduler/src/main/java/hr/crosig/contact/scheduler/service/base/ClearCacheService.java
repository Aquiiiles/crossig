package hr.crosig.contact.scheduler.service.base;

/**
 * @author victor.catanante
 */
public interface ClearCacheService {

	public void clearIndexCache(String index);

	public void clearAllIndicesCache();

}