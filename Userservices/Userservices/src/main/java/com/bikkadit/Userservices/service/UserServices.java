package com.bikkadit.Userservices.service;

import com.bikkadit.Userservices.model.User;

import java.util.List;

public interface UserServices {
    User saveUser(User user);
    List<User> getAllUser();
    User getUser(String userId);
}
