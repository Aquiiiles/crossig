import { PENDING, REJECTED, RESOLVED, IDLE, SUCCESS_CODE } from "./constants";

export function fetchDataReducer(state: { response: any; }, action: { type: any; response: { statusCode: any; }; error: { message: any; }; }) {
  switch (action.type) {
    case IDLE: {
      return { ...state, status: IDLE };
    }
    case PENDING: {
      return { ...state, status: PENDING };
    }
    case RESOLVED: {
      const { statusCode } = action.response;
      const status = statusCode === SUCCESS_CODE ? RESOLVED : REJECTED;
      return {
        ...state,
        response: { ...state.response, ...action.response },
        status,
      };
    }
    case REJECTED: {
      const error = action.error?.message ? action.error.message : action.error;
      return { ...state, status: REJECTED, error };
    }
    default: {
      throw new Error(`Unhandled action type: ${action.type}`);
    }
  }
}
