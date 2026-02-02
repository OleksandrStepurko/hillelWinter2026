package com.hillel.tests.user;

public class UserCalculate {

    public String calculateFullName(User user){
        System.out.println("run calculateFullName");
        return user.getName() + " " + user.getName();
    }

}
