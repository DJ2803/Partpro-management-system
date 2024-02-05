import React, {useEffect, useState} from "react";
import { animateScroll as scroll } from "react-scroll";
import {
  Nav,
  NavbarContainer,
  NavLogo,
  NavMenu,
  NavItem,
  NavLinks,
  MobileIcon,
  NavBtn,
  NavBtnLink,
} from "./NavbarElements";
import { capgLogo as Logo } from "../../common/imageUrls";
import LogoTM from "../../common/assets/TMLogo.svg";
import { FaBars } from "react-icons/fa";
import { useNavigate } from "react-router-dom";



const Navbar = ({ toggle }) => {
  const navigate=useNavigate();
  const [scrollNav, setScrollNav] = useState(false)
  const changeNav = () => {
    if(window.scrollY >= 80){
      setScrollNav(true)
    }
    else{
      setScrollNav(false)
    }
  }

  useEffect(() => {
    window.addEventListener('scroll', changeNav)
  },[]);

  const toggleHome = () => {
    scroll.scrollToTop()
  }

  // const handleClick=(e)=>
  // {
  //   e.preventDefault()
  //   navigate("/createnewcontract");
  // }
  const handleUploadClick=(e)=>
  {
    e.preventDefault()
    navigate("/uploadfile");
  }
  return (
    <>
      <Nav scrollNav={scrollNav}>
        <NavbarContainer>
          <NavLogo onClick={toggleHome} to="/">
            <img src={Logo} alt="" />
          </NavLogo>
          <MobileIcon onClick={toggle}>
            <FaBars />
          </MobileIcon>
          <NavMenu>
            <NavItem>
              <NavLinks to="smartContract" smooth={true} duration={500} spy={true} exact='true' offset={-80} >About</NavLinks>
            </NavItem>
            <NavItem>
              <NavLinks to="discover" smooth={true} duration={500} spy={true} exact='true' offset={-80} >Discover</NavLinks>
            </NavItem>
            <NavItem>
              <NavLinks to="products" smooth={true} duration={500} spy={true} exact='true' offset={-80} >Create New Product Version</NavLinks>
            </NavItem>
            <NavItem>
              {/* <NavLinks  onClick={event => handleClick(event)}smooth={true} duration={500} spy={true} exact='true' offset={-80} >Create New Product</NavLinks> */}
              <NavLinks to="newproduct" smooth={true} duration={500} spy={true} exact='true' offset={-80} >Create New Product</NavLinks>
            </NavItem>
            <NavItem>
              <NavLinks  onClick={event => handleUploadClick(event)}smooth={true} duration={500} spy={true} exact='true' offset={-80} >Upload File</NavLinks>
            </NavItem>
          </NavMenu>
          <NavLogo onClick={toggleHome} to="/">
            <img style={{background:"white"}} src={LogoTM} alt="" />
            Thought Machine
          </NavLogo>
        </NavbarContainer>
      </Nav>
    </>
  );
};

export default Navbar;
