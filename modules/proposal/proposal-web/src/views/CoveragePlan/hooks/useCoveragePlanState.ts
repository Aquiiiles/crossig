import { useEffect, useState } from "react";
import { useFetchData } from "../../../api/hooks/useFetchData";
import { CoveragePlan } from "../types/coveragePlan";
import { COVERAGE_PLANS_URL } from "../../../api/constants/routes";
import { IDLE } from "../../../api/reducers/constants";
import { useContactSelector } from "../../../redux/store";

export default function useCoveragePlan() {
  const { state, fetchData: API } = useFetchData();
  const [coveragePlans, setCoveragePlans] = useState<CoveragePlan[]>([]);
  const { insuranceProduct } = useContactSelector((state) => state.insuranceProduct);

  useEffect(() => {
    API("GET", `${COVERAGE_PLANS_URL}${insuranceProduct.category.toUpperCase()}`);
  }, []);

  useEffect(() => {
    if (state.status !== IDLE) {
      setCoveragePlans(state.response.data);
    }
  }, [state]);

  return coveragePlans;
}
