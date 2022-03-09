import { useState } from "react";
import { useHistory } from "react-router-dom";
import { useContactDispatch } from "../../../redux/store";
import { actions } from "../../../redux/contactsInPolicySlice";
import { ROLES_ON_POLICY } from "../../../constants/languageKeys";
import * as constants from "../constants/searchResult";
import * as types from "../containers/SearchResult/types/searchResult";

export default function useTableRowState() {
  const [showButtons, setShowButtons] = useState(false);
  const history = useHistory();

  const dispatch = useContactDispatch();
  const { setPolicyHolder } = actions.contactsInPolicy;

  const types = {
    Individual: "F",
    "Self Employed": "O",
    "Legal Entity": "P",
  };

  const formatDOB = (date: string): string => {
    try {
      const [year, month, day] = date.split("-");

      return `${day}/${month}/${year}`;
    } catch (error) {
      return "";
    }
  };

  const openUpdateContact = (extNumber: number) => {
    history.push({
      pathname: "/update_contact",
      state: extNumber,
    });
  };

  const selectContact = (contact: types.responseType) => {
    dispatch(actions.contactsInPolicy.resetFields());
    dispatch(
      setPolicyHolder({
        [constants.EXT_NUMBER_KEY]: contact[constants.EXT_NUMBER_KEY],
        [constants.OIB_KEY]: contact[constants.OIB_KEY],
        [constants.SUB_KEY]: contact[constants.SUB_KEY],
        [constants.NAME_KEY]: contact[constants.NAME_KEY],
        [constants.ROLES_KEY]: [ROLES_ON_POLICY.INSURED],
      })
    );
    history.push("/product");
  };

  return [
    { showButtons },
    {
      setShowButtons,
      formatDOB,
      openUpdateContact,
      selectContact,
    },
    types,
    history,
    dispatch,
  ] as const;
}
