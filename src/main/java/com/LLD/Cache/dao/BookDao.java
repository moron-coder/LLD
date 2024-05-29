package com.LLD.Cache.dao;

import com.LLD.Cache.entity.Book;
import com.LLD.Cache.intf.SampleRepository;

import java.util.HashMap;

public class BookDao implements SampleRepository<Book,String> {
    public static HashMap<String, Book> bookMap = new HashMap<>();
    private static BookDao instance;

    private BookDao(){};

    public static BookDao getInstance(){
        if(instance==null){
            instance = new BookDao();
        }
        return instance;
    }

    @Override
    public Book findByID(String bookId) {
        if(bookMap.containsKey(bookId)){
            return bookMap.get(bookId);
        }
        return null;
    }
}
