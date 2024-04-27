import axiosInstance from "../axiosInstance";


const PARTPRO_BASE_URL = 'http://localhost:8080/ppms';


class EmployeeServices  {



    deleteProduct(productId){
      return axiosInstance.delete(`${PARTPRO_BASE_URL}/product/deleteProduct/${productId}`)
    }
    updateProduct(product){
        return axiosInstance.put(`${PARTPRO_BASE_URL}/product/updateProduct`,product)
    }

    addProduct(product){
        return axiosInstance.post(`${PARTPRO_BASE_URL}/product/addProduct`,product)
    }

    addOrUpdateInventory(productId, quantity)
{
    return axiosInstance.post(`${PARTPRO_BASE_URL}/employee/addOrUpdateProduct`,null,{
        params:{
            productId:productId,
            quantity:quantity
        }
      })
}



getInventoryByStatus(){
    return axiosInstance.get(`${PARTPRO_BASE_URL}/employee/getInventoryByStatus`)
}

findEmployeeByUserName(userName){
    return axiosInstance.get(`${PARTPRO_BASE_URL}/employee/findByUserName`,{
        params:{
            userName: userName
        }   
    })
}

findAssistantEmployee(){
    return axiosInstance.get(`${PARTPRO_BASE_URL}/employee/getAssistant`)
}
  
  

}

export default new EmployeeServices();