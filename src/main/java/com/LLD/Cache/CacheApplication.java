package com.LLD.Cache;

import com.LLD.Cache.Policy.EvictionPolicy.FCFSEvictionPolicy;
import com.LLD.Cache.dao.BookDao;
import com.LLD.Cache.entity.Book;
import com.LLD.Cache.intf.EvictionPolicy;
import com.LLD.Cache.intf.SampleRepository;

public class CacheApplication {
    public static void main(String[] args) {
        Book b1 = new Book("1","Utkarsh","Journey to Hyderabad");
        Book b2 = new Book("2","Divyanshu","Journey to Chikmanglur");
        Book b3 = new Book("3","XYZ","Journey to the center of the Earth");

        EvictionPolicy evictionPolicy = FCFSEvictionPolicy.getInstance();
        SampleRepository<Book, String> sampleRepository = BookDao.getInstance();

        Cache<Book, String> sampleCache = new Cache<>(evictionPolicy, sampleRepository, 2);

        sampleCache.setObject(b1.getId(), b1);
        sampleCache.setObject(b2.getId(), b2);
        sampleCache.setObject(b3.getId(), b3);

        sampleCache.getObject("1");
        sampleCache.getObject("2");
        sampleCache.getObject("3");

    }
}
