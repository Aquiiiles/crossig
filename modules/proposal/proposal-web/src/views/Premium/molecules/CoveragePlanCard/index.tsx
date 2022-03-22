import React from "react";
import { PREMIUM } from "../../../../constants/languageKeys";
import { CoveragePlan } from "../../../../shared/types/coveragePlan";
import { PerilAddOn, Wrapper } from "./styles";
import Line from "../../../../shared/styles/line";
import { ClayCheckbox } from "@clayui/form";

type PropsType = {
  coveragePlan: CoveragePlan;
};

type PerilAddOn = {
  description: string;
  selected: boolean;
};

const CoveragePlanCard: React.FC<PropsType> = (props: PropsType) => {
  const perilAddOns = [
    {
      description: "3rd Party Bodily Injury Liability",
      selected: true,
    },
  ] as Array<PerilAddOn>;

  // TODO: move the PerilAddOn type once it is properly defined.
  const handlePerilAddOns = (perilAddOns: Array<PerilAddOn>) => {
    return perilAddOns.map((addOn: PerilAddOn, index: number) => {
      return (
        <PerilAddOn key={"peril-add-on-" + index}>
          {addOn.description}
          <ClayCheckbox
            checked={addOn.selected}
            onChange={() => {
              return;
            }}
          />
        </PerilAddOn>
      );
    });
  };

  return (
    <Wrapper id="coverage-plan-card">
      <p className="coverage-title">{props.coveragePlan.name}</p>
      <br />
      <label className="coverage-description">
        {props.coveragePlan.description}
      </label>

      <Line />

      <p>{PREMIUM.COVERAGE.PERIL_ADD_ONS}</p>
      {handlePerilAddOns(perilAddOns)}
    </Wrapper>
  );
};

export default CoveragePlanCard;
