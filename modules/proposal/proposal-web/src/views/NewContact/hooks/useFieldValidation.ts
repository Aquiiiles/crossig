import React from "react";

type ValidatorReturn = string | undefined;
export type ValidatorFunction = (
  value: string
) => ValidatorReturn | Promise<ValidatorReturn>;

/**
 * Validates fields based on their current values.
 * @param validator A validator function, it receives the current value of the input and returns either a string or undefined.
 * If a string is returned it gets set as the error message that the user sees, if undefined is returned the error is cleared.
 * @returns A ref to attach onto the input to watch for value changes; The error message; A boolean set to true if there is a current error.
 */
export default function useFieldValidation<
  RefElementType extends HTMLInputElement
>(validator: ValidatorFunction) {
  const ref = React.useRef<RefElementType>(null);
  const [errorMessage, setErrorMessage] = React.useState("");
  const [hasError, setHasError] = React.useState(false);

  React.useEffect(() => {
    const validate = async (value: string) => {
      const validatorReturn = await validator(value);

      if (typeof validatorReturn === "string") {
        setErrorMessage(validatorReturn);
        setHasError(true);
      } else {
        setErrorMessage("");
        setHasError(false);
      }
    };

    if (ref.current) {
      validate(ref.current.value);
    }
  }, [ref.current?.value, ref, validator]);

  return [ref, errorMessage, hasError] as const;
}
