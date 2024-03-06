import React from 'react';
import axios from 'axios';
const App = () => {
  return (
    <>
      {/* Banner */}
      <section id="banner">
        <div className="inner">
          <h2>MichTech</h2>
          <p>
            Twoje źródło <br />
            elektronicznych<br />
            rozwiązań online
          </p>
        </div>
        <a href="#two" className="more scrolly">
          Więcej
        </a>
      </section>

      {/* Two */}
      <section id="two" className="wrapper alt style2">
        <section className="spotlight">
          <div className="image">
            <img src="images/pic01.jpg" alt="" />
          </div>
          <div className="content">
            <h2>Michtech to firma specjalizująca<br />się w sprzedaży artykułów elektronicznych w internecie</h2>
            <p>
              Firma zyskała pozycję lidera w swojej branży, oferując szeroki asortyment produktów elektronicznych, od smartfonów i tabletów po akcesoria, komponenty elektroniczne oraz nowoczesne urządzenia elektroniczne.
            </p>
          </div>
        </section>
        <section className="spotlight">
          <div className="image">
            <img src="images/pic02.jpg" alt="" />
          </div>
          <div className="content">
            <h2>Michtech oferuje bogatą gamę produktów elektronicznych<br /></h2>
            <p>Nasza firma oferuje sprzęt elektroniczny w kategoriach: smartfony, konsole, laptopy oraz wiele innych.</p>
          </div>
        </section>
        <section className="spotlight">
          <div className="image">
            <img src="images/pic03.jpg" alt="" />
          </div>
          <div className="content">
            <h2>Konatkt<br /></h2>
            <p>
              Adres: ... <br />
              Telefon: ... <br />
            </p>
          </div>
        </section>
      </section>
    </>
  );
};

export default App;
