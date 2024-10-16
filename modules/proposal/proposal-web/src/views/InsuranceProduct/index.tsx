import React, { useEffect } from "react";
import { Wrapper, Content, Products, Footer, InnerWrapper } from "./styles";
import Stepper from "../../shared/molecules/Stepper";
import ProductCard from "../../shared/atoms/ProductCard";
import useProductState, { sortProducts } from "./hooks/useProductState";
import SuccessBanner from "./containers/SuccessBanner";
import languageKeys from "../../constants/Language";
import BackBtn from "../../shared/atoms/BackBtn";
import { useHistory } from "react-router-dom";
import { useDispatch } from "../../redux/store";
import { actions } from "../../redux/insuranceProduct/insuranceProductSlice";
import { motorIconsMap, vesselsIconsMap } from "./constants";
import { resetModalScroll } from "../../shared/util/commonFunctions";
import { ROUTES } from "../../constants/routes";

const { INSURANCE_PRODUCT } = languageKeys;

const InsuranceProduct: React.FC = () => {
  const [
    products,
    query,
    { firstName, lastName, companyName, contactType },
    { emailAddresses, mobilePhones },
    hasEmailData,
    hasPhoneData,
  ] = useProductState();
  const history = useHistory();
  const dispatch = useDispatch();

  const getProductsIcon = (category: string, index: number) => {
    if (category === "Vessel") {
      return vesselsIconsMap[index];
    } else if (category === "Motor") {
      return motorIconsMap[index];
    }
  };

  useEffect(() => {
    resetModalScroll();
  }, []);

  return (
    <Wrapper>
      <Stepper currentStep={2} />

      <InnerWrapper>
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
              category.sort(sortProducts).map((product, productIndex) => (
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
                        <img
                          src={getProductsIcon(product.category, productIndex)}
                          alt={`Icon for ${product.name}`}
                        />
                      ),
                    }}
                    onProductSelection={() => {
                      dispatch(actions.setInsuranceProduct(product));
                      history.push(ROUTES.ROLES);
                    }}
                  />
                </>
              ))
            )}
          </Products>
        </Content>
        <Footer>
          <BackBtn
            pathname={ROUTES.CONTACT_SEARCH}
            state={{ doSearch: true }}
          />
        </Footer>
      </InnerWrapper>
    </Wrapper>
  );
};

export default InsuranceProduct;
