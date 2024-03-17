import { Link } from 'react-router-dom';
import { useContext } from 'react';
import AuthContext from '../AuthContext';

function Navbar(){
    const auth = useContext(AuthContext);
    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
            <ul className="navbar-nav">
                <li><Link className="nav-link" to="/">Home</Link></li>
                <li><Link className="nav-link" to="/about">About</Link></li>
                <li><Link className="nav-link" to="/solarpanels">Solar Panels</Link></li>
                {!auth.user && (
                    <>
                        <li><Link className="nav-link" to="/login">Login</Link></li>
                        <li><Link className="nav-link" to="/register">Register</Link></li>
                    </>
                )}
            </ul>
            {auth.user && (
                <div>
                    Why hello {auth.user.username}
                    <button className="btn btn-outline-light ml-3" 
                        onClick={auth.logout}>Logout</button>
                </div>
            )}
        </nav>
    );
}

export default Navbar;