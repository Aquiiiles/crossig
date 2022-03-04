import React from "react";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";
import ClayIcon from "@clayui/icon";

type propsType = {
  sortOrder: string;
};

const ArrowIcon: React.FC<propsType> = (props: propsType) => {
  return (
    <ClayIcon
      spritemap={spritemap}
      symbol={props.sortOrder === "asc" ? "order-arrow-up" : "order-arrow-down"}
    />
  );
};

export default ArrowIcon;
