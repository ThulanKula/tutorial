package com.thulani.service;

import com.thulani.entity.User;
import com.thulani.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List <User> userList(){
        return userRepo.findAll();
    }

    public void saveUser (User user){
        userRepo.saveAndFlush(user);
    }

    public User get (String id){
        return userRepo.findById(id).get();
    }

    public void deleteUser(String id){
        userRepo.deleteById(id);
    }
}

