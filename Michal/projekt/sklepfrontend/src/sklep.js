import axios from "axios";
import React, { useEffect, useState } from "react";
import "./Sklep.css";
import Produkt from "./produkt";

export default function Sklep() {
  const [produkty, setProdukty] = useState([]);
  const [currentPage, setCurrentPage] = useState(0);
  const [cart, setCart] = useState([]);
  const [userId, setUserId] = useState(null);

  useEffect(() => {
    loadProdukty();
    loadUserId();
  }, [currentPage]);

  async function loadProdukty() {
    let token = localStorage.getItem("token");
    if (currentPage >= 0 && currentPage <= 1) {
      axios
        .get(`http://localhost:8080/produkty?page=${currentPage}`, {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        })
        .then((response) => {
          setProdukty(response.data);
          console.log(response.data);
        })
        .catch((error) => {
          console.error("Błąd podczas ładowania produktów:", error);
        });
    } else {
      console.log("Nieprawidłowa strona");
    }
  }

  async function loadUserId() {
    let token = localStorage.getItem("token");
    let username = localStorage.getItem("username");
    try {
      const response = await axios.get(
        `http://localhost:8080/uzytkownicy/${username}`,
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        }
      );
      setUserId(response.data.id);
    } catch (error) {
      console.error("Błąd podczas ładowania użytkownika:", error);
    }
  }

  const handleNextPage = () => {
    setCurrentPage((prevPage) => (prevPage < 1 ? prevPage + 1 : prevPage));
  };

  const handlePrevPage = () => {
    setCurrentPage((prevPage) => (prevPage > 0 ? prevPage - 1 : prevPage));
  };

  async function addToCart(productId) {
    let token = localStorage.getItem("token");

    if (currentPage >= 0 && currentPage <= 1) {
      try {
        await axios.post(
          "http://localhost:8080/zlecenie",
          {
            date: "2024-04-26T09:08:18.264Z",
            id: 0,
            produkty: {
              id_produktu: productId,
            },
            users: {
              id: userId,
            },
          },
          {
            headers: {
              Authorization: `Bearer ${token}`,
            },
          }
        );
        console.log("Zlecenie dodane do koszyka.");
      } catch (error) {
        console.error("Błąd podczas dodawania zlecenia:", error);
      }
    } else {
      console.log("Nieprawidłowa strona");
    }
  }

  return (
    <div className="sklep-container">
      <h2>Produkty</h2>
      <div className="produkty-grid">
        {produkty.map((produkt, key) => (
          <Produkt pr={produkt} key={key} addToCart={addToCart} />
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
