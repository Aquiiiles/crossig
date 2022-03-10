import ClayModal, { useModal } from "@clayui/modal";
import React, { useState, useEffect } from "react";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";

type propsType = {
  children: React.ReactNode;
  timeOut?: number;
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
    let timeout: NodeJS.Timeout;
    if (visible && props.timeOut) {
      timeout = setTimeout(() => {
        onClose();
      }, props.timeOut);
    }
    return () => {
      timeout && clearTimeout(timeout);
    };
  }, [visible, props.timeOut]);

  useEffect(() => {
    if (props.visible) {
      setVisible(true);
    } else {
      setVisible(false);
    }
  }, [props.visible]);

  return (
    <>
      {visible && (
        <ClayModal
          className="cap"
          observer={observer}
          size="full-screen"
          spritemap={spritemap}
          status="info"
        >
          <ClayModal.Body>{props.children}</ClayModal.Body>
        </ClayModal>
      )}
    </>
  );
};

export default ProposalModal;
