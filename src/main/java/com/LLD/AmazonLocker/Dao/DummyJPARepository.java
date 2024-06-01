package com.LLD.AmazonLocker.Dao;

public interface DummyJPARepository<T,ID> {
    public T findById(ID id);
    public int save(T obj);
}
