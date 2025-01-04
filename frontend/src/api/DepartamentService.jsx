import axios from 'axios';

const DEPARTAMENT_API_BASE_URL = "http://localhost:8080/departaments";

/**
 * Get all departaments.
 *
 * @param {string} password - The password of the user.
 * @param {string} email - The description of the email.
 * @returns {Promise<Object>} The response data from the login request.
 * @throws {Error} If the credentials are invalid.
 */
export const login = async (password, email) => {
    try {
        const response = await axios.post('/api/login', { password, email });
        return response.data;
        // eslint-disable-next-line no-unused-vars
    } catch (error) {
        throw new Error('Invalid credentials');
    }
};

export async function saveDepartament(departament) {
    return await axios.post(`${DEPARTAMENT_API_BASE_URL}/register`, departament);
}

export async function loginDepartament(password, description) {
    //return await axios.get(`${DEPARTAMENT_API_BASE_URL}/${id}`);
    const response = await axios.post(`${DEPARTAMENT_API_BASE_URL}/login`, { password, description },{
        headers: {
            'Content-Type': 'application/json',
        },
    });
    return response.data;
}