import React, { useEffect } from "react";
import { PROPOSAL_URL } from "../../api/constants/routes";
import { useFetchData } from "../../api/hooks/useFetchData";
import { RESOLVED } from "../../api/reducers/constants";
import ProposalModal from "../../shared/containers/ProposalModal";

type PropsType = {
  children: React.ReactNode;
};

declare const Liferay: any;

type LiferayProposalEvent = {
  proposalId: number;
};

// High Order Component
const LiferayEventProvider: React.FC<PropsType> = (props: PropsType) => {
  const [visible, setVisible] = React.useState(false);
  const [proposalId, setProposalId] = React.useState<number | null>(null);

  const { state, fetchData: API } = useFetchData();

  useEffect(() => {
    if (proposalId) {
      API("GET", `${PROPOSAL_URL}/${proposalId}`);
    }
  }, [proposalId]);

  useEffect(() => {
    if (state.status === RESOLVED) {
      console.log(state.response.data);
    }
  }, [state]);

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
      {props.children}
    </ProposalModal>
  );
};

export default LiferayEventProvider;
