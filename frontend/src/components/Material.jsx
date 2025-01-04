//dezactivare EsLint
/* eslint-disable */
import React from "react";
import { Link } from "react-router-dom";


/**
 * Material component
 * @param {Object} props - The properties object.
 * @param {Object} props.material - The material object.
 * @param {string} props.material.id - The unique identifier of the material.
 * @param {string} props.material.photoURL - The URL of the material's photo.
 * @param {string} props.material.name - The name of the material.
 * @param {string} props.material.status - The status of the material.
 * @param {string} props.material.price - The price of the material.
 * @param {string} props.material.quantity - The quantity of the material.
 * @param {string} props.material.date - The date of the material.
 * @param {string} props.material.type - The type of the material.
 * @param {string} props.material.description - The description of the material.
 */
const Material = ({ material, comenzi }) => {

    console.log(comenzi);
    return(
        <Link to={`/materials/${material.id}`} className="card" style={{textDecoration:'none'}}>
            <div className="card max-auto">
                <div className="row g-0">
                    <div className="col-md-4">
                        <img src={material.photoURL} className="img-fluid rounded-start" alt={material.name} />
                    </div>
                    <div className="col-md-8">
                        <div className="card-body">
                            <h3 className="card-title">{material.name}</h3>
                            <h4><span className="badge text-bg-secondary">Nume material:</span> {material.name}</h4>
                            <h4><span className="badge text-bg-secondary">Status:</span>  {material.status}</h4>
                            <h4><span className="badge text-bg-secondary">Pret:</span>  {material.price}</h4>
                            <h4><span className="badge text-bg-secondary">Cantitate:</span>  {material.quantity}</h4>
                            <h4><span className="badge text-bg-secondary">Data:</span>  {material.date}</h4>
                            <h4><span className="badge text-bg-secondary">Tip:</span>  {material.type}</h4>
                            <h4><span className="badge text-bg-secondary">Descriere:</span>  {material.description}</h4>
                        </div>
                    </div>
                </div>
            </div>
        </Link>
    );
};

export default Material;