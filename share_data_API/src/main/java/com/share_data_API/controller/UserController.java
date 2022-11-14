package com.share_data_API.controller;

import com.share_data_API.Validation.LoginValidation;
import com.share_data_API.model.User;
import com.share_data_API.model.UserLogin;
import com.share_data_API.services.IuserService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class UserController
{
  //  @Autowired
    private final IuserService userService;

    public UserController(IuserService userService)
    {
        this.userService=userService;
    }

    @PostMapping("/user")
    public String createUser(@RequestBody User user)
    {
        //System.out.println("soem"+user.getEmail());
        int strength = 10; // work factor of bcrypt
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPsword());
        user.setPsword(encodedPassword);
        String res = userService.createUser(user);
        return res;
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody UserLogin user)
    {
        LoginValidation lv = new LoginValidation();
        if(!lv.validateUser(user))
        {
            return "etl";
        }
        if(userService.findUser(user.getUsername(), user.getPsword()))
        {

            return "success";
        }
        else
        {
            return "fail";
        }
    }
}
