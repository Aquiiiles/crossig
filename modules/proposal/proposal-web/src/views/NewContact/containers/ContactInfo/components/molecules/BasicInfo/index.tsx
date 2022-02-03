import React from "react";
import { Row, FormSection } from "../../atoms";
import { CREATE_NEW_CONTACT_BASIC_INFO_TITLE } from "../../../../../../../constants/languageKeys";

const BasicInfo: React.FC = () => {
  return (
    <FormSection title={CREATE_NEW_CONTACT_BASIC_INFO_TITLE}>
      <div>
        <p>test</p>
      </div>
      <Row half>
        <input type="text" />
      </Row>
      <Row>
        <input type="text" />
        <input type="text" />
      </Row>
    </FormSection>
  );
};

export default BasicInfo;
