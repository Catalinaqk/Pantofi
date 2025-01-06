// eslint-disable-next-line no-unused-vars
import React, { useState, useEffect, useRef } from 'react';
import { getMaterialsNoPagination, saveMaterial, saveMaterialPhoto } from '../api/MaterialService';
import { getComenzi } from '../api/ComenziService';
import MaterialList from '../components/MaterialList';
import Header from '../components/Header';

function HomePage() {
    const fileMaterialRef = useRef(null);
    const [data, setData] = useState([]);
    const [userType, setUserType] = useState('guest');
    const [userName, setUserName] = useState('');
    const [userEmail, setUserEmail] = useState('');
    const [fileMaterial, setFileMaterial] = useState(undefined);
    const [valuesMaterial, setValuesMaterial] = useState({
        name: "",
        type: "",
        status: "",
        price: "",
        quantity: "",
        date: "",
        description: ""
    });
    const [comenzi, setComenzi] = useState([]);
    const [searchterm, setSearchterm] = useState('');

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
            const response = await saveMaterial(valuesMaterial);
            const formData = new FormData();
            formData.append('file', fileMaterial, fileMaterial.name);
            formData.append("id", response.data.id);
            await saveMaterialPhoto(formData);
            setFileMaterial(undefined);
            fileMaterialRef.current.value = null;
            setValuesMaterial({
                name: "",
                type: "",
                status: "",
                price: "",
                quantity: "",
                date: "",
                description: ""
            });
            getAllMaterialsNoPagination();
        } catch (error) {
            console.error("Error saving material", error);
        }
    };

    useEffect(() => {
        getAllMaterialsNoPagination();
        getAllComenzi();
    }, []);

    const filteredComenzi = comenzi.filter(comanda =>
        `${comanda.name} ${comanda.status} ${comanda.price} ${comanda.quantity} ${comanda.date} ${comanda.description}`.toLowerCase().includes(searchterm.toLowerCase())
    );

    return (
        <>
            <Header departamentType={userType} departamentName={userName} departamentEmail={userEmail} setDepartamentType={setUserType} setDepartamentName={setUserName} setDepartamentEmail={setUserEmail} nbOfMaterials={data.length} />
            <main className="main">
                <div className="container-fluid mt-3 mb-3">
                    <MaterialList materials={data} comenzi={comenzi} />
                </div>
            </main>

            <div className="modal fade" id="addMaterialBackDrop" data-bs-backdrop="static" data-bs-keyboard="false"
                 tabIndex="-1" aria-labelledby="staticBackdropLabel" aria-atomic="true">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h5 className="modal-title">Adaugă material</h5>
                            <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close" />
                        </div>
                        <form onSubmit={handleNewMaterial}>
                            <div className="modal-body">
                                <div className="input-group mb-3">
                                    <span className="input-group-text" id="inputGroup-sizing-default">Nume:</span>
                                    <input type="text" name="name" value={valuesMaterial.name}
                                           onChange={onchangeMaterial} className="form-control" aria-label="Sizing example input"
                                           aria-describedby="inputGroup-sizing-default" required />
                                </div>
                                <div className="input-group mb-3">
                                    <span className="input-group-text" id="inputGroup-sizing-default">Comandă:</span>
                                    <input type="text" name="searchTerm" value={searchterm}
                                           onChange={(e) => setSearchterm(e.target.value)} className="form-control"
                                           aria-label="Sizing example input"
                                           aria-describedby="inputGroup-sizing-default" placeholder="Search comenzi" />
                                    <select name="comenziId" value={valuesMaterial.comenziId} onChange={onchangeMaterial} className="form-control" required>
                                        <option value="">Selectează comanda</option>
                                        {filteredComenzi.map(comanda => (
                                            <option key={comanda.id} value={comanda.id}>
                                                {comanda.name} {comanda.status} {comanda.price} {comanda.quantity} {comanda.date} {comanda.description}
                                            </option>
                                        ))}
                                    </select>
                                </div>
                                <div className="input-group mb-3">
                                    <span className="input-group-text" id="inputGroup-sizing-default">Tip:</span>
                                    <input type="text" name="type" value={valuesMaterial.type}
                                           onChange={onchangeMaterial} className="form-control"
                                           aria-label="Sizing example input"
                                           aria-describedby="inputGroup-sizing-default" required />
                                </div>
                                <div className="input-group mb-3">
                                    <span className="input-group-text" id="inputGroup-sizing-default">Status:</span>
                                    <input type="text" name="status" value={valuesMaterial.status}
                                           onChange={onchangeMaterial} className="form-control"
                                           aria-label="Sizing example input"
                                           aria-describedby="inputGroup-sizing-default" required />
                                </div>
                                <div className="input-group mb-3">
                                    <span className="input-group-text" id="inputGroup-sizing-default">Preț:</span>
                                    <input type="text" name="price" value={valuesMaterial.price}
                                           onChange={onchangeMaterial} className="form-control"
                                           aria-label="Sizing example input"
                                           aria-describedby="inputGroup-sizing-default" required />
                                </div>
                                <div className="input-group mb-3">
                                    <span className="input-group-text" id="inputGroup-sizing-default">Cantitate:</span>
                                    <input type="text" name="quantity" value={valuesMaterial.quantity}
                                           onChange={onchangeMaterial} className="form-control"
                                           aria-label="Sizing example input"
                                           aria-describedby="inputGroup-sizing-default" required />
                                </div>
                                <div className="input-group mb-3">
                                    <span className="input-group-text" id="inputGroup-sizing-default">Descriere:</span>
                                    <input type="text" name="description" value={valuesMaterial.description}
                                           onChange={onchangeMaterial} className="form-control"
                                           aria-label="Sizing example input"
                                           aria-describedby="inputGroup-sizing-default" required />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="formFileMaterial" className="form-label">Adaugă poză:</label>
                                    <input className="form-control" type="file" id="formFileMaterial" ref={fileMaterialRef}
                                           name="photoURL" onChange={onchangeMaterialFile} required />
                                </div>
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="submit" className="btn btn-primary">Save changes</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </>
    );
}

export default HomePage;