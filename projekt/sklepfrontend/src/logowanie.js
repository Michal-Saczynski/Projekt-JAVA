import React, { useState } from "react";

const Logowanie = () => {
  const [formData, setFormData] = useState({
    email: "",
    password: "",
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
            type="email"
            name="email"
            id="demo-email"
            value={formData.email}
            onChange={handleChange}
            placeholder="Email"
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
