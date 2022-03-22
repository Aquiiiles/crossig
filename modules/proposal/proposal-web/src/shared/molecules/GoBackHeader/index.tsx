import React from "react";
import BackBtn from "../../atoms/BackBtn";
import { Wrapper } from "./styles";
import { actions } from "../../../redux";
import { useDispatch } from "../../../redux/store";
import { ROUTES } from "../../../constants/routes";

const GoBackHeader: React.FC = () => {
  const dispatch = useDispatch();
  const { setShowMobileSearch } = actions.contactsInPolicy;

  return (
    <Wrapper>
      <BackBtn
        pathname={ROUTES.ROLES}
        state={{}}
        onClick={() => dispatch(setShowMobileSearch(false))}
      ></BackBtn>
    </Wrapper>
  );
};

export default GoBackHeader;
