// eslint-disable-next-line no-unused-vars
import React, { useState } from 'react';
import Material from "./Material.jsx";

// eslint-disable-next-line react/prop-types
const MaterialList = ({ materials = [], comenzi = [] }) => {
    const [numeFilter, setNumeFilter] = useState(""); // Filtrul pentru nume
    const [filteredMaterials, setFilteredMaterials] = useState(materials); // Materialele filtrate
    const [currentPage, setCurrentPage] = useState(1);
    const materialsPerPage = 12;

    const handleFilterChange = (event) => {
        setNumeFilter(event.target.value);
    };

    const handleSearch = () => {
        const filtered = materials.filter((material) =>
            material.nume.toLowerCase().includes(numeFilter.toLowerCase())
        );

        setFilteredMaterials(filtered);
        setCurrentPage(1); // Resetăm la prima pagină după filtrare
    };

    const materialsWithComenzi = filteredMaterials.map((material) => {
        const comanda = comenzi.filter((comanda) => comanda.idMaterial === material.id);
        return { ...material, comanda };
    });

    const totalPages = Math.ceil(materialsWithComenzi.length / materialsPerPage);
    const startIndex = (currentPage - 1) * materialsPerPage;
    const currentMaterials = materialsWithComenzi.slice(startIndex, startIndex + materialsPerPage);

    const handlePageChange = (newPage) => {
        setCurrentPage(newPage);
    };

    return (
        <main className="main">
            <div className="filter-container">
                <h2>Filtrează materialele</h2>
                <div className="row mb-3">
                    <div className="col-md-3">
                        <label>Nume</label>
                        <input
                            type="text"
                            value={numeFilter}
                            onChange={handleFilterChange}
                            className="form-control"
                        />
                    </div>
                    <div className="col-md-3 mt-4">
                        <button className="btn btn-primary" onClick={handleSearch}>
                            Caută
                        </button>
                    </div>
                </div>
            </div>

            {currentMaterials.length === 0 && <div>No materials found</div>}

            <div className="row ms-5 me-5 mb-5 mt-5">
                {currentMaterials.map((material) => (
                    <div className="col-md-4 mb-3" key={material.id}>
                        <Material material={material} comenzi={material.comanda} />
                    </div>
                ))}
            </div>

            {materialsWithComenzi.length > 0 && (
                <div className="pagination-container">
                    <button
                        disabled={currentPage === 1}
                        onClick={() => handlePageChange(currentPage - 1)}
                        className="btn btn-primary"
                    >
                        Previous
                    </button>
                    <span className="mx-3">
                        Page {currentPage} of {totalPages}
                    </span>
                    <button
                        disabled={currentPage === totalPages}
                        onClick={() => handlePageChange(currentPage + 1)}
                        className="btn btn-primary"
                    >
                        Next
                    </button>
                </div>
            )}
        </main>
    );
};

export default MaterialList;
