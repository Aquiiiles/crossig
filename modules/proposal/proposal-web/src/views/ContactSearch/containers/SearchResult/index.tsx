import Table from "./components/organisms/Table";
import { SearchResultsHeader, Wrapper } from "./styles";
import ClayForm, { ClaySelect } from "@clayui/form";

import * as constants from "./constants/searchResult";

import { providedDataType, responseType } from "./types/searchResult";

interface props {
  data: Array<any>;
  loading: boolean;
}

const SearchResult: React.FC<props> = ({ data, loading }: props) => {
  console.log(data);
  const formatedData = data.map((item: providedDataType) => {
    const responseObj: responseType = {
      [constants.OIB_KEY]: item[constants.OIB_KEY],
      [constants.SUB_KEY]: "",
      [constants.DOB_KEY]: item[constants.DOB_KEY],
      [constants.NAME_KEY]: item[constants.NAME_KEY],
      [constants.STREET_KEY]: "",
      [constants.CITY_KEY]: "",
      [constants.TYPE_KEY]: item[constants.TYPE_KEY].desc,
    };
    return responseObj;
  });

  return (
    <Wrapper>
      <SearchResultsHeader>
        <h6 className="h9">{data.length} Contacts Found</h6>
        <ClayForm.Group>
          <ClaySelect id="cityFilterField">
            <ClaySelect.Option key="City" label="City" value="City" />
          </ClaySelect>
          <ClaySelect id="TypeFilterField">
            <ClaySelect.Option key="Type" label="Type" value="Type" />
          </ClaySelect>
        </ClayForm.Group>
      </SearchResultsHeader>
      <Table
        loading={loading}
        inputData={formatedData}
        onTableSort={() => {}}
      ></Table>
    </Wrapper>
  );
};

export default SearchResult;
