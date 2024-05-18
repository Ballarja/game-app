import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";

export function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const validateForm = () => {
    return email.length > 0 && password.length > 0;
  };

  async function handleSubmit(event) {
    event.preventDefault();
    try {
      const response = await axios.post("/login", {
        email: email,
        password: password,
      });

      alert("Login Success!");
      navigate("/");
    } catch (err) {
      console.error("Error during login:", err.response || err.message || err);
      alert(
        "Login failed: " +
          (err.response?.data?.message || err.message || "Unknown error")
      );
    }
  }

  return (
    <div className="Login">
      <h1 className="m-5 text-center">Log In</h1>
      <Form onSubmit={handleSubmit}>
        <Form.Group controlId="formEmail" className="m-5">
          <Form.Label>Email: </Form.Label>
          <Form.Control
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            placeholder="email@gmail.com"
            required
          ></Form.Control>
        </Form.Group>
        <Form.Group controlId="formPassword" className="m-5">
          <Form.Label>Password: </Form.Label>
          <Form.Control
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder="*********"
            required
          ></Form.Control>
        </Form.Group>
        <Button
          id="login-submit-button"
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
