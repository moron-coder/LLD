package com.LLD.Cache.Policy.EvictionPolicy;

import com.LLD.Cache.intf.EvictionPolicy;

import java.util.LinkedList;
import java.util.Queue;

public class FCFSEvictionPolicy implements EvictionPolicy<String> {
    Queue<String> queue = new LinkedList<>();

    private static FCFSEvictionPolicy instance;

    FCFSEvictionPolicy(){
    }

    public static FCFSEvictionPolicy getInstance(){
        if(instance==null){
            instance = new FCFSEvictionPolicy();
        }
        return instance;
    }

    @Override
    public void insertKey(String id) {
        queue.add(id);
    }

    @Override
    public String evictKey() {
        return queue.poll();
    }

}
