import ClayButton from "@clayui/button";
import ClayModal, { useModal } from "@clayui/modal";
import React, { useState } from "react";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";

type propsType = {
  title: string;
  body: string;
  lastButtonTitle?: string;
  lastButtonAction?: () => void;
};

const Modal: React.FC<propsType> = (props: propsType) => {
  const [visible, setVisible] = useState(true);
  const { observer, onClose } = useModal({
    onClose: () => setVisible(false),
  });

  const buttonAction = () => {
    if (props.lastButtonAction) {
      props.lastButtonAction();
    }
    onClose();
  };

  return (
    <>
      {visible && (
        <ClayModal
          observer={observer}
          size="lg"
          spritemap={spritemap}
          status="info"
        >
          <ClayModal.Header>{props.title}</ClayModal.Header>
          <ClayModal.Body>
            <p>{props.body}</p>
          </ClayModal.Body>
          {props.lastButtonAction && (
            <ClayModal.Footer
              last={
                <ClayButton onClick={buttonAction}>
                  {props.lastButtonTitle}
                </ClayButton>
              }
            />
          )}
        </ClayModal>
      )}
    </>
  );
};

export default Modal;
