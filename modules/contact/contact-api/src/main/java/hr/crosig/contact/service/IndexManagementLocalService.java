package hr.crosig.contact.service;

/**
 * @author victor.catanante
 */
public interface IndexManagementLocalService {

	public void clearAllIndicesCache();

	public void clearCityByName(String cityName);

	public void populateAllIndices();

}