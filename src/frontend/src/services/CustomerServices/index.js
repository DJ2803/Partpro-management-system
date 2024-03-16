import axiosInstance from "../axiosInstance";


const PARTPRO_BASE_URL = 'http://localhost:8080/ppms';



class CustomerServices  {

    updatePersonalDetails(userId, customer) {
        return axiosInstance.put(`${PARTPRO_BASE_URL}/customer/update/${userId}`,customer)
    }

  

}

export default new CustomerServices();




