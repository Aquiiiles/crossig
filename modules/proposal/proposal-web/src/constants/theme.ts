import { DefaultTheme } from "styled-components";
import { breakpoints } from "./breakpoints";

const defaultTheme: DefaultTheme = {
  color: {
    primary: {
      main: "#112D82",
      dark: "#102872",
      light: "#0C3D9D",
      links: "#005CD0",
      linksLight: "#93BBFF",
    },
    neutral: {
      black: "#000",
      white: "#FFF",
      background: "#F2F3F4",
      dividerGrey: "#DEDFE0",
      neutralGrey: "#95A0AB",
      neutralGreyText: "#79838C",
      dot: "#898593",
      stepComplete: "#5A5469",
    },
    secondary: {
      1: "#F49F0A",
      2: "#F7B900",
      3: "#F5D306",
      4: "#CEAE00",
      5: "#008C2C",
      6: "#9AD2FE",
      7: "#B03600",
      8: "#F86381",
      9: "#FFBBC0",
    },
    action: {
      default: "#00CB79",
      hover: "#1A5CCC",
      active: "#2172FF",
      navbarLink: "#92A3D7",
      disabled: "#D4D9DE",
    },
    feedback: {
      success: "#00CB79",
      warning: "#FFCF56",
      error: "#FF0000",
    },
  },
  breakpoint: {
    tablet(type) {
      return `(${type === "up" ? "min" : "max"}-width: ${breakpoints.tablet})`;
    },
    mobile(type) {
      return `(${type === "up" ? "min" : "max"}-width: ${breakpoints.mobile})`;
    },
  },
};

export default defaultTheme;
