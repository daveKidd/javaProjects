import { Link } from 'react-router-dom';

function Navbar(){
    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
            <ul className="navbar-nav">
                <li><Link className="nav-link" to="/">Home</Link></li>
                <li><Link className="nav-link" to="/about">About</Link></li>
                <li><Link className="nav-link" to="/solarpanels">Solar Panels</Link></li>
            </ul>
        </nav>
    );
}

export default Navbar;

