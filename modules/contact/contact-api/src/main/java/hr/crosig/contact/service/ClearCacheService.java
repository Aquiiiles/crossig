package hr.crosig.contact.service;

/**
 * @author victor.catanante
 */
public interface ClearCacheService {

	public void clearAllIndicesCache();

	public void clearIndexCache(String index);

}