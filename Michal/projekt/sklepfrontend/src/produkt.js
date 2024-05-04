import React from "react";
import "./Sklep.css";

const Produkt = ({ pr, addToCart }) => {
  return (
    <div className="wrap">
      <div className="produkt-img">
        <img src={`/assets/produkty/${pr.plik}`} alt={pr.nazwa} />
        <div className="produkt-info">
          <p>{pr.nazwa}</p>
          <p>Cena: {pr.cena} zł</p>
          <button onClick={() => addToCart(pr.id_produktu)}>Add to Cart</button>
        </div>
      </div>
    </div>
  );
};

export default Produkt;
