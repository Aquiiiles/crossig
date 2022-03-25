import { AnyAction } from "@reduxjs/toolkit";
import { Dispatch } from "react";
import { ActionsType } from "../../redux";
import { ProposalContact, ProposalResponse } from "../types/common";
import { ContactInPolicy } from "../types/contact";
import * as constants from "../../constants/RolesOnPolicy";

const setPolicyHolder = (
  dispatch: Dispatch<AnyAction>,
  actions: ActionsType,
  proposalState: ProposalResponse
) => {
  const extNumber = proposalState.policyHolderExtNumber
    ? Number(proposalState.policyHolderExtNumber)
    : "";

  const policyHolder = {
    [constants.EXT_NUMBER_KEY]: extNumber,
  } as ContactInPolicy;

  dispatch(actions.contactsInPolicy.setPolicyHolder(policyHolder));
};

const setContactsInPolicy = (
  dispatch: Dispatch<AnyAction>,
  actions: ActionsType,
  proposalState: ProposalResponse
) => {
  if (proposalState.proposalContacts) {
    proposalState.proposalContacts.forEach((contact: ProposalContact) => {
      const extNumber = contact.contactExtNumber
        ? Number(contact.contactExtNumber)
        : null;

      const contactRoles = contact.insuredRoles
        ? contact.insuredRoles.split(",")
        : [];

      const contactInPolicy = {
        [constants.EXT_NUMBER_KEY]: extNumber,
        [constants.ROLES_KEY]: contactRoles,
      } as ContactInPolicy;

      dispatch(actions.contactsInPolicy.addContact(contactInPolicy));
    });
  }
};

export const setupUpdateProposal = (
  dispatch: Dispatch<AnyAction>,
  actions: ActionsType,
  proposalState: ProposalResponse
) => {
  setContactsInPolicy(dispatch, actions, proposalState);
  setPolicyHolder(dispatch, actions, proposalState);
};
