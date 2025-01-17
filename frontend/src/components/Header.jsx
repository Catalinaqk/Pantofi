// eslint-disable-next-line no-unused-vars
import React from 'react';

const Header = () => {
    return (
        <nav className="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
            <div className="container-fluid">
                <a className="navbar-brand" href="#/">Gestionare Materiale</a>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        <li className="nav-item">
                            <a className="nav-link active" aria-current="page" href="#/">Materiale</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="#/comenzi">Comenzi</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="#/productie">Productie</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    );
};

export default Header;