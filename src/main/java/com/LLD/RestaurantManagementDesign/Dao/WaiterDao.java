package com.LLD.RestaurantManagementDesign.Dao;

import com.LLD.RestaurantManagementDesign.Entity.Table;
import com.LLD.RestaurantManagementDesign.Entity.Waiter;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

@Data
@Repository
public class WaiterDao {
    Queue<Waiter> waiters =new LinkedList<>();
}
