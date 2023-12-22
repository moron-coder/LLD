package com.LLD.RestaurantManagementDesign.Dao;

import com.LLD.RestaurantManagementDesign.Entity.Chef;
import com.LLD.RestaurantManagementDesign.Entity.MenuItem;
import lombok.Data;

import java.util.*;

@Data
public class ChefDao {
    Map<MenuItem, Queue<Chef>> itemChefsMap=new HashMap<>();
    Queue<Chef> chefs = new LinkedList<>();

    private static ChefDao instance;

    private ChefDao(){}

    public static ChefDao getInstance(){
        if(instance==null){
            instance = new ChefDao();
        }
        return instance;
    }
}
