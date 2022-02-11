import { 
  croatiaAddressesCountryObject,
  croatiaContactInfoCountryObject
} from "../../constants/contactConstants";

import { Country } from "../../views/NewContact/containers/ContactInfo/components/atoms/PhoneInputList";

export const mapToAddressCountries = (countriesArray:Array<any>) => {
    const countries = countriesArray
        .map((country) => {
            return {
                label: country.nameCurrentValue,
                value: country.countryId
            };
        })
        .filter((country) => country.label !== croatiaAddressesCountryObject.label);
    countries.unshift(croatiaAddressesCountryObject);

    return countries;
}

export const mapToContactInfoFormCountries = (countriesArray:Array<any>) => {
    const countries = countriesArray
        .map((country) => {
            return {
                label: country.idd,
                value: country.idd,
                flagKey: country.a2
            } as Country;
        })
        .filter((country) => country.label !== croatiaContactInfoCountryObject.label);
    countries.unshift(croatiaContactInfoCountryObject);

    return countries;
}