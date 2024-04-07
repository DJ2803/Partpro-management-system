
import axiosInstance from "../axiosInstance";

const PARTPRO_BASE_URL = 'http://localhost:8080/ppms';



class PaymentServices  {

    createPayment(userId, cart) {
        return axiosInstance.post(`${PARTPRO_BASE_URL}/payment/${userId}/create`,cart)
    }

    trackOrder(orderId) {
        return axiosInstance.get(`${PARTPRO_BASE_URL}/payment/trackorderdetails/${orderId}`)
    }

}

export default new PaymentServices();




