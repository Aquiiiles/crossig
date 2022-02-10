import API from "../../../../../../../api";

export const searchCitiesByName = async (cityName: string) => {
	const response = await API.get(`/address/city?cityName=${cityName}`);
	return response.data;
};

export const searchStreetsByCityIdAndName = async (
	cityId: number,
	streetName: string
) => {
	const response = await API.get(
		`/address/streets?cityId=${cityId}&streetName=${streetName}`
	);
	return response.data;
};
