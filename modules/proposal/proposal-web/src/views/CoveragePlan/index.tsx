import React from "react";
import { Wrapper, Content, Products, Footer, InnerWrapper } from "./styles";
import Stepper from "../../shared/molecules/Stepper";
import ProductCard from "../../shared/atoms/ProductCard";
import { COVERAGE_PLAN } from "../../constants/languageKeys";
import BackBtn from "../../shared/atoms/BackBtn";
import { useHistory } from "react-router-dom";

const CoveragePlan: React.FC = () => {
  const history = useHistory();

  return (
    <Wrapper>
      <Stepper currentStep={4} />

      <InnerWrapper>
        <Content>
          <h5>{COVERAGE_PLAN.TITLE}</h5>
          <p className="body-small" style={{ marginBottom: "2.5rem" }}>
            {COVERAGE_PLAN.SUBTITLE}
          </p>
          <Products>
            {COVERAGE_PLAN.PRODUCTS.map((product, index) => (
              <>
                <ProductCard
                  key={index}
                  product={{
                    active: true,
                    category: "",
                    description: product.DESC,
                    externalId: 0,
                    name: product.TITLE,
                    productId: 0,
                    icon: null,
                  }}
                  onProductSelection={() => history.push("/vessel-search")}
                />
              </>
            ))}
          </Products>
          <Footer>
            <BackBtn pathname="/roles" state={{}} />
          </Footer>
        </Content>
      </InnerWrapper>
    </Wrapper>
  );
};

export default CoveragePlan;
