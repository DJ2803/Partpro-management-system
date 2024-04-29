import  axios from "axios";

const baseUrl = 'http://40.90.239.103:8080/ppms';
console.log(baseUrl)



const axiosInstance =axios.create({
    baseURL:baseUrl,
})


export default axiosInstance;