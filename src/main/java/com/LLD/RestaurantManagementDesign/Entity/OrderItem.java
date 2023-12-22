package com.LLD.RestaurantManagementDesign.Entity;

import com.LLD.RestaurantManagementDesign.Entity.MenuItem;
import lombok.Data;

public class OrderItem {
    private MenuItem menuItem;
    private Order order;
    private Chef chef;

    public OrderItem(Order order, MenuItem item) {
        this.menuItem=item;
        this.order=order;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof OrderItem){
            this.menuItem.equals(((OrderItem)obj).menuItem);
        }
        return false;
    }

    public void setOrder(Order order){
        this.order=order;
    }

    public MenuItem getMenuItem(){
        return this.menuItem;
    }

    public void setChef(Chef chef){
        this.chef=chef;
    }

    @Override
    public String toString(){
        return "OrderItem : "+this.menuItem;
    }
}
