    // eslint-disable-next-line no-unused-vars
import React, { useState, useEffect, useRef } from 'react';
import { getMaterialsNoPagination, saveMaterial } from '../api/MaterialeService';
import { getComenzi } from '../api/ComenziService';
import { Link } from 'react-router-dom';
import MaterialList from '../components/MaterialeList';

function HomePage() {
    const fileMaterialRef = useRef(null);
    const [data, setData] = useState([]);
    const [fileMaterial, setFileMaterial] = useState(null);
    const [valuesMaterial, setValuesMaterial] = useState({
        nume: "",
        tip: "",
        status: "",
        descriere: ""
    });
    const [comenzi, setComenzi] = useState([]);

    const getAllMaterialsNoPagination = async () => {
        try {
            const response = await getMaterialsNoPagination();
            setData(response.data);
        } catch (error) {
            console.error("Error getting materials", error);
        }
    };

    const getAllComenzi = async () => {
        try {
            const response = await getComenzi();
            setComenzi(response.data);
        } catch (error) {
            console.error("Error getting comenzi", error);
        }
    };

    const onchangeMaterial = (event) => {
        setValuesMaterial({ ...valuesMaterial, [event.target.name]: event.target.value });
    };

    const onchangeMaterialFile = (event) => {
        setFileMaterial(event.target.files[0]);
    };

    const handleNewMaterial = async (event) => {
        event.preventDefault();
        try {
            console.log("File material:", valuesMaterial);
            const { data } = await saveMaterial(valuesMaterial);
            console.log("Material saved:", data);
            setValuesMaterial({
                nume: "",
                tip: "",
                status: "",
                descriere: ""
            });
            getAllMaterialsNoPagination();
        } catch (error) {
            console.error("Error saving material:", error.response || error.message || error);
            alert("Eroare la salvarea materialului!");
            console.log("Material values:", valuesMaterial)
        }
    };

    useEffect(() => {
        getAllMaterialsNoPagination();
        getAllComenzi();
    }, []);

    return (
        <>
            <main className="main">
                <div className="container mt-3">
                <button type="button" className="btn btn-primary" data-bs-toggle="modal"
                        data-bs-target="#addMaterialBackDrop">
                    Adaugă material
                </button>
                    <Link to="/comenzi" className="btn btn-primary ms-3">Gestionare Comenzi</Link>
                </div>
                <div className="container-fluid mt-3 mb-3">
                    <MaterialList materials={data} comenzi={comenzi}/>
                </div>
            </main>
            <div className="modal fade" id="addMaterialBackDrop" data-bs-backdrop="static" data-bs-keyboard="false"
                 tabIndex="-1" aria-labelledby="staticBackdropLabel" aria-atomic="true" >
                <div className="modal-dialog">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h2 className="modal-title">Adaugă material</h2>
                        </div>
                        <form onSubmit={handleNewMaterial}>
                            <div className="modal-body">
                                <div className="input-group mb-3">
                                    <span className="input-group-text">Nume:</span>
                                    <input type="text" name="nume" value={valuesMaterial.nume}
                                           onChange={onchangeMaterial} className="form-control" required/>
                                </div>
                                <div className="input-group mb-3">
                                    <span className="input-group-text">Tip:</span>
                                    <input type="text" name="tip" value={valuesMaterial.tip}
                                           onChange={onchangeMaterial} className="form-control" required/>
                                </div>
                                <div className="input-group mb-3">
                                    <span className="input-group-text">Status:</span>
                                    <input type="text" name="status" value={valuesMaterial.status}
                                           onChange={onchangeMaterial} className="form-control" required/>
                                </div>
                                <div className="input-group mb-3">
                                    <span className="input-group-text">Descriere:</span>
                                    <input type="text" name="descriere" value={valuesMaterial.descriere}
                                           onChange={onchangeMaterial} className="form-control" required/>
                                </div>
                            </div>
                            <div className="modal-footer">
                                <button type="submit" className="btn btn-primary">Save</button>
                                <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </>
    );
}

    export default HomePage;