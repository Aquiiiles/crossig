import React from "react";
import { Wrapper, Content, Products, Footer } from "./styles";
import Stepper from "../ContactSearch/containers/Stepper";
import ProductCard from "../../shared/atoms/ProductCard";
import { COVERAGE_PLAN } from "../../constants/languageKeys";
import BackBtn from "../../shared/atoms/BackBtn";
import { useHistory } from "react-router-dom";

const CoveragePlan: React.FC = () => {
  const history = useHistory();

  return (
    <Wrapper>
      <Stepper />

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
                onProductSelection={() => history.replace("/vessel")}
              />
            </>
          ))}
        </Products>
        <Footer>
          <BackBtn pathname="/roles" state={{}} />
        </Footer>
      </Content>
    </Wrapper>
  );
};

export default CoveragePlan;
