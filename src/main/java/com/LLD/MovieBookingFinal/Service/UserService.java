package com.LLD.MovieBookingFinal.Service;

import com.LLD.MovieBookingFinal.Entity.Entity;
import com.LLD.MovieBookingFinal.Entity.User;

import java.util.HashMap;

public class UserService {
    private final HashMap<String, User> registeredUsers = new HashMap();    //  email -> User
    private static UserService instance;
    private UserService(){};
    public synchronized static UserService getInstance(){
        if(instance==null){
            instance = new UserService();
        }
        return instance;
    }

    public User registerUser(String name, String email){
        User user = registeredUsers.get(email);
        if(user!=null){
            System.out.println(email+" is already registered");
        }else{
            User newUser = new User(name, email);
            registeredUsers.put(email, newUser);
            user = newUser;
        }
        return user;
    }
}
