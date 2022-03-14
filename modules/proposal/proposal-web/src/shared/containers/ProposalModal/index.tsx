import ClayModal, { useModal } from "@clayui/modal";
import React, { useState, useEffect } from "react";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";
import { StyledModal } from "./styles";

type propsType = {
  children: React.ReactNode;
  visible: boolean;
  onClose: () => void;
};

const ProposalModal: React.FC<propsType> = (props: propsType) => {
  const [visible, setVisible] = useState(false);
  const { observer, onClose } = useModal({
    onClose: () => {
      setVisible(false), props.onClose();
    },
  });

  useEffect(() => {
    setVisible(props.visible);
  }, [props.visible]);

  console.log(props.children?.toString);

  return (
    <>
      {visible && (
        <>
          <StyledModal
            className="cap not-clickable-outside"
            observer={observer}
            size="full-screen"
            spritemap={spritemap}
            status="info"
          >
            <ClayModal.Body>
              <ClayModal.Header
                onClick={onClose}
                className="proposal-modal-header"
              />
              {props.children}
            </ClayModal.Body>
          </StyledModal>
        </>
      )}
    </>
  );
};

export default ProposalModal;
