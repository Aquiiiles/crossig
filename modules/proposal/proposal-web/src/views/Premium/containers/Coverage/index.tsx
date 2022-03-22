import ClayForm, { ClayInput } from "@clayui/form";
import React from "react";
import { PREMIUM } from "../../../../constants/languageKeys";
import FormSection from "../../../../shared/atoms/contact/FormSection";
import Row from "../../../../shared/atoms/contact/Row";
import CoveragePlanDetails from "../CoveragePlanDetails";
import { LabelGroup, Wrapper } from "./styles";

const Coverage: React.FC = () => {
  return (
    <Wrapper id="coverage">
      <FormSection title={PREMIUM.COVERAGE.TITLE}>
        <Row className="vessel-description-row">
          <LabelGroup>
            <label htmlFor="vesselName">{PREMIUM.COVERAGE.VESSEL_NAME}</label>
            <p id="vesselName">{"Oasis of the Sea"}</p>
          </LabelGroup>

          <LabelGroup>
            <label htmlFor="registrationMark">
              {PREMIUM.COVERAGE.REGISTRATION_MARK}
            </label>
            <p id="registrationMark">{"ABC123"}</p>
          </LabelGroup>

          <LabelGroup>
            <label htmlFor="totalVesselValue">
              {PREMIUM.COVERAGE.TOTAL_VESSEL_VALUE}
            </label>
            <p id="totalVesselValue">{"10,000 kn"}</p>
          </LabelGroup>
        </Row>
      </FormSection>
      <br></br>
      <Row className="vessel-description-row">
        <LabelGroup>
          <label htmlFor="coveragePlan">{PREMIUM.COVERAGE.COVERAGE_PLAN}</label>
          <p id="coveragePlan">{"Compulsory Liability Only"}</p>
        </LabelGroup>
      </Row>
      <CoveragePlanDetails />
    </Wrapper>
  );
};

export default Coverage;
