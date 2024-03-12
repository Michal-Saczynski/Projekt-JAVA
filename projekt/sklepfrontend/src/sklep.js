import React, { useEffect, useState } from "react";
import axios from "axios";
import Produkt from "./produkt";
import "./Sklep.css";

export default function Sklep() {
  const [produkty, setProdukty] = useState([]);
  const [currentPage, setCurrentPage] = useState(0);

  useEffect(() => {
    loadProdukty();
  }, [currentPage]);

  async function loadProdukty() {
    if (currentPage >= 0 && currentPage <= 1) {
      axios
        .get(`http://localhost:8080/produkty?page=${currentPage}`, {
          headers: {
            "Access-Control-Allow-Origin": "*",
          },
        })
        .then((response) => {
          setProdukty(response.data);
          console.log(response.data);
        });
    } else {
      console.log("Nieprawidłowa strona");
    }
  }

  const handleNextPage = () => {
    setCurrentPage((prevPage) => (prevPage < 1 ? prevPage + 1 : prevPage));
  };

  const handlePrevPage = () => {
    setCurrentPage((prevPage) => (prevPage > 0 ? prevPage - 1 : prevPage));
  };

  return (
    <div className="sklep-container">
      <h2>Produkty</h2>
      <div className="produkty-grid">
        {produkty.map((produkt, key) => (
          <Produkt pr={produkt} key={key} />
        ))}
      </div>
      <div className="pagination">
        <button
          className="page-button"
          onClick={handlePrevPage}
          disabled={currentPage === 0}
        >
          Poprzednia strona
        </button>
        <span className="page-number">Strona {currentPage + 1}</span>
        <button
          className="page-button"
          onClick={handleNextPage}
          disabled={currentPage === 1}
        >
          Następna strona
        </button>
      </div>
    </div>
  );
}
