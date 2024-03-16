import React, { useState } from "react";
// import { herosectionbg2 as Image } from "../../common/imageUrls";
import Image from "../../common/assets/bgImage.jpg";
import {
  HeroContainer,
  HeroBg,
  ImageBg,
  HeroContent,
  HeroH1,
  HeroP,
  HeroBtnWrapper,
  ArrowForward,
  ArrowRight,
} from "./HeroElements";
import { Button } from "../ButtonElement";
import Navbar2 from "../../components/Navbar/index";
const HeroSection = () => {
  const [hover, setHover] = useState(false);

  const onHover = () => {
    setHover(!hover);
  };
  return (
    <>
    <Navbar2 />
    <HeroContainer>
      <HeroBg>
        <ImageBg src={Image} />
      </HeroBg>
      <HeroContent>
        <HeroH1>Part Pro Management System</HeroH1>
        <HeroP>
          <br />
          A Part Pro Management System  website is used to buy vehicle related parts and products. This application will be used by customers and employees. Customers will add their vehicle related details and  the relative products will be dynamically displayed in the customized dashboard page. User will checkout the products and complete the payment through payment gateways. Employees will use the application to add products in their inventory by selecting available suppliers and available products from the suppliers. Employees can view and manage the online sales.
           </HeroP>
        <HeroBtnWrapper>
          <Button
            to="smartContract"
            onMouseEnter={onHover}
            onMouseLeave={onHover}
            primary="true"
            dark="true"
          >
            Get Started {hover ? <ArrowForward /> : <ArrowRight />}
          </Button>
        </HeroBtnWrapper>
      </HeroContent>
    </HeroContainer>
    </>
  );
};

export default HeroSection;
