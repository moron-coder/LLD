package com.LLD.RestaurantManagementDesign.Dao;

import com.LLD.RestaurantManagementDesign.Entity.Chef;
import com.LLD.RestaurantManagementDesign.Entity.MenuItem;
import com.LLD.RestaurantManagementDesign.Entity.OrderItem;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

@Data
public class ChefDao {
    Map<MenuItem, Queue<Chef>> itemChefsMap=new HashMap<>();
    Map<Chef, Set<OrderItem>> chefOrderItemsMap=new HashMap<>();
}
