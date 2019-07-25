package com.uptik.dao;

import com.uptik.model.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User user);

}
