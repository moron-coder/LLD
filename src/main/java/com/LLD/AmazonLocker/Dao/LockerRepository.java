package com.LLD.AmazonLocker.Dao;

import com.LLD.AmazonLocker.Entity.Locker;
import com.LLD.AmazonLocker.Enums;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LockerRepository implements DummyJPARepository<Locker,String>{
    private static LockerRepository instance;
    public static int RANDOM_LOCKER_ID_GENERATOR=1;
    HashMap<Integer, Locker> lockers = new HashMap<>();

    public static LockerRepository getInstance(){
        if(instance==null){
            instance = new LockerRepository();
        }
        return instance;
    }

    @Override
    public Locker findById(String id) {
        if(lockers.containsKey(id)){
            return lockers.get(id);
        }
        return null;
    }

    public List<Locker> fetchAvailableLockers(){
        return lockers.values().stream()
                .filter(locker->Enums.LOCKER_STATUS.AVAILABLE.equals(locker.getStatus()))
                .collect(Collectors.toList());
    }

    @Override
    public int save(Locker obj) {
        int objId = RANDOM_LOCKER_ID_GENERATOR;
        RANDOM_LOCKER_ID_GENERATOR++;
        lockers.put(objId, obj);
        obj.setId(objId);
        return objId;
    }

    public void lockAllLockers(Set<Integer> lockerIds){
        lockerIds.forEach(id->lockers.get(id).setStatus(Enums.LOCKER_STATUS.BUSY));
    }
}
