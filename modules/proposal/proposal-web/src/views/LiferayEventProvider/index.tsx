import React from "react";
import ProposalModal from "../../shared/containers/ProposalModal";
import useProposalState from "./hooks/useProposalState";
import Proposal from "../Proposal";

declare const Liferay: any;

type LiferayProposalEvent = {
  proposalId: number;
};

// High Order Component
const LiferayEventProvider: React.FC = () => {
  const [visible, setVisible] = React.useState(false);
  const [proposalId, setProposalId] = React.useState<number | null>(null);

  const proposalState = useProposalState(proposalId);

  Liferay.on("displayProposalWidget", (event: LiferayProposalEvent) => {
    if (event.proposalId) {
      setProposalId(event.proposalId);
    }

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
      <Proposal proposalState={proposalState}/>
    </ProposalModal>
  );
};

export default LiferayEventProvider;
