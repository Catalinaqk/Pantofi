// eslint-disable-next-line no-unused-vars
import React from 'react';
import PropTypes from 'prop-types';

const MaterialeList = ({ materials, comenzi }) => {
    return (
        <div>
            <h2>Materials</h2>
            <ul>
                {materials.map(material => (
                    <li key={material.id}>{material.name}</li>
                ))}
            </ul>
            <h2>Comenzi</h2>
            <ul>
                {comenzi.map(comanda => (
                    <li key={comanda.id}>{comanda.name}</li>
                ))}
            </ul>
        </div>
    );
}

MaterialeList.propTypes = {
    materials: PropTypes.array.isRequired,
    comenzi: PropTypes.array.isRequired,
};

export default MaterialeList;