package com.LLD.Cache.Controller;

import com.LLD.Cache.Cache;

public class CacheController<T,ID> {
    Cache<T, ID> sampleCache;

    public CacheController(Cache<T,ID> sampleCache){
        this.sampleCache = sampleCache;
    }

    public T getObject(ID id){
        return sampleCache.getObject(id);
    }

    public void setObject(ID id, T obj){

    }
}
