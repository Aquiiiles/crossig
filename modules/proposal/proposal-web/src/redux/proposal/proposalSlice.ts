import { createSlice, PayloadAction } from "@reduxjs/toolkit";

type ProposalSliceType = {
  proposalId: number | null;
};

const initialState = {
  proposalId: null,
} as ProposalSliceType;

const Proposal = createSlice({
  name: "Proposal",
  initialState,
  reducers: {
    setProposalId(state, action: PayloadAction<number>) {
      state.proposalId = action.payload;
    },
    resetFields(state) {
      state = initialState;
    },
  },
});

export const actions = Proposal.actions;

export default Proposal.reducer;
