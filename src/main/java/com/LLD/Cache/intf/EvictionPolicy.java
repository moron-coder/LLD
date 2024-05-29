package com.LLD.Cache.intf;

public interface EvictionPolicy<ID>{
    public void insertKey(ID id);
    public ID evictKey();
}