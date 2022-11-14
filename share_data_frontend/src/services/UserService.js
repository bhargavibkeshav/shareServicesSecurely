import axios from "axios";

const USER_REGISTER_URL = "http://localhost:8080/api/v1/user";
class UserService
{
    saveUser(user)
    {
        return axios.post(USER_REGISTER_URL,user);
    }

}

export default new UserService();