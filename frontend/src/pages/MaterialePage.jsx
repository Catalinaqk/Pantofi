// eslint-disable-next-line no-unused-vars
import React, { useState, useEffect } from 'react';
import { saveMaterial, getMaterialsNoPagination } from '../api/MaterialeService';

const MaterialePage = () => {
    const [material, setMaterial] = useState('');
    const [materials, setMaterials] = useState([]);

    useEffect(() => {
        fetchMaterials();
    }, []);

    const fetchMaterials = async () => {
        const response = await getMaterialsNoPagination();
        setMaterials(response.data);
    };

    const handleAddMaterial = async () => {
        await saveMaterial({ name: material });
        setMaterial('');
        fetchMaterials();
    };

    return (
        <div>
            <h1>Materiale</h1>
            <input
                type="text"
                value={material}
                onChange={(e) => setMaterial(e.target.value)}
                placeholder="Add new material"
            />
            <button onClick={handleAddMaterial}>Add Material</button>
            <div>
                <h2>Material List</h2>
                <ul>
                    {materials.map((mat) => (
                        <li key={mat.id}>{mat.name}</li>
                    ))}
                </ul>
            </div>
        </div>
    );
};

export default MaterialePage;