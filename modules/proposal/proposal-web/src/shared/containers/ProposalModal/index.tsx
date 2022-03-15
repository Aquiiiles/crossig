import ClayModal, { useModal } from "@clayui/modal";
import React, { useState, useEffect } from "react";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";
import { StyledModal } from "./styles";
import { useSelector } from "../../../redux/store";
import { hasMargin } from "./util";

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

  const { currentView } = useSelector((state) => state.viewMapper);
  const headerWithMargin = hasMargin(currentView);

  useEffect(() => {
    setVisible(props.visible);
  }, [props.visible]);

  return (
    <>
      {visible && (
        <StyledModal
          headerMargin={headerWithMargin}
          className="cap"
          observer={observer}
          size="full-screen"
          spritemap={spritemap}
          status="info"
        >
          <ClayModal.Body>
            <ClayModal.Header onClick={onClose} />
            {props.children}
          </ClayModal.Body>
        </StyledModal>
      )}
    </>
  );
};

export default ProposalModal;
