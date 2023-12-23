package com.LLD.RestaurantManagementDesign.Service;

import com.LLD.RestaurantManagementDesign.Dao.WaiterDao;
import com.LLD.RestaurantManagementDesign.Entity.*;
import com.LLD.RestaurantManagementDesign.Enums.OrderItemStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class WaiterService {

    private static WaiterService instance;

    private WaiterService(){}

    public static WaiterService getInstance(){
        if(instance==null){
            instance = new WaiterService();
        }
        return  instance;
    }

    public void handleOrderItemCooked(OrderItem item){
        if(item==null || item.getOrder()==null || item.getOrder().getTable()==null ||
                item.getOrder().getTable().getWaiter()==null){
            System.out.println("No chef was assigned for item : "+item);
            return;
        }
        Table table = item.getOrder().getTable();
        Waiter waiter = item.getOrder().getTable().getWaiter();
        item.setStatus(OrderItemStatus.SERVED);
        System.out.println(item+" was served by "+waiter+" on "+table);
    }

    private Order createOrder(Customer customer, Set<MenuItem> menuItems){
        Order order = new Order(customer.getTable());
        for(MenuItem menuItem : menuItems){
            order.addOrderItem(new OrderItem(order,menuItem));
        }
        return order;
    }

    private Waiter assignWaiter(Table table){
        WaiterDao waiterDao = WaiterDao.getInstance();
        if(table==null){
            System.out.println("Empty table passed");
            return null;
        }
        Waiter waiter = waiterDao.getWaiters().poll();
        if(waiter==null){
            System.out.println("No waiter available to take order");
            return null;
        }
        waiter.addTable(table);
        System.out.println(waiter+" is assigned to "+table);
        return waiter;
    }

    public void getOrderFromCustomer(Table table, Order order){
        //  assign available waiter
        Waiter waiter = assignWaiter(table);
        if(waiter==null){
            return;
        }
        waiter.takeOrder(order);
        ChefService chefService = ChefService.getInstance();
        chefService.assignOrderItems(order.getOrderItems());
    }
}
