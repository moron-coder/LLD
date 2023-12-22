package com.LLD.RestaurantManagementDesign.Dao;

import com.LLD.RestaurantManagementDesign.Entity.Order;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Data
public class OrderDao {
    Map<String, Order> orderMap;
}
