import React from "react";
import ProposalModal from "../../shared/containers/ProposalModal";

type PropsType = {
  children: React.ReactNode;
};

declare const Liferay: any;

// High Order Component
const LiferayEventProvider: React.FC<PropsType> = (props: PropsType) => {
  const [visible, setVisible] = React.useState(false);

  Liferay.on("displayProposalWidget", (_event: Event) => {
    setVisible(true);
  });

  return (
    <ProposalModal
      visible={visible}
      onClose={() => {
        setVisible(false);
        window.location.assign("/group/agent-portal/dashboard");
      }}
    >
      {props.children}
    </ProposalModal>
  );
};

export default LiferayEventProvider;
