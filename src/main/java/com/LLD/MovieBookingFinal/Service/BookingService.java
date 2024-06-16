package com.LLD.MovieBookingFinal.Service;

import com.LLD.MovieBookingFinal.Entity.*;
import com.LLD.MovieBookingFinal.Utils.SeatLockProvider;

import java.util.HashSet;
import java.util.Set;

public class BookingService {
    HashSet<Booking> permanentBookings = new HashSet<>();
    private static BookingService instance;
    private BookingService(){};
    public synchronized static BookingService getInstance(){
        if(instance==null){
            instance = new BookingService();
        }
        return instance;
    }

    public Booking createPermanentBooking(User user, Schedule schedule, Set<Seat> seats){
        SeatLockProvider seatLockProvider = SeatLockProvider.getInstance();
        seatLockProvider.lockPermanentBookedSeats(schedule, seats);

        Booking newBooking = new Booking(user, seats, schedule);
        permanentBookings.add(newBooking);
        return newBooking;
    }

    public void unlockBookings(Schedule schedule, Set<Seat> seats){
        SeatLockProvider seatLockProvider = SeatLockProvider.getInstance();
        seatLockProvider.unlock(schedule, seats);
    }

    public boolean createTempBookingIfAllowed(Schedule schedule, Set<Seat> seats){
        SeatLockProvider seatLockProvider = SeatLockProvider.getInstance();
        if(seatLockProvider.takeLockIfAllowed(schedule, seats)){
            return true;
        }
        return false;
    }

    public Set<Seat> fetchAvailableSeats(Schedule schedule){
        Screen scr = schedule.getScreen();
        Set<Seat> allSeats = scr.getSeats();

        return SeatLockProvider.getInstance().excludeLockedSeats(schedule, allSeats);
    }
}
