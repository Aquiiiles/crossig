import React from "react";
import { Wrapper, Content, Products } from "./styles";
import Stepper from "../ContactSearch/containers/Stepper";
import ProductCard from "./containers/ProductCard";
import productIcon from "../../assets/productIcon.png";

const InsuranceProduct: React.FC = () => {
  return (
    <Wrapper>
      <Stepper />

      <Content>
        <h5>Insurance Product</h5>
        <p className="body-small" style={{ marginBottom: "2.5rem" }}>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Omnis, iste!
        </p>
        <Products>
          <ProductCard
            product={{
              icon: <img src={productIcon} alt="PRODUCT NAME" />,
              name: "PRODUCT NAME",
              description:
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque, quaerat.",
            }}
            onProductSelection={() => true}
          />
          <ProductCard
            product={{
              icon: <img src={productIcon} alt="PRODUCT NAME" />,
              name: "PRODUCT NAME",
              description:
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque, quaerat.",
            }}
            onProductSelection={() => true}
          />
          <ProductCard
            product={{
              icon: <img src={productIcon} alt="PRODUCT NAME" />,
              name: "PRODUCT NAME",
              description:
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque, quaerat.",
            }}
            onProductSelection={() => true}
          />
        </Products>
      </Content>
    </Wrapper>
  );
};

export default InsuranceProduct;
