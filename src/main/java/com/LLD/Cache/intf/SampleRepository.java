package com.LLD.Cache.intf;

public interface SampleRepository<T,ID> {
    public T findByID(ID id);
}
