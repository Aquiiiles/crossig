import React from "react";
import { Wrapper, Content, Products, LinkWrapper } from "./styles";
import Stepper from "../ContactSearch/containers/Stepper";
import ProductCard from "./containers/ProductCard";
import productIcon from "../../assets/productIcon.png";
import ClayButton from "@clayui/button";
import { Link } from "react-router-dom";
import useProductState from "./hooks/useProductState";
import { useContactSelector } from "../../redux/store";
import useQueryParams from "../../shared/hooks/useQueryParams";
import SuccessBanner from "./containers/SuccessBanner";
import { INSURANCE_PRODUCT } from "../../constants/languageKeys";

const InsuranceProduct: React.FC = () => {
  const [products] = useProductState();
  const query = useQueryParams();
  const {
    basicInfo: { firstName, lastName, companyName, contactType },
    contactInfo: { emailAddresses, mobilePhones },
  } = useContactSelector(state => state);
  const hasEmailData = emailAddresses[0] !== "";
  const hasPhoneData = mobilePhones[0].phoneNumber !== "";

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
          {products.map(product => (
            <ProductCard
              key={product.productId}
              product={{
                ...product,
                icon: (
                  <img src={productIcon} alt={`Icon for ${product.name}`} />
                ),
                description:
                  "Lorem ipsum dolor sit amet consectetur adipisicing elit. Ea, eaque?",
              }}
              onProductSelection={product => true}
            />
          ))}
        </Products>
        <LinkWrapper>
          <Link to="/">{INSURANCE_PRODUCT.LINK_BACK}</Link>
          <ClayButton displayType="primary" disabled>
            {INSURANCE_PRODUCT.BUTTON_CONTINUE}
          </ClayButton>
        </LinkWrapper>
      </Content>
    </Wrapper>
  );
};

export default InsuranceProduct;
