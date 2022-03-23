import { useEffect, useState } from "react";
import { useHttpRequest } from "../../../api/hooks/useHttpRequest";
import { CoveragePlanInterface } from "../types";
import { COVERAGE_PLANS_URL } from "../../../api/constants/routes";
import { IDLE } from "../../../api/reducers/constants";
import { useSelector } from "../../../redux/store";

export default function useCoveragePlan() {
  const [coveragePlanResponse, { fetchData }] = useHttpRequest();
  const [coveragePlans, setCoveragePlans] = useState<CoveragePlanInterface[]>(
    []
  );
  const {
    insuranceProduct: { category },
  } = useSelector((state) => state.insuranceProduct);

  useEffect(() => {
    fetchData("GET", `${COVERAGE_PLANS_URL}${category.toUpperCase()}`);
  }, []);

  useEffect(() => {
    if (coveragePlanResponse.status !== IDLE) {
      setCoveragePlans(coveragePlanResponse.response.data);
    }
  }, [coveragePlanResponse]);

  return coveragePlans;
}
