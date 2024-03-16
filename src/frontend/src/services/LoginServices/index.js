import axiosInstance from "../axiosInstance";

const PARTPRO_BASE_URL = 'http://localhost:8080/ppms';



class LoginServices  {

    login(username, password) {
        return axiosInstance.post(`${PARTPRO_BASE_URL}/user/login/${username}/${password}`)
    }

    verifyOtp(id,otp)
    {
        return axiosInstance.post(`${PARTPRO_BASE_URL}/user/login/${id}/verifyotp/${otp}`)
    }

    signUp(user)
    {
        return axiosInstance.post(`${PARTPRO_BASE_URL}/user/signup`,user)
    }

    changepassword(userName, password){
   return axiosInstance.put(`${PARTPRO_BASE_URL}/user/changepassword/${userName}/${password}`)
    }



}

export default new LoginServices();




