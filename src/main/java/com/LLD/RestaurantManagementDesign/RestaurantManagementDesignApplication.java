package com.LLD.RestaurantManagementDesign;

import com.LLD.RestaurantManagementDesign.Entity.*;
import com.LLD.RestaurantManagementDesign.Factory.MenuItemFactory;
import com.LLD.RestaurantManagementDesign.Service.ChefService;
import com.LLD.RestaurantManagementDesign.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@SpringBootApplication
public class RestaurantManagementDesignApplication {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("1","Meghna");

        Table t1 = new Table("1",null);
        Table t2 = new Table("2",null);

        Customer c1 = new Customer("1","Utkarsh",t1);
        Customer c2 = new Customer("2","Vishal",t1);
        Customer c3 = new Customer("3","Kulbhushan",t2);

        //  TODO: search for tables depending upon number of customers

        //  create Menu
        MenuItem roti = MenuItemFactory.getMenuItem("Roti", 50.0);
        MenuItem paneer = MenuItemFactory.getMenuItem("Paneer Butter Masala", 150.0);

        ChefService chefService = ChefService.getInstance();

        HashSet<String> itemsCooked = new HashSet<>();
        itemsCooked.add("Roti");
        chefService.addChef("Akash",itemsCooked);

        Map<String,MenuItem> menuItemMap = new HashMap<>();
        menuItemMap.put(roti.getName(),roti);
        menuItemMap.put(paneer.getName(),paneer);
        Menu menu = Menu.getInstance(menuItemMap);

        //  placeOrder (Producer)
        OrderService orderService = OrderService.getInstance();
        orderService.createOrder(c1, Arrays.asList(roti,paneer));

        try{
            Thread.sleep(3000);
        }catch (Exception e){
            System.out.println("Error in thread sleep : "+e);
        }
        System.out.println("Run !!!");
    }
}
