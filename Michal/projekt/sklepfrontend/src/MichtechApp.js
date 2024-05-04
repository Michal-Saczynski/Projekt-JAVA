import React from "react";
import "./MichtechApp.css"; // Importuj swoje style CSS

const MichtechApp = () => {
  return (
    <div>
      <div id="header">
        <span class="logo icon fa-paper-plane"></span>
        <h1>MichTech</h1>
        <p>
          Twoje źródło <br />
          elektronicznych
          <br />
          rozwiązań online
          <br />
        </p>
      </div>

      <div id="main">
        <div class="box alt container">
          <section class="feature left">
            <a href="#" class="image icon solid fa-signal">
              <img src="images/pic01.jpg" alt="" />
            </a>
            <div class="content">
              <h3>Po pierwsze</h3>
              <p>
                Michtech to firma specjalizująca
                <br />
                się w sprzedaży artykułów elektronicznych w internecie
              </p>
            </div>
          </section>
          <section class="feature right">
            <a href="#" class="image icon solid fa-code">
              <img src="images/pic02.jpg" alt="" />
            </a>
            <div class="content">
              <h3>Po drugie</h3>
              <p>
                Firma zyskała pozycję lidera w swojej branży, oferując szeroki
                asortyment produktów elektronicznych, od smartfonów i tabletów
                po akcesoria, komponenty elektroniczne oraz nowoczesne
                urządzenia elektroniczne.
              </p>
            </div>
          </section>
          <section class="feature left" id="kontakt">
            <a href="#" class="image icon solid fa-mobile-alt">
              <img src="images/pic03.jpg" alt="" />
            </a>
            <div class="content">
              <h3>Kontakt</h3>
              <p>
                Adres: ... <br /> Telefon: ...{" "}
              </p>
            </div>
          </section>
        </div>
      </div>

      <div id="footer">
        <div class="container medium">
          <ul class="icons">
            <li>
              <a href="#" class="icon brands fa-twitter">
                <span class="label">Twitter</span>
              </a>
            </li>
            <li>
              <a href="#" class="icon brands fa-facebook-f">
                <span class="label">Facebook</span>
              </a>
            </li>
            <li>
              <a href="#" class="icon brands fa-instagram">
                <span class="label">Instagram</span>
              </a>
            </li>
            <li>
              <a href="#" class="icon brands fa-github">
                <span class="label">Github</span>
              </a>
            </li>
            <li>
              <a href="#" class="icon brands fa-dribbble">
                <span class="label">Dribbble</span>
              </a>
            </li>
          </ul>

          <ul class="copyright">
            <li>&copy; Michał Saczyński</li>
            <li></li>
          </ul>
        </div>
      </div>

      <script src="assets/js/jquery.min.js"></script>
      <script src="assets/js/browser.min.js"></script>
      <script src="assets/js/breakpoints.min.js"></script>
      <script src="assets/js/util.js"></script>
      <script src="assets/js/main.js"></script>
    </div>
  );
};

export default MichtechApp;
