import React from "react";
import { Wrapper, Content, Products, LinkWrapper } from "./styles";
import Stepper from "../ContactSearch/containers/Stepper";
import ProductCard from "./containers/ProductCard";
import productIcon from "../../assets/productIcon.png";
import ClayButton from "@clayui/button";
import { Link } from "react-router-dom";
import useProductState from "./hooks/useProductState";

const InsuranceProduct: React.FC = () => {
  const [products] = useProductState();

  return (
    <Wrapper>
      <Stepper />

      <Content>
        <h5>Insurance Product</h5>
        <p className="body-small" style={{ marginBottom: "2.5rem" }}>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Omnis, iste!
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
          <Link to="/">{"< Back"}</Link>
          <ClayButton displayType="primary" disabled>
            CONTINUE
          </ClayButton>
        </LinkWrapper>
      </Content>
    </Wrapper>
  );
};

export default InsuranceProduct;
