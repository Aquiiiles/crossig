import React from "react";

import ClayButton from '@clayui/button';
import ClayIcon from "@clayui/icon";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";
// import { Button } from "./styles";

interface props {
  size: string,
  type: string, // solid, ghost, borderless
  label: string,
  icon: string,
  disabled: boolean
  onClick: () => void;
}

const ButtonCrosig: React.FC<props> = ({
  size,
  type,
  label,
  icon,
  disabled,
  onClick
}: props) => {


  return (
    <ClayButton
      className={`
        btn-${size} ${type}
        ${label === '' ? 'icon-only' : ''}
        ${disabled ? 'disabled' : ''}
      `}
      disabled={disabled}
      onClick={onClick}
    >
      {
        icon !== ""
          ? 
            <span className="icon-btn">
              <ClayIcon symbol={icon} spritemap={spritemap} />
            </span>
          : ""
      }
      {
        label !== ""
          ? label
          : ""
      }
    </ClayButton>
  );
};

export default ButtonCrosig;
