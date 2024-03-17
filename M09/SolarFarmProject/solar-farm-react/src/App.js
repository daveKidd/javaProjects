import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Home from './components/Home';
import About from './components/About';
import Navbar from './components/Navbar';
import SolarPanelList from './components/SolarPanelList';
import SolarPanelForm from './components/SolarPanelForm';
import NotFound from './components/NotFound';

function App() {
  return (
    <>
      <Router>
        <h1>Solar Farm</h1>
        <Navbar/>
        <Switch>
          <Route path="/" exact>
            <Home/>
          </Route>          
          <Route path="/about" exact>
            <About/>
          </Route>          
          <Route path={["/solarpanels/add","/solarpanels/edit/:id"]}>
            <SolarPanelForm/>
          </Route>
          <Route path="/solarpanels" exact>
            <SolarPanelList/>
          </Route>
          <Route>
            <NotFound/>
          </Route>         
        </Switch>       
      </Router>      
    </>
  );
}

export default App;
