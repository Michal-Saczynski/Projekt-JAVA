import React, { useEffect, useState } from "react";
import axios from "axios";
import Produkt from "./produkt";
export default function Sklep() {
  const [produkty, setProdukty] = useState([]);
  useEffect(() => {
    loadProdukty();
  }, []);
  async function loadProdukty() {
    axios
      .get("http://localhost:8080/produkty?page=2", {
        headers: {
          "Access-Control-Allow-Origin": "*",
        },
      })
      .then((response) => {
        setProdukty(response.data);
        console.log(response.data);
      });
  }
  return (
    <div>
      <h2>Produkty</h2>
      <ul>
        {produkty.map((produkt, key) => (
          <Produkt pr={produkt} key={key} />
        ))}
      </ul>
    </div>
  );
}
