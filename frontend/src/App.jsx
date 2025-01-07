// eslint-disable-next-line no-unused-vars
import React from 'react';
import { HashRouter, Link, Navigate, Route, Routes } from 'react-router-dom';
import HomePage from './pages/HomePage.jsx';
import ComenziPage from './pages/ComenziPage.jsx';
import ProductiePage from './pages/ProductiePage.jsx'; // Import the new component

function App() {
    return (
        <HashRouter>
            <div className="container-fluid">
                <div className="d-flex justify-content-center">
                    <Link to="/" className="navbar-brand bg-transparent text-dark">
                        <div className="d-flex align-items-center">
                            <h1>Automatizarea Gestionării Materialelor Pentru Producția De Pantofi</h1>
                        </div>
                    </Link>
                </div>
            </div>
            <Routes>
                <Route path="/" element={<Navigate to="/materiale" />} />
                <Route path="/materiale" element={<HomePage />} />
                <Route path="/comenzi" element={<ComenziPage />} />
                <Route path="/productie" element={<ProductiePage />} />
            </Routes>
        </HashRouter>
    );
}

export default App;
