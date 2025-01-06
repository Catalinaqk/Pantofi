// eslint-disable-next-line no-unused-vars
import React from 'react';
import { useHistory } from 'react-router-dom';

const MainNavigation = () => {
    const history = useHistory();

    const navigateTo = (path) => {
        history.push(path);
    };

    return (
        <div style={{ display: 'flex', justifyContent: 'space-around', margin: '20px' }}>
            <button onClick={() => navigateTo('/materiale')}>Materiale</button>
            <button onClick={() => navigateTo('/comenzi')}>Comenzi</button>
            <button onClick={() => navigateTo('/productie')}>Productie</button>
        </div>
    );
};

export default MainNavigation;