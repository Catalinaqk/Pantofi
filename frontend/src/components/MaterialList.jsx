// eslint-disable-next-line no-unused-vars
import React, { useState } from "react";
import Material from "./Material.jsx";



// eslint-disable-next-line react/prop-types
const MaterialList = ({ materials = [], comenzi = [] }) => {

    const [filters, setFilters] = useState({
        name: "",
        type: "",
        status: "",
        price: "",
        quantity: "",
        date: "",
        description: ""
    });

    const [currentPage, setCurrentPage] = useState(1);
    const materialsPerPage = 12;

    const handleFilterChange = (event) => {
        const { name, value } = event.target;
        setFilters({ ...filters, [name]: value });
        setCurrentPage(1); // Resetăm la prima pagină când schimbăm filtrul
    };

    const materialsArray = Array.isArray(materials) ? materials : [];

    const filteredMaterials = materialsArray.filter((material) => {
        const comanda = comenzi.find((comanda) => comanda.id === material.comandaId);
        const comandaFullName = comanda ? `${comanda.firstName} ${comanda.lastName}`.toLowerCase() : "";

        return (
            (filters.comanda === "" || comandaFullName.includes(filters.comanda.toLowerCase())) &&
            (filters.name === "" || material.name.toLowerCase().includes(filters.name.toLowerCase())) &&
            (filters.type === "" || material.type.toLowerCase().includes(filters.type.toLowerCase())) &&
            (filters.status === "" || material.status.toLowerCase().includes(filters.status.toLowerCase())) &&
            (filters.price === "" || material.price.includes(filters.price)) &&
            (filters.quantity === "" || material.quantity.includes(filters.quantity)) &&
            (filters.date === "" || material.date.includes(filters.date)) &&
            (filters.description === "" || material.description.toLowerCase().includes(filters.description.toLowerCase()))
        );
    });

    const materialsWithComenzi = filteredMaterials.map((material) => {
        const comanda = comenzi.find((comanda) => comanda.id === material.comandaId);
        return { ...material, comanda };
    });

    const totalPages = Math.ceil(materialsWithComenzi.length / materialsPerPage);
    const startIndex = (currentPage - 1) * materialsPerPage;
    const currentMaterials = materialsWithComenzi.slice(startIndex, startIndex + materialsPerPage);

    const handlePageChange = (newPage) => {
        setCurrentPage(newPage);
    };

    return(
        <main className="main">
            <div className="filter-container">
                <h2>Filtreaza materialele</h2>
                <div className="row">
                    <div className="col-md-2">
                        <label>Comanda</label>
                        <input
                            type="text"
                            name="comanda"
                            value={filters.comanda}
                            onChange={handleFilterChange}
                            className="form-control"
                        />
                    </div>
                    <div className="col-md-2">
                        <label>Tip</label>
                        <input
                            type="text"
                            name="type"
                            value={filters.type}
                            onChange={handleFilterChange}
                            className="form-control"
                        />
                    </div>
                    <div className="col-md-2">
                        <label>Status</label>
                        <input
                            type="text"
                            name="status"
                            value={filters.status}
                            onChange={handleFilterChange}
                            className="form-control"
                        />
                    </div>
                    <div className="col-md-2">
                        <label>Pret</label>
                        <input
                            type="text"
                            name="price"
                            value={filters.price}
                            onChange={handleFilterChange}
                            className="form-control"
                        />
                    </div>
                    <div className="col-md-2">
                        <label>Cantitate</label>
                        <input
                            type="text"
                            name="quantity"
                            value={filters.quantity}
                            onChange={handleFilterChange}
                            className="form-control"
                        />
                    </div>
                    <div className="col-md-2">
                        <label>Data</label>
                        <input
                            type="text"
                            name="date"
                            value={filters.date}
                            onChange={handleFilterChange}
                            className="form-control"
                        />
                    </div>
                    <div className="col-md-2">
                        <label>Descriere</label>
                        <input
                            type="text"
                            name="description"
                            value={filters.description}
                            onChange={handleFilterChange}
                            className="form-control"
                        />
                    </div>
                </div>
            </div>

            {currentMaterials.length === 0 && <div>No materials found</div>}

            <div className="row ms-5 me-5 mb-5 mt-5">
                {currentMaterials.map((material)=>
                    <div className="col-md-4 mb-3" key={material.id}>
                        <Material material={material} comenzi={comenzi} />
                    </div>
                )}
            </div>

            {materialsWithComenzi.length > 0 && (
                <div className = "pagination-container">
                    <button
                        disabled={currentPage === 1}
                        onClick={() => handlePageChange(currentPage - 1)}
                        className="btn btn-primary"
                    >
                        Pagina anterioara
                    </button>
                    <span className="mx-3">{currentPage} din {totalPages}</span>
                    <button
                        disabled={currentPage === totalPages}
                        onClick={() => handlePageChange(currentPage + 1)}
                        className="btn btn-primary"
                    >
                        Pagina urmatoare
                    </button>
                </div>
            )}
        </main>
    );
}

export default MaterialList;