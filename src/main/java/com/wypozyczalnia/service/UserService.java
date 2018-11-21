package com.wypozyczalnia.service;

import java.util.List;

import com.wypozyczalnia.model.User;


public interface UserService {

    List<User> findAllUsers();

    void saveUser(User user);

    void deleteUser(String id);

    void updateUser(User user);

}
