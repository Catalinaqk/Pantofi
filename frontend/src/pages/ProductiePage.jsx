// eslint-disable-next-line no-unused-vars
import React, { useState, useEffect } from 'react';
import { salveazaProductie, obtineProductiiFaraPaginare } from '../api/ProductieService';

const ProductiePage = () => {
    const [productie, setProductie] = useState('');
    const [productii, setProductii] = useState([]);

    useEffect(() => {
        fetchProductii();
    }, []);

    const fetchProductii = async () => {
        console.log('Fetching productions...');
        const response = await obtineProductiiFaraPaginare();
        console.log('Response:', response.data);
        setProductii(response.data);
    };

    const handleAddProductie = async () => {
        await salveazaProductie({ name: productie });
        setProductie('');
        fetchProductii();
    };

    return (
        <div>
            <h1>Producție</h1>
            <input
                type="text"
                value={productie}
                onChange={(e) => setProductie(e.target.value)}
                placeholder="Adaugă o nouă producție"
            />
            <button onClick={handleAddProductie}>Adaugă Producție</button>
            <div>
                <h2>Lista Producțiilor</h2>
                <ul>
                    {productii.map((prod) => (
                        <li key={prod.id}>{prod.name}</li>
                    ))}
                </ul>
            </div>
        </div>
    );
};

export default ProductiePage;