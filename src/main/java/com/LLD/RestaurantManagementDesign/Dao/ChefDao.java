package com.LLD.RestaurantManagementDesign.Dao;

import com.LLD.RestaurantManagementDesign.Entity.Chef;
import com.LLD.RestaurantManagementDesign.Entity.MenuItem;
import com.LLD.RestaurantManagementDesign.Entity.OrderItem;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.*;

@Data
@Repository
public class ChefDao {
    Map<MenuItem, Queue<Chef>> itemChefsMap=new HashMap<>();

    Queue<Chef> chefs = new LinkedList<>();
}
