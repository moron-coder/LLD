package com.LLD.AmazonLocker.Service;


import com.LLD.AmazonLocker.Dao.LockerRepository;
import com.LLD.AmazonLocker.Dao.OrderRepository;
import com.LLD.AmazonLocker.Entity.LineItem;
import com.LLD.AmazonLocker.Entity.Locker;
import com.LLD.AmazonLocker.Entity.LockerAddress;
import com.LLD.AmazonLocker.Entity.Order;
import com.LLD.AmazonLocker.Strategy.LockerAssignmentStrategy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookingService {
    private static BookingService instance;
    
    public static BookingService getInstance(){
        if(instance==null){
            instance = new BookingService();
        }
        return instance;
    }

    public boolean assignLocker(Integer orderId, LockerAssignmentStrategy strategy){
        OrderRepository orderRepository = OrderRepository.getInstance();
        Order order = orderRepository.findById(orderId);

        if(order==null){
            System.out.println("No order found by id : "+orderId);
            return false;
        }

        Set<LineItem> lineItems = new HashSet<>();
        order.getLineItems().stream().filter(li->li.getSize()!=null).forEach(lineItems::add);

        LockerRepository lockerRepository = LockerRepository.getInstance();
        List<Locker> lockers = lockerRepository.fetchAvailableLockers();

        HashMap<Integer, Set<Integer>> assignedLockerIds = strategy.assignLineItems(lineItems, lockers);
        if(assignedLockerIds.isEmpty()){
            System.out.println("Empty lockers assigned");
            return false;
        }
        LockerAddress lockerAddress = new LockerAddress(assignedLockerIds.keySet(), "");
        order.setDestinationDetails(lockerAddress);
        return true;
    }
}
