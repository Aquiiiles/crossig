import { PENDING, REJECTED, RESOLVED, IDLE } from "./constants";

export function fetchDataReducer(
  state: { response: any },
  action: { type: any; response: { status: any }; error: { message: any } }
) {
  switch (action.type) {
    case IDLE: {
      return { ...state, status: IDLE };
    }
    case PENDING: {
      return { ...state, status: PENDING };
    }
    case RESOLVED: {
      const { status: statusCode } = action.response;
      const status =
        statusCode.toString().substr(0, 1) === "2" ? RESOLVED : REJECTED;
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
