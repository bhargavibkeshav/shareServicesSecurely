package com.share_data_API.services;

import com.share_data_API.entities.UserEntity;
import com.share_data_API.model.User;
import com.share_data_API.repo.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.security.SecureRandom;
import java.util.List;

@Service
public class UserService implements IuserService
{
    private UserRepository userRepository;
    @PersistenceContext
    private EntityManager em;
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    @Override
    public String createUser(User user)
    {
        String res = "";
        try {

            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(user, userEntity);
            userRepository.save(userEntity);
            res = "success";
            System.out.println(res);
        }
        catch (Exception ex)
        {
            res="fail";
            System.out.println("duplicate");
        }
        return res;
    }

    @Override
    public String findPassword(String username)
    {
        String qu = "select Psword from UserEntity where username='"  +username+ "'";
        Query q = em.createQuery(qu);
        List<Object> l = q.getResultList();

        String pass = "";
        try {

            for (Object entity : l)
            {
                //System.out.println("test"+entity.toString());
                pass = entity.toString();
            }

        }
        catch (Exception ex)
        {
            System.out.println("error");
        }
        em.close();
        return pass;
    }
  //  @Query("select UserEntity.Psword from UserEntity p where UserEntity.Username= ?1")
    @Override
      public boolean findUser(String name, String password)
      {
          //int strength = 10; // work factor of bcrypt

          //System.out.println(encodedPassword);
          String qu = "select Psword from UserEntity where username='"  +name+ "'";
          Query q = em.createQuery(qu);
          List<Object> l = q.getResultList();


          //System.out.println(l.get(0));
          boolean res = false;
          try {
              String pass = "";
              for (Object entity : l)
              {
                  //System.out.println("test"+entity.toString());
                  pass = entity.toString();
              }
              int strength = 10;
              BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
              if(bCryptPasswordEncoder.matches(password,pass))
              {
                  res = true;
              }
              else {
                  return false;
              }
          }
          catch (Exception ex)
          {
              System.out.println("error");
          }
          em.close();
          System.out.println(res);
          return res;
      }


}
