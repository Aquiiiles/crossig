import { useEffect, useState } from "react";

type Primitives = boolean | string | number;

/**
 * Hook that can be used to block form submission until all required values are provided.
 * @param watcherValues Values to watch and update the form blocking.
 * @returns {[boolean]} True if the user can submit the form, false otherwise.
 */
export default function useFormState(watcherValues: Array<Primitives>) {
  const [canSubmit, setCanSubmit] = useState(false);
  const form = document.querySelector("form");

  useEffect(() => {
    if (form != null) {
      const requiredInputs = form.querySelectorAll(
        "input:required"
      ) as NodeListOf<HTMLInputElement>;

      if (requiredInputs.length < 1) {
        setCanSubmit(false);
      } else {
        const allFilled = Array.from(requiredInputs).every(
          (input) => input.value !== ""
        );

        if (allFilled && requiredInputs.length > 0) {
          setCanSubmit(true);
        } else {
          setCanSubmit(false);
        }
      }
    }
  }, watcherValues);

  return [canSubmit] as const;
}
