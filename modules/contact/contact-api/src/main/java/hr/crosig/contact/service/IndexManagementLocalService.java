package hr.crosig.contact.service;

/**
 * @author victor.catanante
 */
public interface IndexManagementLocalService {

	public void clearAllIndicesCache();

	public void clearIndexCache(String index);

	public void populateAllIndices();

}