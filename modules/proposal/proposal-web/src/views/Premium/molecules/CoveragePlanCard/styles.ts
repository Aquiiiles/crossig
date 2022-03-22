import styled from "styled-components";

export const Wrapper = styled.div`
  background-color: ${(props) => props.theme.color.neutral.background};
  border-radius: 0 12px 12px 0;
  align-items: center;
  width: 70%;
  white-space: nowrap;
  padding-left: 1rem;
  padding-right: 1rem;

  .coverage-title {
    margin-top: 1rem;
  }

  .coverage-description {
    text-align: justify;
    white-space: normal;
    margin-right: 1rem;
  }
`;

export const LabelGroup = styled.div`
  display: flex;
  flex-direction: column;
`;

export const PerilAddOn = styled.div`
  display: flex;
  justify-content: space-between;
`;
