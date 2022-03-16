import ClayModal, { useModal } from "@clayui/modal";
import React, { useState, useEffect } from "react";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";
import { HeaderWrapper, StyledModal } from "./styles";

type PropsType = {
  children: React.ReactNode;
  visible: boolean;
  onClose: () => void;
};

const ProposalModal: React.FC<PropsType> = (props: PropsType) => {
  const [visible, setVisible] = useState(false);
  const { observer, onClose } = useModal({
    onClose: () => {
      setVisible(false), props.onClose();
    },
  });

  useEffect(() => {
    setVisible(props.visible);
  }, [props.visible]);

  return (
    <>
      {visible && (
        <StyledModal
          className="cap"
          observer={observer}
          size="full-screen"
          spritemap={spritemap}
          status="info"
        >
          <HeaderWrapper onClick={onClose} />
          <ClayModal.Body>{props.children}</ClayModal.Body>
        </StyledModal>
      )}
    </>
  );
};

export default ProposalModal;
