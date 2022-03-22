import React, { useEffect } from "react";
import { ButtonWrapper, Content, Wrapper, InnerWrapper } from "./styles";
import ClayButton from "@clayui/button";
import Stepper from "../../shared/molecules/Stepper";
import { resetModalScroll } from "../../shared/util/commonFunctions";
import { PREMIUM } from "../../constants/languageKeys";
import PolicyPeriod from "./containers/PolicyPeriod";
import Coverage from "./containers/Coverage";
import PremiumSummary from "./containers/PremiumSummary";
import LinkWrapper from "../../shared/atoms/LinkWrapper";
import BackBtn from "../../shared/atoms/BackBtn";

const Premium: React.FC = () => {
  useEffect(() => {
    resetModalScroll();
  }, []);

  return (
    <Wrapper id="premium">
      <Stepper currentStep={6} />

      <InnerWrapper id="inner-wrapper">
        <Content id="content">
          <div className="tablet-padding">
            <h5>{PREMIUM.TITLE}</h5>
            <p className="body-small" style={{ marginBottom: "2.5rem" }}>
              {PREMIUM.SUBTITLE}
            </p>
          </div>
          <PolicyPeriod />
          <PremiumSummary />
          <br></br>
          <Coverage />
        </Content>
        <ButtonWrapper>
          <BackBtn
            pathname="vessel_search"
            state={{ doSearch: true }}
            onClick={() => {
              return;
            }}
          />

          <ClayButton.Group spaced>
            <ClayButton.Group spaced>
              <ClayButton
                id="save-and-resume-later-button"
                displayType="secondary"
                className="ghost"
              >
                {PREMIUM.SAVE_AND_RESUME_BUTTON}
              </ClayButton>
              <ClayButton id="continue-button">
                {PREMIUM.CONTINUE_BUTTON}
              </ClayButton>
            </ClayButton.Group>
          </ClayButton.Group>
        </ButtonWrapper>
      </InnerWrapper>
    </Wrapper>
  );
};

export default Premium;
