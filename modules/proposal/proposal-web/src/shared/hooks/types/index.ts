import { actions } from "../../../redux";

type ValidatorReturn = string | undefined;
export type ValidatorFunction = (
  value: string
) => ValidatorReturn | Promise<ValidatorReturn>;

export type PageIndex = number | string;

export type SortableActionKeyType = keyof Pick<
  typeof actions,
  "searchFilter" | "vesselLookupFilter"
>;
