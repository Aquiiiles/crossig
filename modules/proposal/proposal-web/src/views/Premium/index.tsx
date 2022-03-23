import React, { useEffect, useState } from "react";
import { ButtonWrapper, Content, Wrapper, InnerWrapper } from "./styles";
import ClayButton from "@clayui/button";
import Stepper from "../../shared/molecules/Stepper";
import { resetModalScroll } from "../../shared/util/commonFunctions";
import { PREMIUM } from "../../constants/languageKeys";
import PolicyPeriod from "./containers/PolicyPeriod";
import BackBtn from "../../shared/atoms/BackBtn";
import { PROPOSAL_URL } from "../../api/constants/routes";
import API from "../../api";
import { useSelector } from "../../redux/store";
import { contactInPolicy } from "../../redux/contactsInPolicy/types";
import Modal from "../../shared/atoms/Modal";

declare const Liferay: {
  ThemeDisplay: { getUserId: () => number };
};

const Premium: React.FC = () => {
  const state = useSelector((state) => state);
  const [showModal, setShowModal] = useState(false);
  const [isUpdateSuccessful, setUpdateSuccess] = useState(false);

  const createProposalPayload = () => {
    const contactsInPolicy = state.contactsInPolicy.contactsInPolicy;
    const policyHolder = state.contactsInPolicy.policyHolder;
    const insuranceProduct = state.insuranceProduct.insuranceProduct;

    const payload = {
      externalProposalNumber: "",
      agentUserId: Liferay.ThemeDisplay.getUserId(),
      policyHolderExtNumber: policyHolder.id.toString(),
      insuredObjectExtNumber: insuranceProduct.externalId.toString(),
      status: "",
      proposalContacts: contactsInPolicy.map((contact: contactInPolicy) => {
        return {
          contactExtNumber: contact.id.toString(),
          insuredRoles: contact.contactRoles.join(","),
        };
      }),
    };

    return payload;
  };

  const createProposal = () => {
    const payload = createProposalPayload();
    const response = API.post(PROPOSAL_URL, payload);
    resetModalScroll();

    response
      .then(() => {
        setUpdateSuccess(true);
        setShowModal(true);
      })
      .catch(() => {
        setUpdateSuccess(false);
        setShowModal(true);
      });
  };

  useEffect(() => {
    resetModalScroll();
  }, []);

  const modalMessage = (text: string) => {
    return <p style={{ marginLeft: "1.5rem" }}>{text}</p>;
  };

  return (
    <Wrapper id="premium">
      <Stepper currentStep={6} />

      <InnerWrapper id="inner-wrapper">
        <Modal
          visible={showModal && isUpdateSuccessful}
          onClose={() => setShowModal(false)}
          title={PREMIUM.TITLE}
          body={modalMessage(PREMIUM.SUCCESS)}
          timeOut={5000}
        />

        <Modal
          visible={showModal && !isUpdateSuccessful}
          onClose={() => setShowModal(false)}
          title={PREMIUM.TITLE}
          body={modalMessage(PREMIUM.FAILURE)}
          timeOut={5000}
        />

        <Content id="content">
          <div className="tablet-padding">
            <h5>{PREMIUM.TITLE}</h5>
            <p className="body-small" style={{ marginBottom: "2.5rem" }}>
              {PREMIUM.SUBTITLE}
            </p>
          </div>
          <PolicyPeriod />
        </Content>
        <ButtonWrapper>
          <BackBtn pathname="vessel_search" state={{ doSearch: true }} />

          <ClayButton.Group spaced>
            <ClayButton.Group spaced>
              <ClayButton
                id="save-and-resume-later-button"
                displayType="secondary"
                className="ghost"
                onClick={() => createProposal()}
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
