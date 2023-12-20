package com.LLD.RestaurantManagementDesign.Service;

import com.LLD.RestaurantManagementDesign.Entity.Customer;
import com.LLD.RestaurantManagementDesign.Entity.MenuItem;
import com.LLD.RestaurantManagementDesign.Entity.Order;
import com.LLD.RestaurantManagementDesign.Entity.OrderItem;

import java.util.Set;

public class WaiterService {

    public void handleOrderItemCooked(OrderItem item){

    }

    private Order createOrder(Customer customer, Set<MenuItem> menuItems){
        Order order = new Order(customer.getTable());
        for(MenuItem menuItem : menuItems){
            order.addOrderItem(new OrderItem(order,menuItem));
        }
        return order;
    }

    public void getOrderFromCustomer(Customer customer, Set<MenuItem> menuItems){
        //  Create order from menuItems and customer

    }
}
