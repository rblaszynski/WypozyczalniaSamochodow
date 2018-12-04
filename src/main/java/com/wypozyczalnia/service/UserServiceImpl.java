package com.wypozyczalnia.service;

import java.util.ArrayList;
import java.util.List;

import com.wypozyczalnia.dao.JDBCDriver;
import com.wypozyczalnia.model.Klient;
import com.wypozyczalnia.model.User;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static JDBCDriver jdbcDriver = new JDBCDriver();

    private static List<User> users = new ArrayList<>();

    public static List<Klient> klienci = new ArrayList<>();

    public List<User> findAllUsers() {
        users = jdbcDriver.selectAllUsers();
        return users;
    }

    public List<Klient> findAllClients(){
        klienci = jdbcDriver.selectAllClients();
        return klienci;
    }

    public void saveUser(User user) {
        jdbcDriver.insertUser(user);
    }

    public void deleteUser(String id){
        jdbcDriver.deleteUser(id);
    }

    public void updateUser(User user){
    jdbcDriver.updateUser(user);
    }


    }

