import axios from "axios";

const COMENZI_API_BASE_URL = "http://localhost:8080/comenzi";

export async function saveComanda(comanda) {
    return await axios.post(`${COMENZI_API_BASE_URL}`, comanda);
}