package com.spe.service;

import com.spe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spe.model.User;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    boolean doesUserExists(User user)
    {
        User users = userRepository.findByEmail(user.getEmail());
        return users == null ? false : true;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}