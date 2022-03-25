import { useEffect, useState } from "react";
import { useFetchData } from "../../../api/hooks/useFetchData";
import { PROPOSAL_URL } from "../../../api/constants/routes";
import { RESOLVED } from "../../../api/reducers/constants";

export default function useProposalState(proposalId: number | null) {
  const { state, fetchData: API } = useFetchData();
  const [proposal, setProposal] = useState(null);

  useEffect(() => {
    if (proposalId) {
      API("GET", `${PROPOSAL_URL}/${proposalId}`);
    }
  }, [proposalId]);

  useEffect(() => {
    if (state.status === RESOLVED) {
      setProposal(state.response.data);
    }
  }, [state]);

  return proposal;
}
