package com.LLD.RestaurantManagementDesign.Factory;

import com.LLD.RestaurantManagementDesign.Entity.MenuItem;

import java.util.HashMap;

public class MenuItemFactory {
    private static HashMap<String, MenuItem> menuItemsMap = new HashMap<>();

    public static MenuItem getMenuItem(String name,Double price){
        MenuItem result = menuItemsMap.get(name);
        if(result==null){
            if(price==null){
                System.out.println("Can't add menuItem with null price");
                return null;
            }
            result = new MenuItem(name,price);
            menuItemsMap.put(name,result);
        }
        return result;
    }
}
