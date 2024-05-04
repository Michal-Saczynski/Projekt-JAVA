import React, { useState } from "react";

const Rejestracja = () => {
  const [formData, setFormData] = useState({
    username: "",
    password: "",
    email: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch("http://localhost:8080/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
      });
      if (response.ok) {
        console.log("Registration successful");
      } else {
        console.error("Registration failed");
      }
    } catch (error) {
      console.error("Error during registration:", error);
    }
  };

  return (
    <form onSubmit={handleSubmit} id="form">
      <div className="row gtr-uniform">
        <div className="col-6 col-12-xsmall">
          <input
            type="text"
            name="username"
            value={formData.username}
            onChange={handleChange}
            placeholder="Nazwa"
          />
        </div>
        <div className="col-6 col-12-xsmall">
          <input
            type="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            placeholder="Hasło"
          />
        </div>
        <div className="col-6 col-12-xsmall">
          <input
            type="email"
            name="email"
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
