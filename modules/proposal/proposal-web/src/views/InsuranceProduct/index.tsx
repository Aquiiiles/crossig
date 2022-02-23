import React from "react";
import { Wrapper, Content, Products, LinkWrapper } from "./styles";
import Stepper from "../ContactSearch/containers/Stepper";
import ProductCard from "./containers/ProductCard";
import productIcon from "../../assets/productIcon.png";
import ClayButton from "@clayui/button";
import { Link } from "react-router-dom";
import useProductState from "./hooks/useProductState";
import SuccessBanner from "./containers/SuccessBanner";
import { INSURANCE_PRODUCT } from "../../constants/languageKeys";

const InsuranceProduct: React.FC = () => {
  const [
    products,
    query,
    { firstName, lastName, companyName, contactType },
    { emailAddresses, mobilePhones },
    hasEmailData,
    hasPhoneData,
  ] = useProductState();

  return (
    <Wrapper>
      <Stepper />

      <Content>
        {query.get("success") ? (
          <SuccessBanner
            contact={{
              firstName: firstName,
              lastName: lastName,
              companyName: companyName,
              type: contactType,
              mainEmail: hasEmailData ? emailAddresses[0] : undefined,
              mainMobile: hasPhoneData
                ? {
                    countryCode: mobilePhones[0].countryCode,
                    areaCode: mobilePhones[0].areaCode,
                    number: mobilePhones[0].phoneNumber,
                  }
                : undefined,
            }}
          />
        ) : null}
        <h5>{INSURANCE_PRODUCT.TITLE}</h5>
        <p className="body-small" style={{ marginBottom: "2.5rem" }}>
          {INSURANCE_PRODUCT.SUBTITLE}
        </p>
        <Products>
          {products.map((category, categoryIndex) =>
            category.map((product, productIndex) => (
              <>
                {productIndex === 0 ? (
                  <h6
                    style={
                      categoryIndex > 0 ? { marginTop: "2rem" } : undefined
                    }
                  >
                    {product.category}
                  </h6>
                ) : null}
                <ProductCard
                  key={product.productId}
                  product={{
                    ...product,
                    icon: (
                      <img src={productIcon} alt={`Icon for ${product.name}`} />
                    ),
                  }}
                  onProductSelection={(product) => true}
                />
              </>
            ))
          )}
        </Products>
        <LinkWrapper>
          <Link to={{ pathname: "/", state: { doSearch: true } }}>
            {INSURANCE_PRODUCT.LINK_BACK}
          </Link>
        </LinkWrapper>
      </Content>
    </Wrapper>
  );
};

export default InsuranceProduct;
