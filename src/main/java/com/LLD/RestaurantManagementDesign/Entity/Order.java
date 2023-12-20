package com.LLD.RestaurantManagementDesign.Entity;

import java.util.Set;

public class Order {
    private String orderId;
    private Table table;
    private Set<OrderItem> orderItems;
}
