import { useEffect, useState } from "react";
import { useHttpRequest } from "../../../api/hooks/useHttpRequest";
import { Product } from "../types";
import { PRODUCTS_URL } from "../../../api/constants/routes";
import { IDLE } from "../../../api/reducers/constants";
import useQueryParams from "../../../shared/hooks/useQueryParams";
import { useSelector } from "../../../redux/store";

declare const Liferay: {
  ThemeDisplay: { getUserId: () => string };
};

export const sortProducts = (
  productA: Product,
  productB: Product
): 0 | 1 | -1 => {
  if (productA.active && !productB.active) {
    return -1;
  }

  if (productB.active && !productA.active) {
    return 1;
  }

  return 0;
};

const categorizeProducts = (products: Product[]): Product[][] => {
  return Object.values(
    products.reduce((acc, value) => {
      if (!acc[value.category]) {
        acc[value.category] = [value];
      } else {
        acc[value.category].push(value);
      }
      return acc;
    }, {} as { [categoryKey: string]: Product[] })
  );
};

export default function useProductState() {
  const [productsResponse, { fetchData: fetchProductsForUser }] =
    useHttpRequest();
  const [products, setProducts] = useState<Product[][]>([]);
  const query = useQueryParams();
  const { basicInfo, contactInfo } = useSelector((state) => state);
  const hasEmailData = contactInfo.emailAddresses[0] !== "";
  const hasPhoneData = contactInfo.mobilePhones[0].phoneNumber !== "";

  useEffect(() => {
    const userId = Liferay.ThemeDisplay.getUserId();

    fetchProductsForUser("GET", `${PRODUCTS_URL}/${userId}`);
  }, []);

  useEffect(() => {
    if (productsResponse.status !== IDLE) {
      setProducts(categorizeProducts(productsResponse.response.data));
    }
  }, [productsResponse]);

  return [
    products,
    query,
    basicInfo,
    contactInfo,
    hasEmailData,
    hasPhoneData,
  ] as const;
}
