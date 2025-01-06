// eslint-disable-next-line no-unused-vars
import React, { useState, useEffect } from 'react';
import { salveazaComanda, obtineComenziFaraPaginare } from '../api/OrderService';

const ComenziPage = () => {
    const [comanda, setComanda] = useState('');
    const [comenzi, setComenzi] = useState([]);

    useEffect(() => {
        fetchComenzi();
    }, []);

    const fetchComenzi = async () => {
        const response = await obtineComenziFaraPaginare();
        setComenzi(response.data);
    };

    const handleAddComanda = async () => {
        await salveazaComanda({ name: comanda });
        setComanda('');
        fetchComenzi();
    };

    return (
        <div>
            <h1>Comenzi</h1>
            <input
                type="text"
                value={comanda}
                onChange={(e) => setComanda(e.target.value)}
                placeholder="Adaugă o nouă comandă"
            />
            <button onClick={handleAddComanda}>Adaugă Comandă</button>
            <div>
                <h2>Lista Comenzilor</h2>
                <ul>
                    {comenzi.map((com) => (
                        <li key={com.id}>{com.name}</li>
                    ))}
                </ul>
            </div>
        </div>
    );
};

export default ComenziPage;