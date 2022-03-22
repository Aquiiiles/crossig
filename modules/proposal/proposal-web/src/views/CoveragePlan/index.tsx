import React, { useEffect } from "react";
import { useHistory } from "react-router-dom";
import { Wrapper, Content, Products, Footer, InnerWrapper } from "./styles";
import Stepper from "../../shared/molecules/Stepper";
import ProductCard from "../../shared/atoms/ProductCard";
import BackBtn from "../../shared/atoms/BackBtn";
import { COVERAGE_PLAN } from "../../constants/languageKeys";
import useCoveragePlanState from "./hooks/useCoveragePlanState";
import { useDispatch } from "../../redux/store";
import { actions } from "../../redux/";
import { resetModalScroll } from "../../shared/util/commonFunctions";
import { ROUTES } from "../../constants/routes";

const CoveragePlan: React.FC = () => {
  const history = useHistory();
  const coveragePlans = useCoveragePlanState();
  const dispatch = useDispatch();

  useEffect(() => {
    resetModalScroll();
  }, []);

  return (
    <Wrapper>
      <Stepper currentStep={4} />

      <InnerWrapper>
        <Content>
          <h5>{COVERAGE_PLAN.TITLE}</h5>
          <p className="body-small" style={{ marginBottom: "2.5rem" }}>
            {COVERAGE_PLAN.SUBTITLE}
          </p>
          <Products>
            {coveragePlans.map((coveragePlan, index) => (
              <>
                <ProductCard
                  key={index}
                  product={{
                    active: true,
                    category: "",
                    description: coveragePlan.description,
                    externalId: 0,
                    name: coveragePlan.name,
                    productId: coveragePlan.coveragePlanId,
                    icon: null,
                  }}
                  onProductSelection={() => {
                    dispatch(
                      actions.coveragePlan.setCoveragePlan(coveragePlan)
                    );
                    history.push(ROUTES.VESSEL_SEARCH);
                  }}
                />
              </>
            ))}
          </Products>
          <Footer>
            <BackBtn pathname={ROUTES.ROLES} state={{}} />
          </Footer>
        </Content>
      </InnerWrapper>
    </Wrapper>
  );
};

export default CoveragePlan;
