import ClayIcon from "@clayui/icon";
import React from "react";
import { PREMIUM } from "../../../../constants/languageKeys";
import { CoveragePlan } from "../../../../shared/types/coveragePlan";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";
import { LabelGroup, Wrapper } from "./styles";

type PropsType = {
  coveragePlans: Array<CoveragePlan>;
  statusLookup: Map<number, boolean>;
};

const CoveragePlanList: React.FC<PropsType> = (props: PropsType) => {
  const checkIcon = <ClayIcon spritemap={spritemap} symbol="check" />;

  const isPlanRequired = (coveragePlanId:number) => {
    return coveragePlanId === 0;
  }

  const handleStatusLabel = (coveragePlanId: number) => {
    let label = <>{PREMIUM.COVERAGE.REQUIRED}</>;

    if (props.statusLookup.get(coveragePlanId) && !isPlanRequired(coveragePlanId)) {
      label = (
        <>
          {checkIcon} {PREMIUM.COVERAGE.SELECTED}
        </>
      );
    }

    return label;
  };

  return (
    <Wrapper>
      {props.coveragePlans.map((coveragePlan: CoveragePlan) => {
        return (
          <LabelGroup key={coveragePlan.coveragePlanId}>
            <label htmlFor="coveragePlanStatus">{coveragePlan.name}</label>
            <p id="coveragePlanStatus">
              {handleStatusLabel(coveragePlan.coveragePlanId)}
            </p>
          </LabelGroup>
        );
      })}
    </Wrapper>
  );
};

export default CoveragePlanList;
