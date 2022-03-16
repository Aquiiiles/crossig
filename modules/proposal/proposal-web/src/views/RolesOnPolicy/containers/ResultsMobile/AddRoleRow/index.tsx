import React, { useEffect, useState } from "react";
import { Wrapper } from "./styles";
import ContactSearch from "../../../../ContactSearch";
import { ROLES_ON_POLICY } from "../../../../../constants/languageKeys";

const AddRoleRow: React.FC<{
  hasInsuredRole: boolean;
}> = ({ hasInsuredRole }) => {
  const [showLookup, setShowLookup] = useState(!hasInsuredRole);

  useEffect(() => {
    setShowLookup(!hasInsuredRole);
  }, [hasInsuredRole]);

  return (
    <Wrapper>
      <p onClick={() => setShowLookup(!showLookup)} className="add-role">
        {ROLES_ON_POLICY.ADD_ROLE + "  "}
      </p>
      {showLookup ? <ContactSearch embedded={true} /> : ""}
    </Wrapper>
  );
};

export default AddRoleRow;
