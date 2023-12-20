package com.LLD.RestaurantManagementDesign;

import com.LLD.RestaurantManagementDesign.Entity.Customer;
import com.LLD.RestaurantManagementDesign.Entity.Restaurant;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantManagementDesignApplication {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("1","Meghna");

        Customer c1 = new Customer("1","Utkarsh","3");
        Customer c2 = new Customer("2","Vishal","3");
        Customer c3 = new Customer("3","Kulbhushan","4");

        //  TODO: search for tables depending upon number of customers

        //  create Menu


        //  placeOrder

        System.out.println("Run !!!");
    }
}
