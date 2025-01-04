import axios from "axios";

const COMENZI_API_BASE_URL = "http://localhost:8080/comenzi";

export async function saveComanda(comanda) {
    return await axios.post(COMENZI_API_BASE_URL, comanda);
}

export async function getComandaById(id) {
    return await axios.get(`${COMENZI_API_BASE_URL}/${id}`);
}

export async function getComenzi()
{
    return await axios.get(COMENZI_API_BASE_URL);
}

export class saveComenzi {
}