import axios from 'axios';

const MATERIALE_API_BASE_URL = 'http://localhost:8080/api/materiale';

/**
 * Saves a new material.
 *
 * @param {Object} material - The material to save.
 * @returns {Promise<Object>} The response data from the save request.
 */
export async function saveMaterial(material) {
    return await axios.post(MATERIALE_API_BASE_URL, material);
}

/**
 * Retrieves materials without pagination.
 *
 * @returns {Promise<Object>} The response data from the get request.
 */
export async function getMaterialsNoPagination() {
    return await axios.get(`${MATERIALE_API_BASE_URL}/no-pagination`);
}

/**
 * Retrieves a material by its unique identifier.
 *
 * @param {string} id - The unique identifier of the material.
 * @returns {Promise<Object>} The response data from the get request.
 */
export async function getMaterialById(id) {
    return await axios.get(`${MATERIALE_API_BASE_URL}/${id}`);
}

/**
 * Updates an existing material.
 *
 * @param {Object} material - The material to update.
 * @returns {Promise<Object>} The response data from the update request.
 */
export async function updateMaterial(material) {
    return await axios.put(MATERIALE_API_BASE_URL, material);
}

/**
 * Updates the photo of a material.
 *
 * @param {FormData} formData - The form data containing the photo to update.
 * @returns {Promise<Object>} The response data from the update request.
 */
export async function updatePhoto(formData) {
    return await axios.put(`${MATERIALE_API_BASE_URL}/photo`, formData);
}

/**
 * Deletes a material by its unique identifier.
 *
 * @param {string} id - The unique identifier of the material.
 * @returns {Promise<Object>} The response data from the delete request.
 */
export async function deleteMaterial(id) {
    return await axios.delete(`${MATERIALE_API_BASE_URL}/${id}`);
}