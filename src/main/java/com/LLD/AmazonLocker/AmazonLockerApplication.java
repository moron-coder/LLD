package com.LLD.AmazonLocker;

import com.LLD.AmazonLocker.Dao.LineItemRepository;
import com.LLD.AmazonLocker.Dao.LockerRepository;
import com.LLD.AmazonLocker.Dao.OrderRepository;
import com.LLD.AmazonLocker.Entity.*;
import com.LLD.AmazonLocker.Service.BookingService;
import com.LLD.AmazonLocker.Strategy.CompactAssignmentStrategy;
import com.LLD.AmazonLocker.Strategy.LockerAssignmentStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class AmazonLockerApplication {
    public static void main(String[] args) {
        LockerRepository lockerRepository = LockerRepository.getInstance();

        Locker l1 = new Locker(4);
        lockerRepository.save(l1);
        Locker l2 = new Locker(5);
        lockerRepository.save(l2);
        Locker l3 = new Locker(8);
        lockerRepository.save(l3);

        LineItemRepository lineItemRepository = LineItemRepository.getInstance();

        LineItem li1 = new LineItem(null,3);
        lineItemRepository.save(li1);
        LineItem li2 = new LineItem(null,4);
        lineItemRepository.save(li2);
        LineItem li3 = new LineItem(null,4);
        lineItemRepository.save(li3);

        User u1 = new User("8734568347");
        DeliveryPerson d1 = new DeliveryPerson("354345344");
        DestinationDetails details = new UserAddress("101", "Avani Classic", "Kasavanahalli",
                "560035","Bangalore");

        Order order = new Order(null,u1, d1, Arrays.asList(li1,li2,li3), details);
        OrderRepository orderRepository = OrderRepository.getInstance();
         orderRepository.save(order);

        BookingService bookingService = BookingService.getInstance();

        LockerAssignmentStrategy strategy = new CompactAssignmentStrategy();
        bookingService.assignLocker(order.getId(), strategy);

        System.out.println("Address : "+order.getDestinationDetails().getFullAddress());
    }
}
