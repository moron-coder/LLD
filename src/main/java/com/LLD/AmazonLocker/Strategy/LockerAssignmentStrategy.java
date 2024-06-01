package com.LLD.AmazonLocker.Strategy;

import com.LLD.AmazonLocker.Entity.LineItem;
import com.LLD.AmazonLocker.Entity.Locker;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface LockerAssignmentStrategy {
    public HashMap<Integer, Set<Integer>> assignLineItems(Set<LineItem> lineItems, List<Locker> lockers);
}
