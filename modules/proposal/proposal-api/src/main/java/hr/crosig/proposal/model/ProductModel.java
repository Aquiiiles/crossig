/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.AuditedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Product service. Represents a row in the &quot;AP_Proposal_Product&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>hr.crosig.proposal.model.impl.ProductModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>hr.crosig.proposal.model.impl.ProductImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Product
 * @generated
 */
@ProviderType
public interface ProductModel
	extends AuditedModel, BaseModel<Product>, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a product model instance should use the {@link Product} interface instead.
	 */

	/**
	 * Returns the primary key of this product.
	 *
	 * @return the primary key of this product
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this product.
	 *
	 * @param primaryKey the primary key of this product
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the product ID of this product.
	 *
	 * @return the product ID of this product
	 */
	public long getProductId();

	/**
	 * Sets the product ID of this product.
	 *
	 * @param productId the product ID of this product
	 */
	public void setProductId(long productId);

	/**
	 * Returns the company ID of this product.
	 *
	 * @return the company ID of this product
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this product.
	 *
	 * @param companyId the company ID of this product
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this product.
	 *
	 * @return the user ID of this product
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this product.
	 *
	 * @param userId the user ID of this product
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this product.
	 *
	 * @return the user uuid of this product
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this product.
	 *
	 * @param userUuid the user uuid of this product
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this product.
	 *
	 * @return the user name of this product
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this product.
	 *
	 * @param userName the user name of this product
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this product.
	 *
	 * @return the create date of this product
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this product.
	 *
	 * @param createDate the create date of this product
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this product.
	 *
	 * @return the modified date of this product
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this product.
	 *
	 * @param modifiedDate the modified date of this product
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this product.
	 *
	 * @return the name of this product
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this product.
	 *
	 * @param name the name of this product
	 */
	public void setName(String name);

	/**
	 * Returns the external ID of this product.
	 *
	 * @return the external ID of this product
	 */
	public long getExternalId();

	/**
	 * Sets the external ID of this product.
	 *
	 * @param externalId the external ID of this product
	 */
	public void setExternalId(long externalId);

	/**
	 * Returns the active of this product.
	 *
	 * @return the active of this product
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this product is active.
	 *
	 * @return <code>true</code> if this product is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this product is active.
	 *
	 * @param active the active of this product
	 */
	public void setActive(boolean active);

	/**
	 * Returns the description of this product.
	 *
	 * @return the description of this product
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this product.
	 *
	 * @param description the description of this product
	 */
	public void setDescription(String description);

	/**
	 * Returns the category of this product.
	 *
	 * @return the category of this product
	 */
	@AutoEscape
	public String getCategory();

	/**
	 * Sets the category of this product.
	 *
	 * @param category the category of this product
	 */
	public void setCategory(String category);

	@Override
	public Product cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}