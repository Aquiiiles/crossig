import styled from "styled-components";

export const PhoneNumberWrapper = styled.li`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  flex-wrap: wrap;

  & select, input {
    width: 31%;
  }
`;

export const LinkWrapper = styled.div`
  & a {
    color: #394a64;
    text-decoration: underline;
  }
`;
