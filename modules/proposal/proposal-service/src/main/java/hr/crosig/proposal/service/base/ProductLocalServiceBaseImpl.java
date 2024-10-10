/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.service.base;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import hr.crosig.proposal.model.Product;
import hr.crosig.proposal.service.ProductLocalService;
import hr.crosig.proposal.service.persistence.CoveragePlanPersistence;
import hr.crosig.proposal.service.persistence.InsuredRolePersistence;
import hr.crosig.proposal.service.persistence.PolicyCoverageOptPersistence;
import hr.crosig.proposal.service.persistence.PolicyOptionsPersistence;
import hr.crosig.proposal.service.persistence.ProductPersistence;
import hr.crosig.proposal.service.persistence.ProductRolePersistence;
import hr.crosig.proposal.service.persistence.ProposalContactPersistence;
import hr.crosig.proposal.service.persistence.ProposalPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the product local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link hr.crosig.proposal.service.impl.ProductLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see hr.crosig.proposal.service.impl.ProductLocalServiceImpl
 * @generated
 */
public abstract class ProductLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, ProductLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ProductLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>hr.crosig.proposal.service.ProductLocalServiceUtil</code>.
	 */

	/**
	 * Adds the product to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param product the product
	 * @return the product that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Product addProduct(Product product) {
		product.setNew(true);

		return productPersistence.update(product);
	}

	/**
	 * Creates a new product with the primary key. Does not add the product to the database.
	 *
	 * @param productId the primary key for the new product
	 * @return the new product
	 */
	@Override
	@Transactional(enabled = false)
	public Product createProduct(long productId) {
		return productPersistence.create(productId);
	}

	/**
	 * Deletes the product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productId the primary key of the product
	 * @return the product that was removed
	 * @throws PortalException if a product with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Product deleteProduct(long productId) throws PortalException {
		return productPersistence.remove(productId);
	}

	/**
	 * Deletes the product from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param product the product
	 * @return the product that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Product deleteProduct(Product product) {
		return productPersistence.remove(product);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return productPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Product.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return productPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.ProductModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return productPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.ProductModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return productPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return productPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return productPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Product fetchProduct(long productId) {
		return productPersistence.fetchByPrimaryKey(productId);
	}

	/**
	 * Returns the product with the primary key.
	 *
	 * @param productId the primary key of the product
	 * @return the product
	 * @throws PortalException if a product with the primary key could not be found
	 */
	@Override
	public Product getProduct(long productId) throws PortalException {
		return productPersistence.findByPrimaryKey(productId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(productLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Product.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("productId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			productLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Product.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("productId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(productLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Product.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("productId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return productPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement ProductLocalServiceImpl#deleteProduct(Product) to avoid orphaned data");
		}

		return productLocalService.deleteProduct((Product)persistedModel);
	}

	@Override
	public BasePersistence<Product> getBasePersistence() {
		return productPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return productPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.ProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @return the range of products
	 */
	@Override
	public List<Product> getProducts(int start, int end) {
		return productPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of products.
	 *
	 * @return the number of products
	 */
	@Override
	public int getProductsCount() {
		return productPersistence.countAll();
	}

	/**
	 * Updates the product in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param product the product
	 * @return the product that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Product updateProduct(Product product) {
		return productPersistence.update(product);
	}

	@Deactivate
	protected void deactivate() {
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ProductLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		productLocalService = (ProductLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ProductLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Product.class;
	}

	protected String getModelClassName() {
		return Product.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = productPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Reference
	protected CoveragePlanPersistence coveragePlanPersistence;

	@Reference
	protected InsuredRolePersistence insuredRolePersistence;

	@Reference
	protected PolicyCoverageOptPersistence policyCoverageOptPersistence;

	@Reference
	protected PolicyOptionsPersistence policyOptionsPersistence;

	protected ProductLocalService productLocalService;

	@Reference
	protected ProductPersistence productPersistence;

	@Reference
	protected ProductRolePersistence productRolePersistence;

	@Reference
	protected ProposalPersistence proposalPersistence;

	@Reference
	protected ProposalContactPersistence proposalContactPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		ProductLocalServiceBaseImpl.class);

}