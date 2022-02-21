import API from "../../../../api";

export const searchCitiesByName = async (cityName: string) => {
  const response = await API.get(`/o/agent-portal/address/city?cityName=${cityName}`);
  return response.data;
};

export const searchStreetsByCityIdAndName =
  (cityId: number) => async (streetName: string) => {
    const response = await API.get(
      `/o/agent-portal/address/streets?cityId=${cityId}&streetName=${streetName}`
    );
    return response.data;
  };
