// eslint-disable-next-line no-unused-vars
import React from 'react';
// eslint-disable-next-line no-unused-vars
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import MainNavigation from './components/MainNavigation';
import MaterialePage from './pages/MaterialePage';
import ComenziPage from './pages/ComenziPage';
import ProductiePage from './pages/ProductiePage';

const App = () => {
    return (
        <Router>
            <MainNavigation />
            <Switch>
                <Route path="/materiale" component={MaterialePage} />
                <Route path="/comenzi" component={ComenziPage} />
                <Route path="/productie" component={ProductiePage} />
            </Switch>
        </Router>
    );
};

export default App;