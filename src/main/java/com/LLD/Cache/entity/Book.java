package com.LLD.Cache.entity;

import lombok.Getter;

public class Book {
    @Getter
    String id;
    String title;
    String author;

    public Book(String id, String title, String author){
        this.id=id;
        this.title=title;
        this.author=author;
    }
}
