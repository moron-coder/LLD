package com.LLD.RestaurantManagementDesign.Dao;

import com.LLD.RestaurantManagementDesign.Entity.Chef;
import com.LLD.RestaurantManagementDesign.Entity.MenuItem;
import com.LLD.RestaurantManagementDesign.Entity.OrderItem;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

@Data
@Repository
public class ChefDao {
    Map<MenuItem, Queue<Chef>> itemChefsMap=new HashMap<>();
}
