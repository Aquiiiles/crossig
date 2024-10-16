import React, { useEffect, useState } from "react";
import { Row } from "./styles";
import ContactSearch from "../../../../ContactSearch";
import ArrowButton from "../../../../../shared/atoms/ArrowButton";
import ClayTableCell from "@clayui/table/lib/Cell";
import languageKeys from "../../../../../constants/Language";

const { ROLES_ON_POLICY } = languageKeys;

const AddRoleRow: React.FC<{
  hasInsuredRole: boolean;
}> = ({ hasInsuredRole }) => {
  const [showLookup, setShowLookup] = useState(!hasInsuredRole);

  useEffect(() => {
    setShowLookup(!hasInsuredRole);
  }, [hasInsuredRole]);

  return (
    <>
      <Row>
        <ClayTableCell colSpan={4}>
          <p onClick={() => setShowLookup(!showLookup)} className="add-role">
            {ROLES_ON_POLICY.ADD_ROLE + "  "}
            <ArrowButton
              onClick={() => {
                return;
              }}
              angleUp={showLookup}
            />
          </p>
          {showLookup ? <ContactSearch embedded={true} /> : ""}
        </ClayTableCell>
      </Row>
    </>
  );
};

export default AddRoleRow;
