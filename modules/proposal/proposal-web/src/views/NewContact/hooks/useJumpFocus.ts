import { useEffect } from "react";

/**
 * Focus on another element when a value reaches a certain length.
 * @param value String to watch changes from.
 * @param targetId Id for the element that will be focused on when `value` reaches the target length.
 * @param jumpOnLength The length to activate the hook on.
 */
export default function useJumpFocus(
  value: string,
  targetId: string,
  jumpOnLength: number
) {
  useEffect(() => {
    if (value.length >= jumpOnLength) {
      document.getElementById(targetId)?.focus();
    }
  }, [value]);
}
