import { useState } from 'react';
import { BrowserRouter as Router, Route, Switch, Redirect } from 'react-router-dom';
import jwt_decode from 'jwt-decode';
import About from './components/About';
import Home from './components/Home';
import Navbar from './components/Navbar';
import SolarPanelList from './components/SolarPanelList';
import SolarPanelForm from './components/SolarPanelForm';
import NotFound from './components/NotFound';
import Login from './components/Login';
import AuthContext from './AuthContext';

function App() {
  const [user, setUser] = useState(null);

  const login = (token) => {
    const decodedToken = jwt_decode(token);

    const roles = decodedToken.authorities.split(","); 

    const userToLogin = {
      username: decodedToken.sub,
      roles,
      token,
      hasRole(role){
        return this.roles.includes(role);
      }
    }
    console.log(userToLogin);
    setUser(userToLogin);
  }

  const logout = () => {
    setUser(null)
  }

  const auth = {
    user,
    login,
    logout
  }

  return (
    <AuthContext.Provider value={auth}>
      <Router>
        <h1>Solar Farm</h1>
        <Navbar/>
        <Switch>
          <Route path="/login">
            <Login/>
          </Route>
          <Route path="/about">
            <About />
          </Route>
          <Route path={["/solarpanels/add", "/solarpanels/edit/:id"]}>
            {auth.user ? (
              <SolarPanelForm />
            ) : (
              <Redirect to="/login" />
            )}
          </Route>
          <Route path="/solarpanels">
            <SolarPanelList />
          </Route>
          <Route path="/" exact>
            <Home />
          </Route>
          <Route>
            <NotFound />
          </Route>
        </Switch>
      </Router>
    </AuthContext.Provider>
  );
}

export default App;
