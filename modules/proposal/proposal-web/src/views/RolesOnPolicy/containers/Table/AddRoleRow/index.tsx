import React, { useState } from "react";
import { Row } from "./styles";
import ContactSearch from "../../../../ContactSearch";
import ArrowButton from "../../../../../shared/atoms/ArrowButton";
import ClayTableCell from "@clayui/table/lib/Cell";
import { ROLES_ON_POLICY } from "../../../../../constants/languageKeys";

const AddRoleRow: React.FC<{ hasInsuredRole: boolean }> = ({
  hasInsuredRole,
}) => {
  const [showLookup, setShowLookup] = useState(!hasInsuredRole);

  return (
    <>
      <Row>
        <ClayTableCell colSpan={4}>
          <p onClick={() => setShowLookup(!showLookup)}>
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
