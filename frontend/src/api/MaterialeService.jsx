import axios from 'axios';

const API_URL = 'http://localhost:8080/api/materiale';

export const getMaterialsNoPagination = () => {
    return axios.get(API_URL);
};

export const saveMaterial = (material) => {
    return axios.post(API_URL, material);
};

export const updatePhoto = (formData) => {
    return axios.post(`${API_URL}/upload`, formData);
};