import axios from "axios";

const MATERIALE_API_BASE_URL = "http://localhost:8080/materials";

export async function saveMaterial(material) {
    return await axios.post(`${MATERIALE_API_BASE_URL}`, material);
}
