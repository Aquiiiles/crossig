import React, {useEffect} from "react";
import ClayForm, {ClayInput, ClaySelect} from "@clayui/form";
import ClayButton from "@clayui/button";
import {Wrapper, InputWrappers, ButtonsWrapper} from "./styles";
import {
    CONTACT_SEARCH_FIELD_AREA_CODE,
    CONTACT_SEARCH_FIELD_CITY,
    CONTACT_SEARCH_FIELD_COUNTRY_CODE,
    CONTACT_SEARCH_FIELD_EMAIL_ADDRESS,
    CONTACT_SEARCH_FIELD_PHONE_NUMBER,
    CONTACT_SEARCH_FIELD_STREET_ADDRESS
} from "../../../../../../../constants/languageKeys";

import {useFetchData} from "../../../../../../../api/hooks/useFetchData";
import {AREA_CODE_URL} from "../../../../../../../api/constants/routes";

interface IKeys {
    area_name: string;
    area_code: number
};

interface State {
    status: string,
    response: {
        data: {
            area_codes: Array<IKeys>
        },
    },
    statusMessage: string,
    statusCode: string,
}

const SearchFilters: React.FC = () => {
    const [city, setCity] = React.useState("");
    const [street, setStreet] = React.useState("");
    const [countryCode, setCountryCode] = React.useState("");
    const [areaCode, setAreaCode] = React.useState<Array<{ label: string, value: number }>>([]);
    const [phoneNumber, setPhoneNumber] = React.useState("");
    const [email, setEmail] = React.useState("");
    const {state, fetchData: fetchAreaCode} = useFetchData();
    const areaCodeData = state as State;

    const clearValues = () => {
        setCity("");
        setStreet("");
        setCountryCode("");
        setAreaCode([]);
        setPhoneNumber("");
        setEmail("");
    };

    useEffect(() => {
        fetchAreaCode(AREA_CODE_URL, {})

    }, []);

    return (
        <Wrapper>
            <ClayForm.Group>
                <label htmlFor="cityInput">{CONTACT_SEARCH_FIELD_CITY}</label>
                <ClayInput id="cityInput" type="text" onChange={e => setCity(e.target.value.toString())} value={city}/>
            </ClayForm.Group>
            <ClayForm.Group>
                <label htmlFor="streetInput">{CONTACT_SEARCH_FIELD_STREET_ADDRESS}</label>
                <ClayInput id="streetInput" type="text" onChange={e => setStreet(e.target.value.toString())}
                           value={street}/>
            </ClayForm.Group>
            <InputWrappers>
                <ClayForm.Group>
                    <label htmlFor="countryInput">{CONTACT_SEARCH_FIELD_COUNTRY_CODE}</label>
                    <ClayInput id="countryInput" type="text" onChange={e => setCountryCode(e.target.value.toString())}
                               value={countryCode}/>
                </ClayForm.Group>

                <ClayForm.Group>
                    <label htmlFor="countryInput">{CONTACT_SEARCH_FIELD_AREA_CODE}</label>
                    <>
                        {areaCodeData.response.data?.area_codes && (
                            <ClaySelect aria-label={CONTACT_SEARCH_FIELD_AREA_CODE} id="areaInput">
                                {areaCodeData.response.data.area_codes.map((item: IKeys) => (
                                    <ClaySelect.Option
                                        key={item.area_code}
                                        label={item.area_name}
                                        value={item.area_code}
                                    />
                                ))}
                            </ClaySelect>)}
                    </>
                </ClayForm.Group>

                <ClayForm.Group>
                    <label htmlFor="phoneNumber">{CONTACT_SEARCH_FIELD_PHONE_NUMBER}</label>
                    <ClayInput id="phoneNumber" type="text"
                               onChange={e => setPhoneNumber(e.target.value.toString())}
                               value={phoneNumber}/>
                </ClayForm.Group>
            </InputWrappers>
            <ClayForm.Group>
                <label htmlFor="emailInput">{CONTACT_SEARCH_FIELD_EMAIL_ADDRESS}</label>
                <ClayInput id="emailInput" type="text" onChange={e => setEmail(e.target.value.toString())}
                           value={email}/>
            </ClayForm.Group>
            <ButtonsWrapper>
                <ClayButton displayType="link" onClick={clearValues}>
                    Clear
                </ClayButton>
                <ClayButton displayType="primary">Search</ClayButton>
            </ButtonsWrapper>
        </Wrapper>
    );
};

export default SearchFilters;
