import React, { useEffect } from "react";
import { Content, Wrapper } from "./styles";
import UpdateContactForm from "./containers/UpdateContactForm";
import { useLocation } from "react-router-dom";
import { useFetchData } from "../../api/hooks/useFetchData";
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

  const { state, get } = useFetchData();
  const location = useLocation();
  const extNumber = location.state;

  useEffect(() => {
    if (extNumber) {
      get(`${CONTACT_URL}/${extNumber}`);
    }
  }, [extNumber]);

  return (
    <Wrapper>
      {state.status === RESOLVED && hasValidResponse(state.response.data) && (
        <Content id="update-contact-main-container">
          <UpdateContactForm contactResponse={state.response.data} />
        </Content>
      )}
    </Wrapper>
  );
};

export default UpdateContact;
