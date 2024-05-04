import React from "react";
import MichtechApp from "./MichtechApp.js";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Sklep from "./sklep";
import Menu from "./menu.js";
import Rejestracja from "./rejestracja";
import Logowanie from "./logowanie.js";
import Koszyk from "./koszyk.js";

const App = () => {
  return (
    <BrowserRouter>
      <Menu />
      <div>
        <Routes>
          <Route path="/" element={<MichtechApp />} />
          <Route path="/sklep" element={<Sklep />} />
          <Route path="/rejestracja" element={<Rejestracja />} />
          <Route path="/logowanie" element={<Logowanie />} />
          <Route path="/koszyk" element={<Koszyk />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
};

export default App;
