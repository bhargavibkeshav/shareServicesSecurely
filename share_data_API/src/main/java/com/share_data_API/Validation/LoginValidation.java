package com.share_data_API.Validation;

import com.share_data_API.model.UserLogin;

public class LoginValidation
{
    UserLogin u = null;
    public boolean validateUser(UserLogin user)
    {
        u = user;
        if(u.getUsername().length()>150)
        {
            return false;
        }
        if(u.getPsword().length()>150)
        {
            return false;
        }
        return true;
    }
}
