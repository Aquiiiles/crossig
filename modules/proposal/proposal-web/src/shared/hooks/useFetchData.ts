import { useCallback, useReducer } from "react";

import { fetchDataReducer } from "../reducers/fetchDataReducer";
import { useSafeDispatch } from "./useSafeDispatch";

import { IDLE, PENDING, REJECTED, RESOLVED,SUCCESS_CODE } from "../reducers/constants";

const initialArgs = {
  status: IDLE,
  response: {
    data: [],
  },
  statusMessage: "",
  statusCode: "",
};
declare const Liferay: any;

export const useFetchData = () => {
  const [state, unsafeDispatch] = useReducer(
    fetchDataReducer,
    initialArgs
  );

  const dispatch = useSafeDispatch(unsafeDispatch);

  const fetchData = useCallback(
    async (url,params) => {
      dispatch({ type: PENDING });
      return new Promise((resolve, reject) => {
        Liferay.Service(
            url,
          {
            ...params,
          },
          (response: { statusCode: any; }) => {
            dispatch({ type: RESOLVED, response });
            response.statusCode === SUCCESS_CODE
              ? resolve(RESOLVED)
              : reject(REJECTED);
          },
          (error: any) => {
            dispatch({ type: REJECTED, error });
            reject(REJECTED);
          }
        );
      });
    },
   [dispatch]);

  return { state, fetchData, dispatch };
};
