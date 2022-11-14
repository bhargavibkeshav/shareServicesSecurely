package com.share_data_API.services;

import com.share_data_API.model.User;

public interface IuserService {
    String createUser(User user);

    boolean findUser(String name, String password);

    String findPassword(String username);
}
