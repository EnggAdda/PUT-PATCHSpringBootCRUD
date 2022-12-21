package com.example.springbootcrud.service.impl;

import com.example.springbootcrud.entity.User;
import com.example.springbootcrud.repo.UserRepo;
import com.example.springbootcrud.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public void insertUser(User user) {
        userRepo.save(user);
    }

    @Override
    public User getUserById(int id) {
        return userRepo.findById(id).orElseThrow();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User updateUserById(User user, int id) {
       User  userFromDb  = userRepo.findById(id).get();//1rst
          userFromDb.setName(user.getName());
          userFromDb.setFatherName(user.getFatherName());
          userFromDb.setAddress(user.getAddress());
          userFromDb.setAge(user.getAge());

        return userRepo.save(userFromDb);
    }

    @Override
    public User updateFieldsOfUserById(int id, Map<String, Optional> map) {

         User userFromDb  = userRepo.findById(id).get();

          for(Map.Entry<String ,Optional>  hm :map.entrySet()){

               String keyFromMap = hm.getKey();

                if(keyFromMap.equals("name")){

                    Optional<Object> oa = hm.getValue();
                    String value = oa.map (Object::toString).orElse (null);
                    userFromDb.setName(value);

                }

              if(keyFromMap.equals("fatherName")){

                  Optional<Object> oa = hm.getValue();
                  String value = oa.map (Object::toString).orElse (null);
                  userFromDb.setFatherName(value);

              }

              if(keyFromMap.equals("address")){

                  Optional<Object> oa = hm.getValue();
                  String value = oa.map (Object::toString).orElse (null);
                  userFromDb.setAddress(value);

              }

              if(keyFromMap.equals("age")){

                  Optional<Integer> oa = hm.getValue();
                  Integer value = Integer.valueOf(oa.get());
                  userFromDb.setAge(value);

              }
          }


        return userRepo.save(userFromDb);
    }

    @Override
    public void deleteUserById(int id) {

    }
}
