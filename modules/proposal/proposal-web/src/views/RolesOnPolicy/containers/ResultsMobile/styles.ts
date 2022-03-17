import styled from "styled-components";

export const Wrapper = styled.div`
  display: none;
  flex-direction: column;
  box-shadow: 0px 2px 7px rgba(12, 61, 157, 0.24);
  border-top: 1px solid ${(props) => props.theme.color.neutral.dividerGrey};
  width: calc(100% + 5.3125rem);
  position: relative;
  right: 3.125rem;
  background-color: ${(props) => props.theme.color.neutral.white};

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    display: flex;
  }
`;
