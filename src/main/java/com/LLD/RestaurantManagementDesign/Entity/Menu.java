package com.LLD.RestaurantManagementDesign.Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Menu {
    Map<String,MenuItem> menuItems;
    private static Menu instance;

    private Menu(Map<String,MenuItem> menuItems){
        this.menuItems = menuItems;
    }

    public Menu getInstance(Map<String,MenuItem> menuItems){
        if(instance==null){
            instance = new Menu(menuItems);
        }
        return instance;
    }

    public void addMenuItem(String name, double price){
        if(menuItems.containsKey(name)){
            System.out.println("Item already present in menu : "+name);
        }else{
            menuItems.put(name,new MenuItem(name,price));
        }
    }

    public MenuItem getMenuItem(String name){
        if(menuItems.containsKey(name)){
            return menuItems.get(name);
        }
        System.out.println("No menu item present with name : "+name);
        return null;
    }
}
