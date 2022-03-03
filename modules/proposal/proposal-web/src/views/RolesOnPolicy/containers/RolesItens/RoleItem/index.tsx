import React from "react";
import { Wrapper } from "./styles";
import ClayIcon from "@clayui/icon";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";

interface roleItem {
  title: string;
  removable: boolean;
  removeRole: () => void;
}

const RoleItem: React.FC<roleItem> = ({ title, removable, removeRole }) => {
  const isNotTitle = (title === "+" || removable);

  return (
    <Wrapper>
      <p onClick={removeRole} className={isNotTitle ? "not-title" : ""}>
        {title === "+" ? <ClayIcon symbol="plus" spritemap={spritemap} /> : title}
        {removable && (
          <>
            {"  "} <ClayIcon symbol="times" spritemap={spritemap} />
          </>
        )}
      </p>
    </Wrapper>
  );
};

export default RoleItem;
