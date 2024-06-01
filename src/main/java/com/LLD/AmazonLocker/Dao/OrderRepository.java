package com.LLD.AmazonLocker.Dao;

import com.LLD.AmazonLocker.Entity.Order;

import java.util.HashMap;

public class OrderRepository implements DummyJPARepository<Order, Integer>{
    private static OrderRepository instance;
    public static int RANDOM_ORDER_ID_GENERATOR=1;

    private HashMap<Integer, Order> orders = new HashMap<>();

    public static OrderRepository getInstance(){
        if(instance==null){
            instance = new OrderRepository();
        }
        return instance;
    }

    @Override
    public Order findById(Integer id) {
        if(orders.containsKey(id)){
            return orders.get(id);
        }
        return null;
    }

    @Override
    public int save(Order obj) {
        int objId = RANDOM_ORDER_ID_GENERATOR;
        RANDOM_ORDER_ID_GENERATOR++;
        orders.put(objId, obj);
        obj.setId(objId);
        return objId;
    }
}
