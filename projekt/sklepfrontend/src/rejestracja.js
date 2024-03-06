import React, { useState } from "react";

const Rejestracja = () => {
  const [formData, setFormData] = useState({
    name: "",
    surname: "",
    password: "",
    phone: "",
    email: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Add code for handling form submission (e.g., sending data to the server)
    console.log("Form data submitted:", formData);
  };

  return (
    <form onSubmit={handleSubmit} id="form">
      <div className="row gtr-uniform">
        <div className="col-6 col-12-xsmall">
          <input
            type="text"
            name="name"
            id="demo-name"
            value={formData.name}
            onChange={handleChange}
            placeholder="Imię"
          />
        </div>
        <div className="col-6 col-12-xsmall">
          <input
            type="text"
            name="surname"
            id="demo-name"
            value={formData.surname}
            onChange={handleChange}
            placeholder="Nazwisko"
          />
        </div>
        <div className="col-6 col-12-xsmall">
          <input
            type="password"
            name="password"
            id="demo-name"
            value={formData.password}
            onChange={handleChange}
            placeholder="Hasło"
          />
        </div>
        <div className="col-6 col-12-xsmall">
          <input
            type="text"
            name="phone"
            id="demo-phone"
            value={formData.phone}
            onChange={handleChange}
            placeholder="Telefon"
          />
        </div>
        <div className="col-6 col-12-xsmall">
          <input
            type="email"
            name="email"
            id="demo-email"
            value={formData.email}
            onChange={handleChange}
            placeholder="Email"
          />
        </div>
        <div className="col-12">
          <ul className="actions">
            <li>
              <input type="submit" value="Zarejestruj" className="primary" />
            </li>
            <li>
              <input type="reset" value="Zresetuj" />
            </li>
          </ul>
        </div>
      </div>
    </form>
  );
};

export default Rejestracja;
