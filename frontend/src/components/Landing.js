import React, { useState } from "react";
import img from "../assets/GL.png";
import "../components/Landing.css";
import { Navbar, Nav, Container, Image, Button } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-icons/font/bootstrap-icons.css"; // For icons

export default function Landing() {
  const [theme, setTheme] = useState("light"); // Theme state for dark/light mode

  const toggleTheme = () => {
    setTheme(theme === "light" ? "dark" : "light");
  };

  return (
    <div
      className={`landing d-flex flex-column justify-content-center align-items-center ${theme}`}
    >
      {/* Image */}
      <Image src={img} alt="Description of the image" className="large-logo" />

      {/* Button with minimal margin */}
      <Button className="landing-button">Games</Button>

      {/* Navigation Bar */}
      <Navbar bg={theme} expand="sm" fixed="top" className="shadow-sm">
        <Container fluid>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="ms-auto" style={{ justifyContent: "space-evenly" }}>
              <Nav.Link href="#">
                <i className="bi bi-controller"></i> Login
              </Nav.Link>
              <Nav.Link href="#">
                <i className="bi bi-pen"></i> Sign Up
              </Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </div>
  );
}
