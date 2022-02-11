package hr.crosig.contact.service;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author victor.catanante
 */
public interface IndexManagementLocalService {

	public void clearAllIndicesCache() throws PortalException;

	public void clearCityByName(String cityName) throws PortalException;

	public void clearStreets() throws PortalException;

	public void populateAllIndices();

}