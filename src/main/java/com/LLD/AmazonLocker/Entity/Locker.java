package com.LLD.AmazonLocker.Entity;

import com.LLD.AmazonLocker.Enums;
import lombok.Data;

@Data
public class Locker {
    int id;
    Integer size;
    public Enums.LOCKER_STATUS status;

    public Locker(Integer size) {
        this.size = size;
        this.status = Enums.LOCKER_STATUS.AVAILABLE;
    }

    @Override
    public String toString(){
        return "[id : "+id+" size : "+size+"]";
    }
}
