import React from "react";
import "./Sklep.css";

const Produkt = ({ pr }) => {
  return (
    <div className="wrap">
      <div className="produkt-img">
        <img src={`/assets/produkty/${pr.plik}`} />
        <div className="produkt-info"></div>
        {pr.nazwa} <p>Cena: {pr.cena} zł</p>{" "}
      </div>
    </div>
  );
};
export default Produkt;
