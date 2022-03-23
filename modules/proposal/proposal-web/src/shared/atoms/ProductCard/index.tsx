import React from "react";
import { Wrapper, ProductInfoWrapper } from "./style";
import ClayButton from "@clayui/button";
import { Product } from "../../../views/InsuranceProduct/types";
import languageKeys from "../../../constants/Language";

const { INSURANCE_PRODUCT } = languageKeys;

type ProductProps = Product & {
  icon: React.ReactNode;
};

interface props {
  product: ProductProps;
  onProductSelection: (product: ProductProps) => void;
}

const ProductCard: React.FC<props> = ({ product, onProductSelection }) => {
  return (
    <Wrapper>
      {product.icon}
      <ProductInfoWrapper>
        <h6 className="h10">{product.name}</h6>
        <p>{product.description}</p>
      </ProductInfoWrapper>
      <ClayButton
        disabled={!product.active}
        onClick={() => onProductSelection(product)}
        style={{ marginLeft: "auto" }}
      >
        {product.active
          ? INSURANCE_PRODUCT.PRODUCT.SELECT
          : INSURANCE_PRODUCT.COMING_SOON}
      </ClayButton>
    </Wrapper>
  );
};

export default ProductCard;
