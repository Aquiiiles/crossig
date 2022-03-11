import React from "react";
import { Wrapper } from "./styles";
import * as types from "../../../types/searchResult";
import ResultMobile from "../../atoms/ResultMobile";
import * as constants from "../../../../../constants/searchResult";

interface Props {
  data: Array<types.responseType>;
}

const ResultsMobile: React.FC<Props> = ({ data }) => {
  return (
    <Wrapper>
      {data.map((contact) => (
        <ResultMobile key={contact[constants.OIB_KEY]} contact={contact} />
      ))}
    </Wrapper>
  );
};

export default ResultsMobile;
