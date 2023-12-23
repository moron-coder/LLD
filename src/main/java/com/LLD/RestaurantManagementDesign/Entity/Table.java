package com.LLD.RestaurantManagementDesign.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Table {
    private String tableId;
    private Waiter waiter;

    @Override
    public String toString(){
        return "table : "+tableId;
    }
}
