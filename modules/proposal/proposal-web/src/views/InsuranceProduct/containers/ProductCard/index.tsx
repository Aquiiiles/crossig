import React from "react";
import { Wrapper, ProductInfoWrapper } from "./style";
import ClayButton from "@clayui/button";

interface props {
  product: {
    icon: React.ReactNode;
    name: string;
    description: string;
  };
  onProductSelection: (productName: string) => void;
}

const ProductCard: React.FC<props> = ({
  product: { icon, name, description },
  onProductSelection,
}) => {
  return (
    <Wrapper>
      {icon}
      <ProductInfoWrapper>
        <h6 className="h10">{name}</h6>
        <p>{description}</p>
      </ProductInfoWrapper>
      <ClayButton onClick={() => onProductSelection(name)}>SELECT</ClayButton>
    </Wrapper>
  );
};

export default ProductCard;
