import { useCallback, useReducer } from "react";

import { fetchDataReducer } from "../reducers/fetchDataReducer";
import { useSafeDispatch } from "./useSafeDispatch";

import { IDLE, PENDING, REJECTED, RESOLVED,SUCCESS_CODE } from "../reducers/constants";

import API from '../';

const initialArgs = {
  status: IDLE,
  response: {
    data: [],
  },
  statusMessage: "",
  statusCode: "",
};

export const useFetchData = () => {
  const [state, unsafeDispatch] = useReducer(
    fetchDataReducer,
    initialArgs
  );

  const dispatch = useSafeDispatch(unsafeDispatch);

  const fetchData = useCallback(
    async (url,params) => {
      dispatch({ type: PENDING });
      API.post(url,params).then(       
          (response) => {
            dispatch({ type: RESOLVED, response });
            console.log('response',response);
          }).catch(
          (error) => {
            dispatch({ type: REJECTED, error });
            console.log('error',error);
          });
    },
   [dispatch]);

  return { state, fetchData, dispatch };
};
