import { useHistory } from "react-router-dom";
import * as constants from "../constants/searchResult";
import * as types from "../containers/SearchResult/types";
import { useDispatch } from "../../../redux/store";
import { actions } from "../../../redux";
import languageKeys from "../../../constants/Language";
import { ROUTES } from "../../../constants/routes";

const { ROLES_ON_POLICY } = languageKeys;

export default function useTableRowState(operation: number) {
  const history = useHistory();
  const { setPolicyHolder } = actions.contactsInPolicy;
  const dispatch = useDispatch();

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
      pathname: ROUTES.UPDATE_CONTACT,
      state: { extNumber, operation: operation },
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
    history.push(ROUTES.PRODUCT);
  };

  return [
    {
      formatDOB,
      openUpdateContact,
      selectContact,
    },
    types,
    history,
    dispatch,
  ] as const;
}
