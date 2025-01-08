// eslint-disable-next-line no-unused-vars
import React from "react";
import { Link } from "react-router-dom";


/**
 * Material component
 *
 * @param {Object} props - The properties object.
 * @param {Object} props.material - The material object.
 * @param {string} props.material.id - The unique identifier of the material.
 * @param {string} props.material.photoURL - The URL of the material's photo.
 * @param {string} props.material.nume - The name of the material.
 * @param {string} props.material.tip - The type of the material.
 * @returns {JSX.Element} The rendered Material component.
 * @constructor
 */
// eslint-disable-next-line react/prop-types
const Material = ({ material , comenzi}) => {

    console.log(material);
    return(
        // eslint-disable-next-line react/prop-types
        <Link to={`/materiale/${material.id}`} className="card" style={{textDecoration:'none'}}>
            <div className="card max-auto">
                <div className="row g-0">
                    <div className="col-md-4">
                        {/* eslint-disable-next-line react/prop-types */}
                        <img src={material.photoURL} className="img-fluid rounded-start" alt={material.nume} />
                    </div>
                    <div className="col-md-8">
                        <div className="card-body">
                            {/* eslint-disable-next-line react/prop-types */}
                            <h3 className="card-title">{material.nume}</h3>
                            {/* eslint-disable-next-line react/prop-types */}
                            <h4><span className="badge text-bg-secondary">Nume:</span> {material.nume} </h4>
                            {/* eslint-disable-next-line react/prop-types */}
                            <h4><span className="badge text-bg-secondary">Tip:</span>  {material.tip}</h4>
                        </div>
                    </div>
                </div>
            </div>
        </Link>
    );
};

export default Material;