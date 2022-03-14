import React from "react";
import { Wrapper } from "./styles";
import * as types from "../../../types/searchResult";
import ResultMobile from "../../atoms/ResultMobile";
import * as constants from "../../../../../constants/searchResult";

interface Props {
  data: Array<types.responseType>;
  embedded: boolean;
}

const ResultsMobile: React.FC<Props> = ({ data, embedded }) => {
  return (
    <Wrapper>
      {data.map((contact) => (
        <ResultMobile
          key={contact[constants.OIB_KEY]}
          contact={contact}
          embedded={embedded}
        />
      ))}
    </Wrapper>
  );
};

export default ResultsMobile;
