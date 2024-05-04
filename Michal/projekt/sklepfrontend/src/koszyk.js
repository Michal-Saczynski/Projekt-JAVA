import axios from "axios";
import React, { useEffect, useState } from "react";

const Koszyk = () => {
  const [selectedZlecenie, setSelectedZlecenie] = useState(null);
  const username = localStorage.getItem("username");
  const token = localStorage.getItem("token");

  useEffect(() => {
    async function fetchData() {
      try {
        const userResponse = await axios.get(
          `http://localhost:8080/uzytkownicy/${username}`,
          {
            headers: {
              Authorization: `Bearer ${token}`,
            },
          }
        );
        const userId = userResponse.data.id;

        const zlecenieResponse = await axios.get(`/zlecenie/${userId}`, {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });
        setSelectedZlecenie(zlecenieResponse.data);
      } catch (error) {
        console.error("Błąd podczas ładowania danych:", error);
      }
    }

    fetchData();
  }, [username, token]);

  return (
    <section>
      <h4>Koszyk</h4>
      {selectedZlecenie && (
        <div>
          <h5>Zlecenie {selectedZlecenie.id}</h5>
          <p>Date: {new Date(selectedZlecenie.date).toLocaleString()}</p>
          <p>User: {selectedZlecenie.users.username}</p>
          <p>Email: {selectedZlecenie.users.email}</p>
          <table className="Produkty">
            <thead>
              <tr>
                <th>Nazwa</th>
                <th>Cena</th>
                <th>Plik</th>
                <th>Data</th>
              </tr>
            </thead>
            <tbody>
              {selectedZlecenie.produkty.map((produkt) => (
                <tr key={produkt.id}>
                  <td>{produkt.nazwa}</td>
                  <td>{produkt.cena}</td>
                  <td>
                    <img src={`/images/${produkt.plik}`} alt={produkt.nazwa} />
                  </td>
                  <td>{new Date(produkt.date).toLocaleString()}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </section>
  );
};

export default Koszyk;
