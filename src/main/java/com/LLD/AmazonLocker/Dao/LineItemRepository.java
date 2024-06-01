package com.LLD.AmazonLocker.Dao;

import com.LLD.AmazonLocker.Entity.LineItem;
import com.LLD.AmazonLocker.Entity.Order;

import java.util.HashMap;

public class LineItemRepository implements DummyJPARepository<LineItem,Integer> {
    HashMap<Integer, LineItem> lineItems = new HashMap<>();
    public static int RANDOM_LINEITEM_ID_GENERATOR=1;
    private static LineItemRepository instance;

    public static LineItemRepository getInstance(){
        if(instance==null){
            instance = new LineItemRepository();
        }
        return instance;
    }

    @Override
    public LineItem findById(Integer integer) {
        if(lineItems.containsKey(integer)){
            return lineItems.get(integer);
        }
        return null;
    }

    @Override
    public int save(LineItem obj) {
        int objId = RANDOM_LINEITEM_ID_GENERATOR;
        RANDOM_LINEITEM_ID_GENERATOR++;
        lineItems.put(objId, obj);
        obj.setId(objId);
        return objId;
    }
}
