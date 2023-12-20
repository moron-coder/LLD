package com.LLD.RestaurantManagementDesign.Entity;

import lombok.Data;

@Data
public class Customer extends Person{
    private Table table;

    public Customer(String id, String name, Table table) {
        super(id, name);
        this.table = table;
    }

    public void placeOrder(){

    }
}
