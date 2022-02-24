import React from "react";
import Stepper from "../ContactSearch/containers/Stepper";
import { Wrapper } from "./styles";
import BackBtn from "../../shared/atoms/BackBtn";
import ContinueBtn from "../../shared/atoms/ContinueBtn";

const RolesOnPolicy: React.FC = () => {
  return (
    <Wrapper>
      <Stepper />
      <h5>Roles on Policy</h5>;
      <p className="body-small" style={{ marginBottom: "2.5rem" }}>
        SUBTITLE
      </p>
      <BackBtn pathname="/product" state={{ doSearch: true }} />
      <ContinueBtn
        disabled={false}
        onClick={() => {
          return;
        }}
      />
    </Wrapper>
  );
};

export default RolesOnPolicy;
