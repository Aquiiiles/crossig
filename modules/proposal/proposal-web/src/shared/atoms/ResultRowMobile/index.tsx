import React from "react";

interface PropsType {
  name: string;
  value: string | number;
}

const ResultRowMobile: React.FC<PropsType> = ({ name, value }) => {
  return (
    <>
      <h6 className="h10">{name}</h6>
      <p className="body-small">{value}</p>
    </>
  );
};

export default ResultRowMobile;
