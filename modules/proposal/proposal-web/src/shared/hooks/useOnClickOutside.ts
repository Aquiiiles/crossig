import React, { useEffect } from "react";

type Ref<RefType> = React.RefObject<RefType>;
type Handler = (event: MouseEvent | TouchEvent) => void;

/**
 * Hook that takes a ref and a handler function.
 * If user clicks or touches outside of the element the handler function is called.
 * This can be used to call a set function to hide the element, for example.
 * @param ref The element ref to watch for.
 * @param handler The handler function to call when a click outside is made.
 * @param ignoredRef Optional element that if clicked will ignore the default click outside rule and not call the handler.
 */
export default function useOnClickOutside<
  RefType extends HTMLElement,
  IgnoredRef = unknown
>(ref: Ref<RefType>, handler: Handler, ignoredRef?: Ref<IgnoredRef>) {
  useEffect(() => {
    const listener = (event: MouseEvent | TouchEvent) => {
      if (
        !ref.current ||
        event.target === ignoredRef?.current ||
        ref.current.contains(event.target as Node)
      ) {
        return;
      }

      handler(event);
    };

    document.addEventListener("mousedown", listener);
    document.addEventListener("touchstart", listener);

    return () => {
      document.removeEventListener("mousedown", listener);
      document.removeEventListener("touchstart", listener);
    };
  }, [ref, handler]);
}
