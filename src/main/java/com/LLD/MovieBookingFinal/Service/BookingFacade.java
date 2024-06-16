package com.LLD.MovieBookingFinal.Service;

import com.LLD.MovieBookingFinal.Entity.Booking;
import com.LLD.MovieBookingFinal.Entity.Schedule;
import com.LLD.MovieBookingFinal.Entity.Seat;
import com.LLD.MovieBookingFinal.Entity.User;
import com.LLD.MovieBookingFinal.Utils.Enum;

import java.util.Set;

public class BookingFacade {
    private static BookingFacade instance;
    private BookingFacade(){};
    public synchronized static BookingFacade getInstance(){
        if(instance==null){
            instance = new BookingFacade();
        }
        return instance;
    }

    public Set<Seat> fetchAvailableSeats(Schedule schedule){
        BookingService bookingService = BookingService.getInstance();
        return bookingService.fetchAvailableSeats(schedule);
    }

    public Booking createBooking(User user, Schedule schedule, Set<Seat> seats, Enum.PaymentMode paymentMode){
        PaymentService paymentService = PaymentService.getInstance();
        BookingService bookingService = BookingService.getInstance();

        Booking newBooking = null;

        if(bookingService.createTempBookingIfAllowed(schedule, seats)){
            Enum.PaymentStatus paymentStatus = paymentService.makePaymentDummy(paymentMode);
            if(Enum.PaymentStatus.SUCCESS.equals(paymentStatus)){
                System.out.println("Successfully created permanent bookings");
                newBooking = bookingService.createPermanentBooking(user, schedule, seats);
            }else{
                System.out.println("Could not create successful bookings. Unlocking blocked seats..");
                bookingService.unlockBookings(schedule, seats);
            }
        }else {
            System.out.println("Could not take temp lock on seats");
        }
        return newBooking;
    }

    public void cancelBookings(Schedule schedule, Set<Seat> seats){
        BookingService bookingService = BookingService.getInstance();
        bookingService.unlockBookings(schedule, seats);
    }
}
