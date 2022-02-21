/* eslint-disable @typescript-eslint/no-explicit-any */
import { useState } from "react";

declare const Liferay: any;

export const getActiveCountries = () => {
  const [countries, setCountries] = useState<Array<any>>();

  Liferay.Service(
    "/country/get-countries",
    {
      active: true,
    },
    (countriesArray: Array<any>) => {
      setCountries(countriesArray);
    }
  );

  return countries;
};
