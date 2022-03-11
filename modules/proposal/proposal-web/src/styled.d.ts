import "styled-components";

declare module "styled-components" {
  export interface DefaultTheme {
    color: {
      primary: {
        main: string;
        dark: string;
        light: string;
        links: string;
        linksLight: string;
      };
      neutral: {
        black: string;
        white: string;
        background: string;
        dividerGrey: string;
        neutralGrey: string;
        neutralGreyText: string;
      };
      secondary: {
        1: string;
        2: string;
        3: string;
        4: string;
        5: string;
        6: string;
        7: string;
        8: string;
        9: string;
      };
      action: {
        default: string;
        hover: string;
        active: string;
        navbarLink: string;
        disabled: string;
      };
      feedback: {
        success: string;
        warning: string;
        error: string;
      };
    };
    breakpoint: {
      tablet: (type: "up" | "down") => string;
      mobile: (type: "up" | "down") => string;
    };
  }
}
