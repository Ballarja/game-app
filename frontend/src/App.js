import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Landing from "./components/Landing";
import { Login } from "./components/Login";
import Registration from "./components/Registration";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Landing />} />
        <Route path="/login" element={<Login />} />
        <Route path="/registration" element={<Registration />} />
        {/* <Route path="/register" element={<Registration />} /> */}
      </Routes>
    </BrowserRouter>
  );
}

export default App;
