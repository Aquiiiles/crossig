import React, { useState } from "react";
import { Row } from "./styles";
import ContactSearch from "../../../../ContactSearch";
import ArrowButton from "../../../../../shared/atoms/ArrowButton";
import ClayTableCell from "@clayui/table/lib/Cell";

const AddRoleRow: React.FC = () => {
  const [showLookup, setShowLookup] = useState(false);

  return (
    <>
      <Row>
        <ClayTableCell colSpan={4}>
          <p onClick={() => setShowLookup(!showLookup)}>
            Add Role {"  "}
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
