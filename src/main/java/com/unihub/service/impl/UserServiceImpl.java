package com.unihub.service.impl;

import com.unihub.entity.User;
import com.unihub.repository.UserRepository;
import com.unihub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {

        return userRepository.save(user);

    }

}