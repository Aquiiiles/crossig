import { useEffect, useState } from "react";
import { PROPOSAL_URL } from "../../../api/constants/routes";
import { useHttpRequest } from "../../../api/hooks/useHttpRequest";
import { RESOLVED } from "../../../api/reducers/constants";
import { ProposalResponse } from "../../../shared/types/common";

export default function useProposalState(proposalId: number | null) {
  const [state, { fetchData: API }] = useHttpRequest();
  const [proposal, setProposal] = useState<ProposalResponse | null>(null);

  useEffect(() => {
    if (proposalId) {
      API("GET", `${PROPOSAL_URL}/${proposalId}`);
    }
  }, [proposalId]);

  useEffect(() => {
    if (state.status === RESOLVED) {
      setProposal(state.response.data as ProposalResponse);
    }
  }, [state]);

  return proposal;
}
