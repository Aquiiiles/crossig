import { useEffect, useState } from "react";
import { useFetchData } from "../../../api/hooks/useFetchData";
import { Product } from "../types/product";
import { PRODUCTS_URL } from "../../../api/constants/routes";
import { IDLE } from "../../../api/reducers/constants";

declare const Liferay: {
  ThemeDisplay: { getUserId: () => string };
};

export default function useProductState() {
  const { state, fetchData: API } = useFetchData();
  const [products, setProducts] = useState<Product[]>([]);

  useEffect(() => {
    const userId = Liferay.ThemeDisplay.getUserId();

    API("GET", `${PRODUCTS_URL}/${userId}`);
  }, []);

  useEffect(() => {
    if (state.status !== IDLE) {
      setProducts(state.response.data);
    }
  }, [state]);

  return [products] as const;
}
