import ClayButton from "@clayui/button";
import ClayModal, { useModal } from "@clayui/modal";
import React, { useState, useEffect } from "react";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";

type propsType = {
  title: string;
  body: React.ReactNode;
  lastButtonTitle?: string;
  lastButtonAction?: () => void;
  timeOut?: number;
  visible: boolean;
  onClose: () => void;
};

const Modal: React.FC<propsType> = (props: propsType) => {
  const [visible, setVisible] = useState(false);
  const { observer, onClose } = useModal({
    onClose: () => setVisible(false)
  });

  useEffect(() => {
    let timeout: NodeJS.Timeout;
    if (visible && props.timeOut) {
      timeout = setTimeout(() => {
        onClose();
      }, props.timeOut);
    }
    return () => {
      timeout && clearTimeout(timeout);
    }
  }, [visible, props.timeOut, onClose]);

  useEffect(() => {
    if (props.visible) {
      setVisible(true);
    } else{
      setVisible(false);
    }
  }, [props.visible]);

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
            {props.body}
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
