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

export const OrderedListWrapper = styled.ol`
  display: grid;
  grid-template-columns: 80%;
  grid-auto-rows: auto;
  row-gap: 1rem;
  list-style-type: none;
  margin: 0;
  padding: 0;
`;