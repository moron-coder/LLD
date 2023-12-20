package com.LLD.RestaurantManagementDesign;

import com.LLD.RestaurantManagementDesign.Entity.*;
import com.LLD.RestaurantManagementDesign.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class RestaurantManagementDesignApplication {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("1","Meghna");

        Table t1 = new Table("1");
        Table t2 = new Table("2");

        Customer c1 = new Customer("1","Utkarsh",t1);
        Customer c2 = new Customer("2","Vishal",t1);
        Customer c3 = new Customer("3","Kulbhushan",t2);

        //  TODO: search for tables depending upon number of customers

        //  create Menu
        MenuItem roti = new MenuItem("Roti",50);
        MenuItem paneer = new MenuItem("Paneer Butter Masala",150);

        Map<String,MenuItem> menuItemMap = new HashMap<>();
        menuItemMap.put(roti.getName(),roti);
        menuItemMap.put(paneer.getName(),paneer);
        Menu menu = Menu.getInstance(menuItemMap);

        //  placeOrder
        OrderService orderService = OrderService.getInstance();
        orderService.createOrder(c1, Arrays.asList(roti,paneer));

        System.out.println("Run !!!");
    }
}
