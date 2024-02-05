import React from "react";
import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Home from "./pages";
import CreateContract from "./pages/createContract";
import CreateNewContract from  "./pages/createNewContract"
import Footer from "./components/Footer";

function App() {
  return (
  <>
    <Router>
      <Routes>
        <Route path='/' element={<Home/>} exact/>
        <Route path='/visualize/:param' element={<CreateContract/>} exact />
        <Route path='/validatemodel/:param' element={<CreateNewContract/>} exact />
       
      </Routes>
    </Router>
    <Footer />
    </>
  );
};

export default App;
