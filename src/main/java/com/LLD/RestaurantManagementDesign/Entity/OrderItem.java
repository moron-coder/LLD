package com.LLD.RestaurantManagementDesign.Entity;

import com.LLD.RestaurantManagementDesign.Entity.MenuItem;
import com.LLD.RestaurantManagementDesign.Enums.OrderItemStatus;
import lombok.Data;

public class OrderItem {
    private MenuItem menuItem;
    private Order order;
    private OrderItemStatus status;
    private Chef chef;

    public OrderItem(Order order, MenuItem item) {
        this.menuItem=item;
        this.order=order;
        this.status=OrderItemStatus.ORDER_TAKEN;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof OrderItem){
            this.menuItem.equals(((OrderItem)obj).menuItem);
        }
        return false;
    }

    public Order getOrder(){
        return this.order;
    }

    public void setOrder(Order order){
        this.order=order;
    }

    public MenuItem getMenuItem(){
        return this.menuItem;
    }

    public void setStatus(OrderItemStatus status){
        this.status=status;
    }

    public Chef getChef(){
        return this.chef;
    }

    public void setChef(Chef chef){
        this.chef=chef;
    }

    @Override
    public String toString(){
        return "OrderItem : "+this.menuItem;
    }
}
