/* eslint-disable @typescript-eslint/no-explicit-any */
import axios, { HeadersDefaults } from "axios";

declare const Liferay: any;
interface CommonHeaderProperties extends HeadersDefaults {
  "x-csrf-token": string;
}

const API = axios.create({
  baseURL: "/o/agent-portal",
  params: {
    p_auth: Liferay.authToken,
  },
});

API.defaults.headers = {
  "x-csrf-token": Liferay.authToken,
} as CommonHeaderProperties;

export default API;
