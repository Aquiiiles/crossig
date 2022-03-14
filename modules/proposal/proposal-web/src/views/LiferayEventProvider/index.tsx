import React, { useState } from "react";
import ProposalModal from "../../shared/containers/ProposalModal";
import { useHistory } from "react-router-dom";

type PropsType = {
  children: React.ReactNode;
};

declare const Liferay: any;

// High Order Component
const LiferayEventProvider: React.FC<PropsType> = (props: PropsType) => {
  const [visible, setVisible] = useState(false);

  Liferay.on("displayProposalWidget", (_event: Event) => {
    setVisible(true);
  });

  return (
    <ProposalModal
      visible={visible}
      onClose={() => {
        setVisible(false);
      }}
    >
      {props.children}
    </ProposalModal>
  );
};

export default LiferayEventProvider;
