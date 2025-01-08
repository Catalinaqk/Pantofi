import React, { useState, useEffect } from 'react';
import { getMaterialsNoPagination } from '../api/MaterialeService';
import { saveProduction } from '../api/ProductieService';

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
                numeLucrator: worker,
                materialId: selectedMaterial,
                cantitateProdusa: quantity
            };
            await saveProduction(productionData);
            alert("Producția a fost salvată!");
        } catch (error) {
            console.error("Error saving production:", error);
            alert("Eroare la salvarea producției!");
        }
    };

    return (
        <div className="container mt-4">
            <h2>Gestionare Producție</h2>
            <form onSubmit={handleSaveProduction}>
                <div className="mb-3">
                    <label className="form-label">Lucrător:</label>
                    <input
                        type="text"
                        className="form-control"
                        value={worker}
                        onChange={(e) => setWorker(e.target.value)}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Material:</label>
                    <select
                        className="form-select"
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
                <div className="mb-3">
                    <label className="form-label">Cantitate:</label>
                    <input
                        type="number"
                        className="form-control"
                        value={quantity}
                        onChange={(e) => setQuantity(e.target.value)}
                        required
                    />
                </div>
                <button type="submit" className="btn btn-primary">Salvează Producția</button>
            </form>
        </div>
    );
};

export default ProductiePage;