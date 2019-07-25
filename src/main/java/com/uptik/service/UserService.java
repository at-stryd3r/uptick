package com.uptik.service;

import com.uptik.User.UptickUser;
import com.uptik.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  extends UserDetailsService {

    User findByUserName(String userName);

    void save(UptickUser crmUser);
}
