import ClayForm, { ClayInput } from "@clayui/form";
import ClayButton from "@clayui/button";
import React from "react";
import { PREMIUM } from "../../../../constants/languageKeys";
import Line from "../../../../shared/styles/line";
import {
  Title,
  Wrapper,
  PaymentDescription,
  DescriptionWrapper,
} from "./styles";

const PremiumSummary: React.FC = () => {
  const handlePaymentDescription = (category: string) => {
    return (
      <PaymentDescription>
        <label>{category}</label>
        <p>{"56,00 kn"}</p>
      </PaymentDescription>
    );
  };

  const total = (
    <PaymentDescription>
      <p>{PREMIUM.SUMMARY.TOTAL}</p>
      <strong>{"224,00 kn"}</strong>
    </PaymentDescription>
  );

  return (
    <Wrapper id="premium-summary">
      <section>
        <Title>
          <h6>{PREMIUM.SUMMARY.TITLE}</h6>
        </Title>

        <DescriptionWrapper id="description-wrapper">
          {handlePaymentDescription(PREMIUM.SUMMARY.COMPULSORY_LIABILITY)}
          {handlePaymentDescription(PREMIUM.SUMMARY.HULL)}
          {handlePaymentDescription(PREMIUM.SUMMARY.VOLUNTARY_LIABILITY)}
          {handlePaymentDescription(PREMIUM.SUMMARY.LOH)}
          {handlePaymentDescription(PREMIUM.SUMMARY.VOLUNTARY_ACCIDENT)}
          {handlePaymentDescription(PREMIUM.SUMMARY.COMPULSORY_ACCIDENT)}
          {handlePaymentDescription(PREMIUM.SUMMARY.HULL_TUG)}

          {total}
        </DescriptionWrapper>

        <Line />

        <label htmlFor="discountInput">{PREMIUM.SUMMARY.DISCOUNT}</label>
        <ClayForm.Group className="discount-form-group">
          <ClayInput
            type="number"
            onChange={(e) => {
              return;
            }}
          />
          <ClayButton displayType="secondary" className="ghost">
            {PREMIUM.SUMMARY.APPLY_BUTTON}
          </ClayButton>
        </ClayForm.Group>
      </section>
    </Wrapper>
  );
};

export default PremiumSummary;
