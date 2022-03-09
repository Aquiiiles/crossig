import styled from "styled-components";

export const Wrapper = styled.div`
  position: relative;
  display: flex;
  flex-direction: column;
  padding: 1.5rem 0;
  border-bottom: 1px solid ${(props) => props.theme.color.neutral.dividerGrey};

  & .missingInformationIcon {
    position: absolute;
    top: 1.5rem;
    right: 0;
    margin-right: 0 !important;
  }
`;

export const MainGrid = styled.div`
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-template-rows: auto;

  @media ${({ theme }) => theme.breakpoint.mobile("down")} {
    grid-template-columns: 1fr;
  }
`;

export const InnerGrid = styled.div`
  display: grid;
  grid-template-columns: min-content 1fr;
  grid-auto-rows: 1fr;
  column-gap: 2.5rem;

  & > h6 {
    color: ${(props) => props.theme.color.neutral.neutralGreyText};
  }

  & > p {
    color: ${(props) => props.theme.color.neutral.black};
  }
`;

export const ButtonGroup = styled.div`
  display: grid;
  grid-auto-columns: max-content;
  grid-auto-flow: column;
  column-gap: 1rem;
`;
