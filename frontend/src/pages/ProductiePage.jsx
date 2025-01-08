// eslint-disable-next-line no-unused-vars
import React, { useState, useEffect } from 'react';
import { getMaterialsNoPagination } from '../api/MaterialeService';
import { saveProduction, getProductions } from '../api/ProductieService';

const ProductiePage = () => {
    const [materials, setMaterials] = useState([]);
    const [productions, setProductions] = useState([]);
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

        const fetchProductions = async () => {
            try {
                const response = await getProductions();
                setProductions(response.data);
            } catch (error) {
                console.error("Error fetching productions:", error);
            }
        };

        fetchMaterials();
        fetchProductions();
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
            const response = await getProductions();
            setProductions(response.data);
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

            <h2 className="mt-5">Producții salvate</h2>
            <ul className="list-group mt-3">
                {productions.map((production) => (
                    <li key={production.id} className="list-group-item">
                        Lucrător: {production.numeLucrator}, Material: {production.materialId}, Cantitate: {production.cantitateProdusa}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default ProductiePage;