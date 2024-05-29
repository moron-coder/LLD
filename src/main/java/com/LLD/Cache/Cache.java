package com.LLD.Cache;

import com.LLD.Cache.intf.EvictionPolicy;
import com.LLD.Cache.intf.SampleRepository;

import java.util.HashMap;

public class Cache<T,ID> {
    private int CACHE_SIZE = 1;             //  default
    private HashMap<ID,T> cacheMap = new HashMap<>();
    private EvictionPolicy evictionPolicy;
    private SampleRepository<T,ID> repository;

    Cache(EvictionPolicy evictionPolicy, SampleRepository<T,ID> repository, int size) {
        this.evictionPolicy = evictionPolicy;
        this.repository = repository;
        this.CACHE_SIZE = size;
        cacheMap.clear();
    }

    public T getObject(ID id){
        if(cacheMap.containsKey(id)){
            System.out.println("cache hit for key : "+id);
            return cacheMap.get(id);
        }
        System.out.println("cache mishit for key : "+id);
        T obj = repository.findByID(id);
        setObject(id, obj);
        return obj;
    }

    private void insertObjectInCache(ID id, T obj){
        cacheMap.put(id, obj);
        evictionPolicy.insertKey(id);
    }

    public void setObject(ID id, T obj){
        if(!cacheMap.containsKey(id) && CACHE_SIZE==cacheMap.size()){
            ID evictedId = (ID) evictionPolicy.evictKey();
            System.out.println(evictedId+" evicted!!");
            cacheMap.remove(evictedId);
        }
        insertObjectInCache(id, obj);
    }

    public boolean setExpiryTime(T obj){
        //  TODO: complete logic for expiration
        return true;
    }

}
