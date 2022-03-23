import ClayForm, { ClayInput } from "@clayui/form";
import React from "react";
import languageKeys from "../../../../constants/Language";
import { Grid, Title, Wrapper } from "./styles";

const { PREMIUM } = languageKeys;

const PolicyPeriod: React.FC = () => {
  return (
    <Wrapper id="policy-period">
      <section>
        <Title>
          <h6>{PREMIUM.POLICY_PERIOD.TITLE}</h6>
        </Title>
        <Grid>
          <ClayForm.Group>
            <ClayInput.Group>
              <ClayInput.GroupItem>
                <label htmlFor="termPeriodInput">
                  {PREMIUM.POLICY_PERIOD.TERM_PERIOD}
                </label>
                <ClayInput id="termPeriodInput" type="text" />
              </ClayInput.GroupItem>
            </ClayInput.Group>

            <ClayInput.Group className="interval-input-group">
              <ClayInput.GroupItem>
                <label htmlFor="startDateInput">
                  {PREMIUM.POLICY_PERIOD.START_DATE}
                </label>
                <ClayInput id="startDateInput" type="text" />
              </ClayInput.GroupItem>
              <ClayInput.GroupItem>
                <label htmlFor="startTimeInput">
                  {PREMIUM.POLICY_PERIOD.START_TIME}
                </label>
                <ClayInput id="startTimeInput" type="text" />
              </ClayInput.GroupItem>
            </ClayInput.Group>

            <ClayInput.Group>
              <ClayInput.GroupItem>
                <label htmlFor="endDateInput">
                  {PREMIUM.POLICY_PERIOD.END_DATE}
                </label>
                <ClayInput id="endDateInput" type="text" />
              </ClayInput.GroupItem>
              <ClayInput.GroupItem>
                <label htmlFor="endTimeInput">
                  {PREMIUM.POLICY_PERIOD.END_TIME}
                </label>
                <ClayInput id="endTimeInput" type="text" />
              </ClayInput.GroupItem>
            </ClayInput.Group>

            <ClayInput.Group>
              <ClayInput.GroupItem>
                <label htmlFor="issueDateInput">
                  {PREMIUM.POLICY_PERIOD.ISSUE_DATE}
                </label>
                <ClayInput id="issueDateInput" type="text" />
              </ClayInput.GroupItem>
            </ClayInput.Group>
          </ClayForm.Group>
        </Grid>
      </section>
    </Wrapper>
  );
};

export default PolicyPeriod;
