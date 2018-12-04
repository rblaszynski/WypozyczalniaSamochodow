package com.wypozyczalnia.service;

import java.util.List;

import com.wypozyczalnia.model.Klient;
import com.wypozyczalnia.model.User;


public interface UserService {

    List<User> findAllUsers();

    List<Klient> findAllClients();

    void saveUser(User user);

    void deleteUser(String id);

    void updateUser(User user);

}
