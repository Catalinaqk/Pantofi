// eslint-disable-next-line no-unused-vars
import React, { useState, useEffect } from 'react';
import { getMaterialsNoPagination } from '../api/MaterialeService';
import { saveProduction } from '../api/ProductieService'; // Assuming you create this API service.

const ProductiePage = () => {
    const [materials, setMaterials] = useState([]);
    const [worker, setWorker] = useState('');
    const [selectedMaterial, setSelectedMaterial] = useState('');
    const [quantity, setQuantity] = useState('');

    useEffect(() => {
        const fetchMaterials = async () => {
            try {
                const response = await getMaterialsNoPagination();
                setMaterials(response.data);
            } catch (error) {
                console.error("Error fetching materials:", error);
            }
        };
        fetchMaterials();
    }, []);

    const handleSaveProduction = async (event) => {
        event.preventDefault();
        try {
            const productionData = {
                worker,
                materialId: selectedMaterial,
                quantity
            };
            await saveProduction(productionData);  // Assuming saveProduction API function
            alert("Producția a fost salvată!");
        } catch (error) {
            console.error("Error saving production:", error);
            alert("Eroare la salvarea producției!");
        }
    };

    return (
        <div>
            <h2>Gestionare Producție</h2>
            <form onSubmit={handleSaveProduction}>
                <div>
                    <label>Lucrător:</label>
                    <input
                        type="text"
                        value={worker}
                        onChange={(e) => setWorker(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Material:</label>
                    <select
                        value={selectedMaterial}
                        onChange={(e) => setSelectedMaterial(e.target.value)}
                        required
                    >
                        <option value="">Selectează material</option>
                        {materials.map((material) => (
                            <option key={material.id} value={material.id}>
                                {material.nume}
                            </option>
                        ))}
                    </select>
                </div>
                <div>
                    <label>Cantitate:</label>
                    <input
                        type="number"
                        value={quantity}
                        onChange={(e) => setQuantity(e.target.value)}
                        required
                    />
                </div>
                <button type="submit">Salvează Producția</button>
            </form>
        </div>
    );
};

export default ProductiePage;
