import { useCallback, useReducer } from "react";

import { fetchDataReducer } from "../reducers/fetchDataReducer";
import { useSafeDispatch } from "./useSafeDispatch";

import {
  IDLE,
  PENDING,
  REJECTED,
  RESOLVED,
} from "../reducers/constants";

import API from "../";
import { AxiosRequestConfig } from "axios";

export type FetchDataFunction = (
  method: NonNullable<AxiosRequestConfig["method"]>,
  url: string,
  params?: AxiosRequestConfig["params"],
  data?: AxiosRequestConfig["data"]
) => Promise<void>;

const initialArgs = {
  status: IDLE,
  response: {
    data: [],
  },
  statusMessage: "",
  statusCode: "",
};

export const useFetchData = () => {
  const [state, unsafeDispatch] = useReducer(fetchDataReducer, initialArgs);

  const dispatch = useSafeDispatch(unsafeDispatch);

  const fetchData: FetchDataFunction = useCallback(
    async (method, url, params, data) => {
      dispatch({ type: PENDING });
      try {
        const response = await API({ method, url, params, data });
        dispatch({ type: RESOLVED, response });
      } catch (error) {
        dispatch({ type: REJECTED, error });
      }
    },
    [dispatch]
  );

  const get = useCallback(
    (url) => {
      dispatch({ type: PENDING });
      API.get(url)
        .then(response => {
          dispatch({ type: RESOLVED, response });
        })
        .catch(error => {
          dispatch({ type: REJECTED, error });
        });
    },
    [dispatch]
  );

  const put = useCallback(
    (url, params) => {
      dispatch({ type: PENDING });
      API.put(url, params)
        .then(response => {
          dispatch({ type: RESOLVED, response });
        })
        .catch(error => {
          dispatch({ type: REJECTED, error });
        });
    },
    [dispatch]
  );

  return { state, fetchData, dispatch, get, put };
};
