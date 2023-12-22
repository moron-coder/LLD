package com.LLD.RestaurantManagementDesign.Dao;

import com.LLD.RestaurantManagementDesign.Entity.Chef;
import com.LLD.RestaurantManagementDesign.Entity.MenuItem;
import lombok.Data;

import java.util.*;

public class ChefDao {
    HashMap<MenuItem, Queue<Chef>> itemChefsMap= new HashMap<>();
    Queue<Chef> chefs = new LinkedList<>();

    private static ChefDao instance;

    private ChefDao(){}

    public static ChefDao getInstance(){
        if(instance==null){
            instance = new ChefDao();
        }
        return instance;
    }

    public HashMap<MenuItem,Queue<Chef>> getItemChefsMap(){
        return this.itemChefsMap;
    }

    public Queue<Chef> getChefs(){
        return this.chefs;
    }
}
