// `frontend/src/api/ProductionService.jsx`
import axios from 'axios';

const PRODUCTION_API_BASE_URL = 'http://localhost:8080/api/production';

/**
 * Saves a new production.
 *
 * @param {Object} production - The production to save.
 * @returns {Promise<Object>} The response data from the save request.
 */
export async function saveProduction(production) {
    return await axios.post(PRODUCTION_API_BASE_URL, production);
}

/**
 * Retrieves productions without pagination.
 *
 * @returns {Promise<Object>} The response data from the get request.
 */
export async function getProductionsNoPagination() {
    return await axios.get(`${PRODUCTION_API_BASE_URL}/no-pagination`);
}

/**
 * Retrieves a production by its unique identifier.
 *
 * @param {string} id - The unique identifier of the production.
 * @returns {Promise<Object>} The response data from the get request.
 */
export async function getProductionById(id) {
    return await axios.get(`${PRODUCTION_API_BASE_URL}/${id}`);
}

/**
 * Updates an existing production.
 *
 * @param {Object} production - The production to update.
 * @returns {Promise<Object>} The response data from the update request.
 */
export async function updateProduction(production) {
    return await axios.put(PRODUCTION_API_BASE_URL, production);
}

/**
 * Deletes a production by its unique identifier.
 *
 * @param {string} id - The unique identifier of the production.
 * @returns {Promise<Object>} The response data from the delete request.
 */
export async function deleteProduction(id) {
    return await axios.delete(`${PRODUCTION_API_BASE_URL}/${id}`);
}