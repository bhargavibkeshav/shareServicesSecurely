package com.share_data_API.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class UserEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String FirstName;
    @Column(nullable = false)
    private String LastName;
    @Column(unique=true, nullable = false)
    private String Username;
    @Column(length=255, nullable = false)
    private String Psword;
    @Column(unique=true, nullable = false)
    private String Email;
    @Column(nullable = false)
    private String Role;

}
