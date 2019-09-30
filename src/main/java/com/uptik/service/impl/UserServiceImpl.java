package com.uptik.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

}
