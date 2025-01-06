// eslint-disable-next-line no-unused-vars
import React from 'react';
import PropTypes from 'prop-types';

const MaterialeList = ({ materials, comenzi, productie }) => {
    return (
        <div>
            <h2>Materials</h2>
            <ul>
                {materials.map(material => (
                    <li key={material.id}>{material.nume}</li>
                ))}
            </ul>
            <h2>Comenzi</h2>
            <ul>
                {comenzi.map(comanda => (
                    <li key={comanda.id}>{comanda.nume}</li>
                ))}
            </ul>
            <h2>Productie</h2>
            <ul>
                {productie.map(prod => (
                    <li key={prod.id}>{prod.numeLucrator} - {prod.cantitateProdusa}</li>
                ))}
            </ul>
        </div>
    );
}

MaterialeList.propTypes = {
    materials: PropTypes.array.isRequired,
    comenzi: PropTypes.array.isRequired,
    productie: PropTypes.array.isRequired,
};

export default MaterialeList;