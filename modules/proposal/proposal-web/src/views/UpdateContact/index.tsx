import React, { useEffect } from "react";
import { Content, Wrapper } from "./styles";
import UpdateContactForm from "./containers/UpdateContactForm";
import { useLocation } from "react-router-dom";
import { useHttpRequest } from "../../api/hooks/useHttpRequest";
import { CONTACT_URL } from "../../api/constants/routes";
import { RESOLVED } from "../../api/reducers/constants";
import { resetState } from "../../redux/store";

const hasValidResponse = (contactResponse: any) => {
  return (
    contactResponse &&
    contactResponse[0] &&
    contactResponse[0].addresses &&
    contactResponse[0].subscriptions &&
    contactResponse[0].identifiers &&
    contactResponse[0].telephones
  );
};

const UpdateContact: React.FC = () => {
  resetState();

  const [contactResponse, , { get: fetchContactInfo }] = useHttpRequest();
  const location = useLocation<{ extNumber: number; operation: number }>();
  const { extNumber: externalIDNumber, operation } = location.state;

  useEffect(() => {
    if (externalIDNumber) {
      fetchContactInfo(`${CONTACT_URL}/${externalIDNumber}`);
    }
  }, [externalIDNumber]);

  return (
    <Wrapper>
      {contactResponse.status === RESOLVED &&
        hasValidResponse(contactResponse.response.data) && (
          <Content id="update-contact-main-container">
            <UpdateContactForm
              contactResponse={contactResponse.response.data}
              extNumber={externalIDNumber}
              operation={operation}
            />
          </Content>
        )}
    </Wrapper>
  );
};

export default UpdateContact;
