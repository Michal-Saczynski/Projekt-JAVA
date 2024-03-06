import React from "react";

const Koszyk = ({ uzytkownik, dane_z, records, zamowienie, total }) => {
  return (
    <section>
      <h4>Koszyk</h4>
      <ul className="actions line">
        <li>
          <p>Imie: {uzytkownik.name}</p>
        </li>
        <li>
          <p>Nazwisko: {dane_z.map((d) => d.surname).join(", ")}</p>
        </li>
        <li>
          <p>Rola: {uzytkownik.role}</p>
        </li>
        <li>
          <p>Email: {uzytkownik.login}</p>
        </li>
        <li>
          <p>Telefon: {dane_z.map((d) => d.phone).join(", ")}</p>
        </li>
      </ul>
      <table className="Produkty">
        <thead>
          <tr>
            <th></th>
            <th>Nazwa</th>
            <th>Ilosc</th>
            <th>Koszt</th>
            <th>Data</th>
          </tr>
        </thead>
        <tbody>
          {records.map((r, index) => (
            <tr key={index}>
              <td>
                <div className="zdj">
                  <img src={`/images/${r.Plik}`} alt="" />
                </div>
              </td>
              <td>{r.Nazwa}</td>
              <td>{r.Ilosc}</td>
              <td>{r.Koszt}</td>
              <td>{r.Data}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <div className="col-12">
        <ul className="actions">
          {zamowienie.ilosc.map((i, index) => (
            <form key={index} action={`/koszyk/${i}`} method="post">
              <input
                style={{ marginLeft: "1vw" }}
                type="submit"
                name="submit"
                className="primary"
                value={i}
              />
            </form>
          ))}
          <li>
            <h3>Całkowity koszt: {total} zł</h3>
          </li>
          <li>
            <form action="/kup" method="post">
              <input
                style={{ marginLeft: "1vw" }}
                type="submit"
                className="primary"
                value="Kup"
              />
            </form>
          </li>
        </ul>
      </div>
    </section>
  );
};

export default Koszyk;
