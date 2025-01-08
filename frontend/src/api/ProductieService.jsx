import axios from 'axios';

const PRODUCTIE_API_BASE_URL = 'http://localhost:8080/api/productie';  // Adjust the base URL as needed

/**
 * Saves the production data including worker, material, and quantity used.
 *
 * @param {Object} productionData - The production data to save.
 * @param {string} productionData.worker - The worker assigned to the production process.
 * @param {string} productionData.materialId - The ID of the material used in production.
 * @param {number} productionData.quantity - The quantity of the material used.
 * @returns {Promise<Object>} The response data from the save request.
 */
export async function saveProduction(productionData) {
    try {
        const response = await axios.post(PRODUCTIE_API_BASE_URL, productionData);
        return response.data;
    } catch (error) {
        console.error("Error saving production:", error.response || error.message);
        throw error;
    }
}

/**
 * Retrieves all production entries.
 *
 * @returns {Promise<Object>} The response data from the get request.
 */
export async function getAllProductions() {
    try {
        const response = await axios.get(PRODUCTIE_API_BASE_URL);
        return response.data;
    } catch (error) {
        console.error("Error fetching productions:", error.response || error.message);
        throw error;
    }
}

/**
 * Retrieves a specific production entry by its ID.
 *
 * @param {string} id - The ID of the production entry to retrieve.
 * @returns {Promise<Object>} The response data from the get request.
 */
export async function getProductionById(id) {
    try {
        const response = await axios.get(`${PRODUCTIE_API_BASE_URL}/${id}`);
        return response.data;
    } catch (error) {
        console.error("Error fetching production by ID:", error.response || error.message);
        throw error;
    }
}

/**
 * Updates an existing production entry.
 *
 * @param {Object} productionData - The updated production data.
 * @returns {Promise<Object>} The response data from the update request.
 */
export async function updateProduction(productionData) {
    try {
        const response = await axios.put(PRODUCTIE_API_BASE_URL, productionData);
        return response.data;
    } catch (error) {
        console.error("Error updating production:", error.response || error.message);
        throw error;
    }
}

/**
 * Deletes a production entry by its ID.
 *
 * @param {string} id - The ID of the production entry to delete.
 * @returns {Promise<void>} A promise indicating the completion of the delete request.
 */
export async function deleteProduction(id) {
    try {
        await axios.delete(`${PRODUCTIE_API_BASE_URL}/${id}`);
    } catch (error) {
        console.error("Error deleting production:", error.response || error.message);
        throw error;
    }
}
