import  axios from "axios";

const baseUrl = 'http://localhost:8080/ppms';
console.log(baseUrl)



const axiosInstance =axios.create({
    baseURL:baseUrl,
})


export default axiosInstance;