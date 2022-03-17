import { useEffect, useState } from "react";

type PrimitivesType = boolean | string | number;
type SelectorType = string;

/**
 * Hook that can be used to block form submission until all required values are provided.
 * @param watcherValues Values to watch and update the form blocking.
 * @param formSelectorString String to pass to QuerySelector to locate the form on the page.
 * @returns {[boolean]} True if the user can submit the form, false otherwise.
 */
export default function useFormState(
  watcherValues: Array<PrimitivesType>,
  formSelectorString: SelectorType
) {
  const [canSubmit, setCanSubmit] = useState(false);
  const form = document.querySelector(formSelectorString);

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
