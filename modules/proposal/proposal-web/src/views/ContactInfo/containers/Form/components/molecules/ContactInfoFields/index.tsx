import { Wrapper } from "./styles";
import SectionTitle from "../../../../../../../shared/atoms/SectionTitle";
import {
  CONTACT_INFO_TITLE
} from "../../../../../../../constants/languageKeys";

const ContactInfoFields: React.FC = () =>  {
  return (
    <Wrapper>
      <SectionTitle title={CONTACT_INFO_TITLE} />
    </Wrapper>
  );
};

export default ContactInfoFields;
