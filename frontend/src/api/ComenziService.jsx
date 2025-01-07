import axios from "axios";

const COMENZI_API_BASE_URL = "http://localhost:8080/comenzi";

export async function saveComanda(comanda) {
    return await axios.post(`${COMENZI_API_BASE_URL}`, comanda);
}

export async function getComenziById(id){
    return await axios.get(`${COMENZI_API_BASE_URL}/${id}`);
}

export async function getComenzi() {
    try {
        return await axios.get(`${COMENZI_API_BASE_URL}`);
    } catch (error) {
        console.error("Eroare la obținerea comenzilor:", error.response || error.message);
        throw error;
    }
}
