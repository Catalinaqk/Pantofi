// eslint-disable-next-line no-unused-vars
import React, { useState, useEffect } from 'react';
import { saveComanda, getComenzi } from '../api/ComenziService';
import { getMaterialsNoPagination } from '../api/MaterialeService';

function ComenziPage() {
    const [materials, setMaterials] = useState([]);
    const [comenzi, setComenzi] = useState([]);
    const [comanda, setComanda] = useState({
        materialId: "",
        cantitate: 0
    });

    useEffect(() => {
        const fetchMaterials = async () => {
            try {
                const response = await getMaterialsNoPagination();
                setMaterials(response.data);
            } catch (error) {
                console.error("Eroare la obținerea materialelor:", error);
            }
        };

        const fetchComenzi = async () => {
            try {
                const response = await getComenzi();
                setComenzi(response.data);
            } catch (error) {
                console.error("Eroare la obținerea comenzilor:", error);
            }
        };

        fetchMaterials();
        fetchComenzi();
    }, []);

    const handleChange = (event) => {
        setComanda({ ...comanda, [event.target.name]: event.target.value });
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await saveComanda(comanda);
            console.log("Comanda a fost salvată:", response.data);
            alert("Comanda a fost plasată cu succes!");
            setComenzi([...comenzi, response.data]);
        } catch (error) {
            console.error("Eroare la plasarea comenzii:", error);
            alert("Eroare la plasarea comenzii!");
        }
    };

    return (
        <div className="container">
            <h2>Plasează o comandă</h2>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="materialId" className="form-label">Material:</label>
                    <select
                        id="materialId"
                        name="materialId"
                        className="form-control"
                        value={comanda.materialId}
                        onChange={handleChange}
                        required
                    >
                        <option value="">Selectează un material</option>
                        {materials.map((material) => (
                            <option key={material.id} value={material.id}>{material.nume}</option>
                        ))}
                    </select>
                </div>
                <div className="mb-3">
                    <label htmlFor="cantitate" className="form-label">Cantitate:</label>
                    <input
                        type="number"
                        id="cantitate"
                        name="cantitate"
                        className="form-control"
                        value={comanda.cantitate}
                        onChange={handleChange}
                        required
                    />
                </div>
                <button type="submit" className="btn btn-success">Plasează comanda</button>
            </form>

            <h2 className="mt-5">Comenzi plasate</h2>
            <ul className="list-group">
                {comenzi.map((comanda) => (
                    <li key={comanda.id} className="list-group-item">
                        Material: {comanda.materialId}, Cantitate: {comanda.cantitate}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default ComenziPage;