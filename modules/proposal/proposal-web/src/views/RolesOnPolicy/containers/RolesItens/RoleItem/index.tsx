import React from "react";
import {Wrapper} from "./styles";

interface roleItem {
  title: string,
  removable: boolean
}

const RoleItem: React.FC<roleItem> = ({ title, removable }) => {
  return (
    <Wrapper>
      <p>{title}{removable && " x"}</p>
    </Wrapper>
  );
};

export default RoleItem;
