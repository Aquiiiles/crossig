import ClayForm from "@clayui/form";
import SectionTitle from "../../../../../../../shared/atoms/SectionTitle";
import SubtitledLabel from "../../atoms/SubtitledLabel";
import { Wrapper, InputWrapper } from "./styles";
import {
  CONTACT_INFO_TITLE
} from "../../../../../../../constants/languageKeys";

const ContactInfoFields: React.FC = () =>  {
  return (
    <Wrapper>
      <SectionTitle title={CONTACT_INFO_TITLE} />
      <InputWrapper>
          <ClayForm.Group>         
            <SubtitledLabel title="Main Email" subTitle={"(Optional)"} />
          </ClayForm.Group>
       </InputWrapper>

      <InputWrapper>
        <ClayForm.Group>
          <SubtitledLabel title="Main Mobile" subTitle={"(Optional)"} />
        </ClayForm.Group>
      </InputWrapper>
    </Wrapper>
  );
};

export default ContactInfoFields;
