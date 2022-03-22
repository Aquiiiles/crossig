import React from "react";
import { PREMIUM } from "../../../../constants/languageKeys";
import { CoveragePlan } from "../../../../shared/types/coveragePlan";
import CoveragePlanCard from "../../molecules/CoveragePlanCard";
import CoveragePlanList from "../../molecules/CoveragePlanList";
import { Wrapper } from "./styles";

const CoveragePlanDetails: React.FC = () => {
  const description =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus tristique odio leo, id luctus eros pellentesque sed. Mauris tristique a diam nec posuere.";

  const coveragePlans = [
    {
      category: "",
      coveragePlanId: 0,
      description: description,
      name: "Compulsory Liability",
    },
    {
      category: "",
      coveragePlanId: 1,
      description: description,
      name: "Voluntary Accident",
    },
    {
      category: "",
      coveragePlanId: 2,
      description: description,
      name: "Compulsory Accident",
    },
  ] as Array<CoveragePlan>;

  const handleStatusLookup = () => {
    const statusLookup = new Map<number, boolean>();

    coveragePlans.forEach((coveragePlan: CoveragePlan) => {
      statusLookup.set(coveragePlan.coveragePlanId, true);
    });

    return statusLookup;
  };

  return (
    <Wrapper id="coverage-plan-details">
      <CoveragePlanList
        coveragePlans={coveragePlans}
        statusLookup={handleStatusLookup()}
      />

      <CoveragePlanCard coveragePlan={coveragePlans[0]} />
    </Wrapper>
  );
};

export default CoveragePlanDetails;
