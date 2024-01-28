package com.deepak.kamboj.MoneyManager.services;

import com.deepak.kamboj.MoneyManager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
}
