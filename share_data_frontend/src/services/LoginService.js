import axios from "axios";

const USER_REGISTER_URL = "http://localhost:8080/api/v1/login";
class LoginService
{
    saveUser(user)
    {
        return axios.post(USER_REGISTER_URL,user);
    }

}

export default new LoginService();