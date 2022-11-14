package com.share_data_API.model;

import lombok.Data;

@Data
public class User
{
    private long id;
    private String FirstName;
    private String LastName;
    private String Username;
    private String Psword;
    private String Email;
    private String Role;

    public User(long id, String firstName, String lastName, String username, String psword, String email,String role) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        Username = username;
        Psword = psword;
        Email = email;
        Role = role;

    }

    public User() {
        this.id = 0;
        FirstName = "";
        LastName = "";
        Username = "";
        Psword = "";
        Email = "";
        Role = "";
    }
}
