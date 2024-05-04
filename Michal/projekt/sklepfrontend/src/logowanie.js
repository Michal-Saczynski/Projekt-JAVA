import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const Logowanie = () => {
  const nav = useNavigate();
  const [formData, setFormData] = useState({
    username: "",
    password: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(formData);
    axios.post("http://localhost:8080/login", formData).then((response) => {
      console.log(response);
      localStorage.setItem('token', response.data);
      localStorage.setItem('username', formData.username);
      if (response.status == 200) {
        nav("/");
      } else {
        alert("Błędne dane!");
        nav("/logowanie")
      }
    });
  };

  return (
    <form onSubmit={handleSubmit} id="form">
      <div className="row gtr-uniform">
        <div className="col-6 col-12-xsmall">
          <input
            type="text"
            name="username"
            id="demo-username"
            value={formData.username}
            onChange={handleChange}
            placeholder="Username"
          />
        </div>

        <div className="col-6 col-12-xsmall">
          <input
            type="password"
            name="password"
            id="demo-name"
            value={formData.password}
            onChange={handleChange}
            placeholder="Password"
          />
        </div>

        <div className="col-12">
          <ul className="actions">
            <li>
              <input type="submit" value="Zaloguj" className="primary" />
            </li>
          </ul>
        </div>
      </div>
    </form>
  );
};

export default Logowanie;
