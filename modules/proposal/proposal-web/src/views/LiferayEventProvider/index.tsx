import React, { useEffect, useState } from "react";
import ProposalModal from "../../shared/containers/ProposalModal";

type PropsType = {
  children: React.ReactNode;
};

declare const Liferay: any;

// High Order Component
const LiferayEventProvider: React.FC<PropsType> = (props: PropsType) => {
  const [visible, setVisible] = useState(false);
  const [proposalFriendlyURL, setProposalFriendlyURL] = useState(false);

  Liferay.on("displayProposalWidget", (_event: Event) => {
    setVisible(true);
  });

  useEffect(() => {
    setProposalFriendlyURL(window.location.href.includes("/proposal"));
  }, [window.location.href]);

  return (
    <>
      <ProposalModal
        visible={visible}
        onClose={() => {
          setVisible(false);
        }}
      >
        {props.children}
      </ProposalModal>
      {proposalFriendlyURL && props.children}
    </>
  );
};

export default LiferayEventProvider;
