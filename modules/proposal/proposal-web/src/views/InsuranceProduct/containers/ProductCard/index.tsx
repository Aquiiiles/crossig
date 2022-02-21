import React from "react";
import { Wrapper, ProductInfoWrapper } from "./style";
import ClayButton from "@clayui/button";
import { Product } from "../../types/product";

type ProductProps = Product & {
  icon: React.ReactNode;
  description: string;
  disabled?: boolean;
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
      {product.disabled ? null : (
        <ClayButton onClick={() => onProductSelection(product)}>
          SELECT
        </ClayButton>
      )}
    </Wrapper>
  );
};

export default ProductCard;
