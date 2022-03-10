import React, { useState } from "react";
import ProposalModal from "../../shared/containers/ProposalModal";

type PropsType = {
  children: React.ReactNode;
};

declare const Liferay: any;

// High Order Component
const LiferayEventProvider: React.FC<PropsType> = (props: PropsType) => {
  const [visible, setVisible] = useState(false);

  Liferay.on("displayProposalWidget", (event: Event) => {
    setVisible(true);
  });

  return (
    <ProposalModal
      visible={visible}
      onClose={() => {
        return;
      }}
    >
      {props.children}
    </ProposalModal>
  );
};

export default LiferayEventProvider;
