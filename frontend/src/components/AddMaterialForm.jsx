// `frontend/src/components/AddMaterialForm.jsx`
// eslint-disable-next-line no-unused-vars
import React, { useState } from 'react';
import axios from 'axios';

function FormularAdaugareMaterial() {
    const [nume, setNume] = useState('');
    const [tip, setTip] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/materiale', { nume, tip });
            console.log('Material adăugat:', response.data);
        } catch (error) {
            console.error('Eroare la adăugarea materialului:', error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Nume:</label>
                <input type="text" value={nume} onChange={(e) => setNume(e.target.value)} required />
            </div>
            <div>
                <label>Tip:</label>
                <input type="text" value={tip} onChange={(e) => setTip(e.target.value)} required />
            </div>
            <button type="submit">Adaugă Material</button>
        </form>
    );
}

export default FormularAdaugareMaterial;