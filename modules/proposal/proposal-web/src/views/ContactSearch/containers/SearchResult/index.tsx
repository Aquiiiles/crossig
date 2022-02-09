import { useEffect } from "react";
import { useFetchData } from "../../../../api/hooks/useFetchData";
import Table from "./components/organisms/Table";
import {Wrapper} from "./styles";

import * as constants from "./constants/searchResult";

import { providedDataType , responseType} from "./types/searchResult";

interface props {
  data: Array<any>
  loading:boolean
}

const SearchResult: React.FC<props> = ({data, loading}:props) => {
  console.log(data);
  const formatedData = data.map((item:providedDataType) => {
    console.log(item);
    const responseObj:responseType = {
      [constants.OIB_KEY]: item[constants.OIB_KEY],
      [constants.SUB_KEY]: "",
      [constants.DOB_KEY]: item[constants.DOB_KEY],
      [constants.NAME_KEY]: item[constants.NAME_KEY],
      [constants.STREET_KEY]: item.addresses[0].street_address,
      [constants.CITY_KEY]: item.addresses[0].city,
      [constants.TYPE_KEY]: item[constants.TYPE_KEY],
    };
    return(responseObj);
  });

  return (
    <Wrapper>
      <h5>{data.length} Contacts Found</h5>
      <Table loading={loading} inputData={formatedData} onTableSort={()=>{}} ></Table>

    </Wrapper>
  );
};

export default SearchResult;
