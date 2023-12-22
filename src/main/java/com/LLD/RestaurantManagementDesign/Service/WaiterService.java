package com.LLD.RestaurantManagementDesign.Service;

import com.LLD.RestaurantManagementDesign.Dao.WaiterDao;
import com.LLD.RestaurantManagementDesign.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class WaiterService {

    @Autowired
    private WaiterDao waiterDao;

    private static WaiterService instance;

    private WaiterService(){}

    public static WaiterService getInstance(){
        if(instance==null){
            instance = new WaiterService();
        }
        return  instance;
    }

    public void handleOrderItemCooked(OrderItem item){

    }

    private Order createOrder(Customer customer, Set<MenuItem> menuItems){
        Order order = new Order(customer.getTable());
        for(MenuItem menuItem : menuItems){
            order.addOrderItem(new OrderItem(order,menuItem));
        }
        return order;
    }

    private Waiter assignWaiter(Table table){
        if(table==null){
            System.out.println("Empty table passed");
            return null;
        }
        Waiter waiter =  waiterDao.getWaiters().poll();
        if(waiter==null){
            System.out.println("No waiter available to take order");
            return null;
        }
        waiter.addTable(table);
        return waiter;
    }

    public void getOrderFromCustomer(Table table, Order order){
        //  assign available waiter
        Waiter waiter = assignWaiter(table);
        if(waiter==null){
            return;
        }
        waiter.takeOrder(order);
        CookService cookService = CookService.getInstance();
        cookService.assignOrderItems(order.getOrderItems());
    }
}
