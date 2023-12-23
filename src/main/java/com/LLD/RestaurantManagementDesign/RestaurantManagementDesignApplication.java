package com.LLD.RestaurantManagementDesign;

import com.LLD.RestaurantManagementDesign.Dao.WaiterDao;
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

        //  create Menu
        MenuItem roti = MenuItemFactory.getMenuItem("Roti", 50.0);
        MenuItem paneer = MenuItemFactory.getMenuItem("Paneer Butter Masala", 150.0);
        Map<String,MenuItem> menuItemMap = new HashMap<>();
        menuItemMap.put(roti.getName(),roti);
        menuItemMap.put(paneer.getName(),paneer);

        Menu menu = Menu.getInstance(menuItemMap);

        //  Add chef
        HashSet<String> itemsCooked = new HashSet<>();
        itemsCooked.add("Roti");
        ChefService chefService = ChefService.getInstance();
        chefService.addChef("Akash",itemsCooked);

        //  Add waiter
        WaiterDao waiterDao = WaiterDao.getInstance();
        waiterDao.addWaiter("Raj");


        Table t1 = new Table("1",null);
        Table t2 = new Table("2",null);

        //  TODO: search for tables depending upon number of customers

        Customer c1 = new Customer("1","Utkarsh",t1);
        Customer c2 = new Customer("2","Vishal",t1);
        Customer c3 = new Customer("3","Kulbhushan",t2);

        //  placeOrder (Producer)
        OrderService orderService = OrderService.getInstance();
        Order order = orderService.createOrder(c1, Arrays.asList(roti));

        try{
            Thread.sleep(3000);
        }catch (Exception e){
            System.out.println("Error in thread sleep : "+e);
        }
        //  handle chef cooked food event
        for(OrderItem orderItem : order.getOrderItems()){
            //  cook item by item
            chefService.handleOrderItemCooked(orderItem);
        }


        System.out.println("Run !!!");
    }
}
