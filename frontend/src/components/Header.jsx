import React, { useState, useEffect } from 'react';
import PropTypes from 'prop-types';
import { Link } from 'react-router-dom';
import { loginDepartament } from '../api/DepartamentService';

const Header = ({ departamentType, departamentName, setDepartamentType, setDepartamentName, setDepartamentEmail }) => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');

    useEffect(() => {
        const storedDepartamentType = localStorage.getItem('departamentType');
        const storedDepartamentName = localStorage.getItem('departamentName');
        const storedDepartamentEmail = localStorage.getItem('departamentEmail');
        if (storedDepartamentType && storedDepartamentName && storedDepartamentEmail) {
            setDepartamentType(storedDepartamentType);
            setDepartamentName(storedDepartamentName);
            setDepartamentEmail(storedDepartamentEmail);
        }
    }, [setDepartamentType, setDepartamentName, setDepartamentEmail]);

    const handleLogin = async (event) => {
        event.preventDefault();
        try {
            const departament = await loginDepartament(email, password);
            setDepartamentType(departament.type);
            setDepartamentName(departament.name);
            setDepartamentEmail(departament.email);
            setError('');
            localStorage.setItem('departamentType', departament.type);
            localStorage.setItem('departamentName', departament.name);
            localStorage.setItem('departamentEmail', departament.email);
        } catch (error) {
            setError('Email sau parola incorecta!');
        }
    };

    const handleLogout = () => {
        localStorage.removeItem('departamentType');
        localStorage.removeItem('departamentName');
        localStorage.removeItem('departamentEmail');
        setDepartamentType('guest');
        setDepartamentName('');
        setDepartamentEmail('');
    };

    return (
        <nav className="navbar bg-dark border-bottom border-body" data-bs-theme="dark">
            <div className="container-fluid">
                <h3 className="text-white">Departamentul de {departamentName}</h3>
                {departamentType === 'admin' && (
                    <button type="button" className="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addMaterialBackdrop">
                        Adauga material
                    </button>
                )}
                {departamentType === 'guest' && (
                    <div className="dropdown">
                        <button type="button" className="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown"
                                aria-expanded="false" data-bs-auto-close="outside">
                            Departament
                        </button>
                        <div className="dropdown-menu dropdown-menu-end" style={{ minWidth: "300px" }}>
                            <form className="px-4 py-3" onSubmit={handleLogin}>
                                <div className="mb-3">
                                    <label htmlFor="exampleDropdownFormEmail1" className="form-label">Email</label>
                                    <input type="text" className="form-control" id="exampleDropdownFormEmail1"
                                           placeholder="Email" value={email}
                                           onChange={(e) => setEmail(e.target.value)} />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="exampleDropdownFormPassword1" className="form-label">Parola</label>
                                    <input type="password" className="form-control" id="exampleDropdownFormPassword1"
                                           placeholder="Parola" value={password}
                                           onChange={(e) => setPassword(e.target.value)} required />
                                </div>
                                {error && <div className="alert alert-danger" role="alert">{error}</div>}
                                <button type="submit" className="btn btn-primary">Logare</button>
                            </form>
                            <div className="dropdown-divider"></div>
                            <Link className="dropdown-item" to="/register">Inregistrare</Link>
                            <Link className="dropdown-item" to="/forgot-password">Ai uitat parola?</Link>
                        </div>
                    </div>
                )}
                {departamentType !== 'guest' && (
                    <div className="dropdown">
                        <button type="button" className="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown"
                                aria-expanded="false" data-bs-auto-close="outside">
                            {departamentName}
                        </button>
                        <div className="dropdown-menu dropdown-menu-end" style={{ minWidth: "300px" }}>
                            <Link className="dropdown-item" to="/profile">Profil</Link>
                            <button className="dropdown-item" onClick={handleLogout}>Deconectare</button>
                        </div>
                    </div>
                )}
            </div>
        </nav>
    );
}

Header.propTypes = {
    departamentType: PropTypes.string.isRequired,
    departamentName: PropTypes.string.isRequired,
    setDepartamentType: PropTypes.func.isRequired,
    setDepartamentName: PropTypes.func.isRequired,
    setDepartamentEmail: PropTypes.func.isRequired,
};

export default Header;