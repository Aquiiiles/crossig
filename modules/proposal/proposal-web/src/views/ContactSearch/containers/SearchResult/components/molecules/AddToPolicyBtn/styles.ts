import styled from "styled-components";

export const RolesWrapper = styled.div`
  position: fixed;
  background-color: ${(props) => props.theme.color.neutral.white};
  bottom: 0;
  left: 0;
  width: 100%;
  border-radius: 20px 20px 0px 0px;
  z-index: 3;

  .custom-checkbox {
    margin: 1rem 7rem;
  }
`;

export const Background = styled.div`
  position: fixed;
  background-color: ${(props) => props.theme.color.neutral.black};
  opacity: 0.5;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 2;
`;

export const Buttons = styled.div`
  margin: 1rem 7rem;
  text-align: center;
  button {
    width: 100%;
    margin-bottom: 1rem;
  }
`;
