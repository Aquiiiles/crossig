import React from "react";
import { Wrapper, ProductInfoWrapper } from "./style";
import ClayButton from "@clayui/button";
import { Product } from "../../types/product";
import { INSURANCE_PRODUCT } from "../../../../constants/languageKeys";

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
      {product.active ? (
        <ClayButton onClick={() => onProductSelection(product)}>
          {INSURANCE_PRODUCT.PRODUCT.SELECT}
        </ClayButton>
      ) : null}
    </Wrapper>
  );
};

export default ProductCard;
