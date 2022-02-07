import styled from "styled-components";

export const PhoneNumberWrapper = styled.li`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  flex-wrap: wrap;

  & select {
    width: 31%;
  }

  & input {
    width: 38%;
  }
`;

export const LinkWrapper = styled.div`
  & a {
    color: #394a64;
    text-decoration: underline;
  }
`;
