// eslint-disable-next-line no-unused-vars
import React from 'react';
import { HashRouter, Link, Navigate, Route, Routes } from 'react-router-dom';
import HomePage from './pages/HomePage.jsx';
import ComenziPage from './pages/ComenziPage.jsx';
import ProductiePage from './pages/ProductiePage.jsx';
import Header from "./components/Header.jsx"; // Import the new component

function App() {
    return (
        <HashRouter>
            <Header />
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
