package com.LLD.notifyMeDesign.Entity;

import lombok.Data;

@Data
public class User {
    String name;
    String email;
    String password;

    public String toString(){
        return "name : "+name +
                " email : "+email+
                " password : "+password;
    }
}
