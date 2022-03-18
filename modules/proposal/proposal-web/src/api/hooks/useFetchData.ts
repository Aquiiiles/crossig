import { useCallback, useReducer } from "react";
import { fetchDataReducer } from "../reducers/fetchDataReducer";
import { useSafeDispatch } from "./useSafeDispatch";
import { IDLE, PENDING, REJECTED, RESOLVED } from "../reducers/constants";
import { AxiosRequestConfig } from "axios";
import API from "../";

export type FetchDataFunction<T> = (
  method: NonNullable<AxiosRequestConfig["method"]>,
  url: string,
  params?: AxiosRequestConfig["params"],
  payload?: AxiosRequestConfig["data"],
  mockedData?: AxiosRequestConfig["data"]
) => Promise<T>;

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

  const fetchData: FetchDataFunction<void> = useCallback(
    async (method, url, params, payload, mockedData) => {
      if (mockedData) {
        const response = { data: mockedData, status: 200 };
        return dispatch({
          type: RESOLVED,
          response: response,
        });
      }

      dispatch({ type: PENDING });
      try {
        const response = await API({ method, url, params, data: payload });
        dispatch({ type: RESOLVED, response });
      } catch (error) {
        dispatch({ type: REJECTED, error });
      }
    },
    [dispatch]
  );

  const returnFetchData: FetchDataFunction<any> = useCallback(
    async (method, url, params, payload, mockedData) => {
      if (mockedData) {
        const mockPromise = new Promise((resolve) => {
          resolve({ data: mockedData, status: 200 });
        });

        const response = await mockPromise;

        return response;
      }

      const response = await API({ method, url, params, data: payload });
      return response;
    },
    []
  );

  const post = useCallback(
    (url, params) => {
      dispatch({ type: PENDING });
      API.post(url, params)
        .then((response) => {
          dispatch({ type: RESOLVED, response });
        })
        .catch((error) => {
          dispatch({ type: REJECTED, error });
        });
    },
    [dispatch]
  );

  const get = useCallback(
    (url) => {
      dispatch({ type: PENDING });
      API.get(url)
        .then((response) => {
          dispatch({ type: RESOLVED, response });
        })
        .catch((error) => {
          dispatch({ type: REJECTED, error });
        });
    },
    [dispatch]
  );

  const put = useCallback(
    (url, params) => {
      dispatch({ type: PENDING });
      API.put(url, params)
        .then((response) => {
          dispatch({ type: RESOLVED, response });
        })
        .catch((error) => {
          dispatch({ type: REJECTED, error });
        });
    },
    [dispatch]
  );

  return { state, fetchData, returnFetchData, dispatch, post, get, put };
};
