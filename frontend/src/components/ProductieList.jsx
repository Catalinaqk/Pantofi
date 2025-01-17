// eslint-disable-next-line no-unused-vars
import React from 'react';
import PropTypes from 'prop-types';

const ProductieList = ({ productie }) => {
    return (
        <div>
            <h2>Producție</h2>
            <ul>
                {productie.map(prod => (
                    <li key={prod.id}>
                        {prod.numeLucrator} - {prod.cantitateProdusa} unități
                    </li>
                ))}
            </ul>
        </div>
    );
}

ProductieList.propTypes = {
    productie: PropTypes.array.isRequired,
};

export default ProductieList;
