import React from "react";
import { SubTitle } from "./style";

const SectionSubTitle: React.FC<{ subTitle: string }> = ({ subTitle }) => {
	return <SubTitle>{subTitle}</SubTitle>;
};

export default SectionSubTitle;