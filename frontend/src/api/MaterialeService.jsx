import axios from 'axios';

const API_URL = 'http://localhost:8080/api/materiale';

export const getMaterialsNoPagination = () => {
    return axios.get(API_URL);
};

export const saveMaterial = (materiale) => {
    return axios.post(API_URL, materiale);
};

