package com.LLD.RestaurantManagementDesign.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Order {
    private Table table;
    private Set<OrderItem> orderItems;

    public Order(Table table){
        this.table=table;
        this.orderItems = new HashSet<>();
    }

    public void addOrderItem(OrderItem item){
        orderItems.add(item);
        item.setOrder(this);
    }

    public void removeItem(OrderItem item){
        orderItems.remove(item);
    }
}
