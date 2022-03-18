import React from "react";
import { Wrapper } from "./styles";
import ResultMobile from "./ResultMobile";
import AddRoleRow from "./AddRoleRow";
import { useSelector, useDispatch } from "../../../../redux/store";
import { actions } from "../../../../redux";

const ResultsMobile: React.FC = () => {
  const dispatch = useDispatch();
  const { policyHolder, contactsInPolicy } = useSelector(
    (state) => state.contactsInPolicy
  );
  const {
    addRoleToPolicyHolder,
    removeRoleFromPolicyHolder,
    addContactRole,
    removeContactRole,
  } = actions.contactsInPolicy;

  return (
    <Wrapper>
      <ResultMobile
        key={0}
        contact={policyHolder}
        policyHolder={true}
        addRole={(title: string) => dispatch(addRoleToPolicyHolder(title))}
        removeRole={(title: string) =>
          dispatch(removeRoleFromPolicyHolder(title))
        }
      />
      {contactsInPolicy.map((contact, index) => (
        <ResultMobile
          key={index + 1}
          contact={contact}
          policyHolder={false}
          addRole={(title: string) => dispatch(addContactRole([index, title]))}
          removeRole={(title: string) =>
            dispatch(removeContactRole([index, title]))
          }
        />
      ))}
      <AddRoleRow />
    </Wrapper>
  );
};

export default ResultsMobile;
