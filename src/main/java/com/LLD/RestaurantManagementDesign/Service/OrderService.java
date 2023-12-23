package com.LLD.RestaurantManagementDesign.Service;

import com.LLD.RestaurantManagementDesign.Entity.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private static OrderService instance;

    private OrderService(){}

    public static OrderService getInstance(){
        if(instance==null){
            instance = new OrderService();
        }
        return instance;
    }

    public Order createOrder(Customer customer, List<MenuItem> menuItems){
        Order order = new Order(customer.getTable());
        for(MenuItem menuItem:menuItems){
            order.addOrderItem(new OrderItem(order,menuItem));
        }
        WaiterService waiterService = WaiterService.getInstance();
        waiterService.getOrderFromCustomer(customer.getTable(),order);
        return order;
    }
}
