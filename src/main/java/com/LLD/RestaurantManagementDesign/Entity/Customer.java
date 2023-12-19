package com.LLD.RestaurantManagementDesign.Entity;

public class Customer extends Person{
    private String tableId;

    public Customer(String id, String name, String tableId) {
        super(id, name);
        this.tableId = tableId;
    }

    public void placeOrder(){

    }
}
