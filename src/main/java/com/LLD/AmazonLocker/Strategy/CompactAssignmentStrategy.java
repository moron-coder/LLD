package com.LLD.AmazonLocker.Strategy;

import com.LLD.AmazonLocker.Dao.LockerRepository;
import com.LLD.AmazonLocker.Entity.LineItem;
import com.LLD.AmazonLocker.Entity.Locker;
import com.LLD.AmazonLocker.Enums;

import java.util.*;

public class CompactAssignmentStrategy implements LockerAssignmentStrategy{
    private int fetchNextGreaterLockerIndex(List<Locker> lockers, Integer lineItemsSize){
        int lo=0,hi=lockers.size()-1,ans=-1;
        while (lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(lockers.get(mid).getSize().compareTo(lineItemsSize)>=0){
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }

    @Override
    public HashMap<Integer, Set<Integer>> assignLineItems(Set<LineItem> lineItems, List<Locker> lockers) {

        HashMap<Integer, Set<Integer>> lockerToLineItemsMap = new HashMap<>();
        Integer lineItemsSize = 0;
        Set<Integer> selectedLineItems = new HashSet<>();
        Integer selectedLockerId=-1;
        System.out.println("lockers input : "+lockers);
        for(LineItem li : lineItems){
            lineItemsSize+=li.getSize();
            int nextGreaterLocker = fetchNextGreaterLockerIndex(lockers, lineItemsSize);
            System.out.println(lineItemsSize+" for lockers returned : "+nextGreaterLocker);

            if(nextGreaterLocker!=-1){
                selectedLockerId = lockers.get(nextGreaterLocker).getId();
                selectedLineItems.add(li.getId());
                System.out.println(selectedLockerId+" can contain : "+selectedLineItems);
            }else{
                Set<Integer> assignedLineitems = selectedLineItems;
                lockerToLineItemsMap.put(selectedLockerId, assignedLineitems);
                lineItemsSize=li.getSize();

                nextGreaterLocker = fetchNextGreaterLockerIndex(lockers, lineItemsSize);
                if(nextGreaterLocker==-1){
                    return new HashMap<>();
                }
                selectedLockerId = lockers.get(nextGreaterLocker).getId();
                selectedLineItems = new HashSet<>();
                selectedLineItems.add(li.getId());
            }

//            System.out.println("lineitems : "+selectedLineItems+" can be assigned to : "+selectedLockerId);
        }

        if(!selectedLineItems.isEmpty()){
            lockerToLineItemsMap.put(selectedLockerId, selectedLineItems);
        }

        LockerRepository lockerRepository = LockerRepository.getInstance();
        lockerRepository.lockAllLockers(lockerToLineItemsMap.keySet());

        System.out.println("assignment map : "+lockerToLineItemsMap);
        return lockerToLineItemsMap;
    }

    private class LockerComparator implements Comparator<Locker> {

        @Override
        public int compare(Locker o1, Locker o2) {
            return o1.getSize()-o2.getSize();
        }
    }
}

