import React, { useState } from "react";
import Form from "react-bootstrap/Form";
import { useNavigate } from "react-router-dom";
import Button from "react-bootstrap/Button";
import axios from "axios";
import bcrypt from "bcryptjs";

export default function Registration() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

  function validateForm() {
    const regexEmailVerification = /^(.+)@(.+)$/;

    if (email === "" || password === "" || confirmPassword === "") {
      return false;
    } else if (!regexEmailVerification.test(email)) {
      return false;
    } else if (password !== confirmPassword) {
      return false;
    }
    return true;
  }

  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    const hashedPassword = bcrypt.hashSync(password, 10);
    try {
      const registrationResponse = await axios.post("/register", {
        email: email,
        password: password,
      });
      const loginResponse = await axios.post("/login", {
        email: email,
        password: password,
      });
      alert("Registration and Login Success!");
      navigate("/");
    } catch (err) {
      console.error(
        "Error during registration or login:",
        err.response || err.message || err
      );
      alert(
        "Registration or Login failed: " +
          (err.response?.data?.message || err.message || "Unknown error")
      );
    }
  };

  return (
    <div id="registration-page">
      <h1 className="text-center">Register</h1>
      <Form onSubmit={handleSubmit}>
        <Form.Group controlId="formEmail" className="m-5">
          <Form.Label>Email: </Form.Label>
          <Form.Control
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            placeholder="email@gmail.com"
          ></Form.Control>
        </Form.Group>
        <Form.Group controlId="formPassword" className="m-5">
          <Form.Label>Password: </Form.Label>
          <Form.Control
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder="*********"
          ></Form.Control>
        </Form.Group>
        <Form.Group controlId="formConfirmPassword" className="m-5">
          <Form.Label>Verify Password: </Form.Label>
          <Form.Control
            type="password"
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
            placeholder="*********"
          ></Form.Control>
        </Form.Group>
        <Button
          className="mx-5"
          variant="primary"
          type="submit"
          disabled={!validateForm()}
        >
          Submit
        </Button>
      </Form>
    </div>
  );
}
