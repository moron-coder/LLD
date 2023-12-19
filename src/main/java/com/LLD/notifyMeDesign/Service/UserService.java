package com.LLD.notifyMeDesign.Service;

import com.LLD.notifyMeDesign.Entity.User;
import io.micrometer.common.util.StringUtils;

import java.util.HashMap;

public class UserService {
    HashMap<String,User> registeredUsers;             //  {userEmail -> password}

    public boolean isValidUser(User user){
        return (StringUtils.isNotBlank(user.getEmail()) && StringUtils.isNotBlank(user.getPassword()) && StringUtils.isNotBlank(user.getName()));
    }

    public boolean registerUser(User user){
        if(!isValidUser(user)){
            System.out.println("Invalid user : "+user);
            return false;
        }
        if(registeredUsers.containsKey(user.getEmail())){
            System.out.println("User is already registered");
            return false;
        }
        registeredUsers.put(user.getEmail(),user);
        return true;
    }

    public boolean loginUser(User user){
        if(!registeredUsers.containsKey(user.getEmail()) ||
        !registeredUsers.get(user.getEmail()).equals(user.getPassword())) {
            System.out.println("Invalid username or password");
            return false;
        }
        return true;
    }

}
