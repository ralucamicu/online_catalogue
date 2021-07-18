package com.example.online_catalogue.service;

import com.example.online_catalogue.entity.User;
import com.example.online_catalogue.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository rep;

    public List<User> getUsers(){
        return rep.findAll();
    }

    public void saveUser(User user){
        rep.save(user);
    }

}
