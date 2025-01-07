// eslint-disable-next-line no-unused-vars
import React from 'react';
import { Link } from 'react-router-dom';

const Header = () => {
    return (
        <header>
            <nav>
                <ul>
                    <li><Link to="/materiale">Materiale</Link></li>
                    <li><Link to="/comenzi">Comenzi</Link></li>
                    <li><Link to="/productie">Productie</Link></li>
                </ul>
            </nav>
        </header>
    );
};

export default Header;