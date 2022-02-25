import { useCallback, useEffect, useState } from "react";
import { VALIDATOR_MESSAGE } from "../../constants/languageKeys";

/**
 * Keeps track of when a field was visited by the user (`touched`) and applies a message if it was left not filled in.
 * @param isRequiredWhen Optional boolean, if this value changes the hook will reevaluate the required status.
 * @returns
 */
export default function useRequiredField(
  value: string | number,
  isRequiredWhen: boolean
) {
  const [required, setRequired] = useState(true);
  const [touched, setTouched] = useState(false);
  const [warnMessage, setWarnMessage] = useState("");
  const [hasWarnMessage, setHasWarnMessage] = useState(false);

  const onFocus = useCallback(() => {
    setTouched(true);
  }, []);

  const onBlur = () => {
    if (touched && required && value === "") {
      setWarnMessage(VALIDATOR_MESSAGE.REQUIRED_FIELD_LEFT_EMPTY);
    } else {
      setWarnMessage("");
    }
  };

  useEffect(() => {
    if (value !== "") {
      setWarnMessage("");
    }
  }, [value]);

  useEffect(() => {
    if (!isRequiredWhen) {
      setWarnMessage("");
      setRequired(false);
    } else {
      setRequired(true);
    }
  }, [isRequiredWhen]);

  useEffect(() => {
    if (warnMessage === "") {
      setHasWarnMessage(false);
    } else {
      setHasWarnMessage(true);
    }
  }, [warnMessage]);

  return [{ required, onFocus, onBlur }, warnMessage, hasWarnMessage] as const;
}
