import { AxiosRequestConfig } from "axios";

export type HttpRequesterType<T> = (
  method: NonNullable<AxiosRequestConfig["method"]>,
  url: string,
  params?: AxiosRequestConfig["params"],
  payload?: AxiosRequestConfig["data"],
  mockedData?: AxiosRequestConfig["data"]
) => Promise<T>;
