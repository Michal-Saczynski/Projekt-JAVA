import { Link } from "react-router-dom";
import Sklep from "./sklep";
import Rejestracja from "./rejestracja";
import Logowanie from "./logowanie";
import Michtech from "./MichtechApp";

const Menu = () => {
  const scrollToSection = (sectionId) => {
    const section = document.getElementById(sectionId);
    if (section) {
      section.scrollIntoView({ behavior: "smooth" });
    }
  };
  return (
    <nav className="menu">
      <ul>
        <li onClick={() => scrollToSection("main")}>Oferta</li>
        <li onClick={() => scrollToSection("kontakt")}>Kontakt</li>
        <li>
          <Link to="/sklep">Sklep</Link>
        </li>
        <li>
          <Link to="/rejestracja">Rejestracja</Link>
        </li>
        <li>
          <Link to="/logowanie">Logowanie</Link>
        </li>
        <li>
          <Link to="/koszyk">Koszyk</Link>
        </li>
      </ul>
    </nav>
  );
};
export default Menu;
