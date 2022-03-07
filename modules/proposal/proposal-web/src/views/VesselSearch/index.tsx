import React from "react";
import { Content, Wrapper, InnerWrapper, LinkWrapper } from "./styles";
import Stepper from "../../shared/molecules/Stepper";
import { VESSEL_LOOKUP } from "../../constants/languageKeys";
import SearchField from "./containers/SearchField";
import { Link } from "react-router-dom";

const VesselSearch: React.FC = () => {
  return (
    <Wrapper>
      <Stepper
        currentStep={5}
        subCategory={{ name: "INSURED_OBJECT_DETAILS", currentStep: 1 }}
      />

      <InnerWrapper>
        <Content>
          <h5>{VESSEL_LOOKUP.TITLE}</h5>
          <p className="body-small" style={{ marginBottom: "2.5rem" }}>
            {VESSEL_LOOKUP.SUBTITLE}
          </p>
          <SearchField onSearchClick={() => true} />
        </Content>
        <LinkWrapper>
          <Link to="/coverage_plan">{VESSEL_LOOKUP.LINK_BACK}</Link>
        </LinkWrapper>
      </InnerWrapper>
    </Wrapper>
  );
};

export default VesselSearch;
