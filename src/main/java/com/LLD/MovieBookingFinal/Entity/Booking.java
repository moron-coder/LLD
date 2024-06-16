package com.LLD.MovieBookingFinal.Entity;

import com.LLD.MovieBookingFinal.Utils.Enum;

import java.util.Set;
import java.util.UUID;

public class Booking extends Entity{
    private User user;
    private Set<Seat> seats;
    private Schedule schedule;
    private Enum.BookingStatus bookingStatus;

    public Booking(User user, Set<Seat> seats, Schedule schedule) {
        super(UUID.randomUUID().toString());

        this.user = user;
        this.seats = seats;
        this.schedule = schedule;
    }

    @Override
    public final boolean equals(Object obj){
        Booking booking = (Booking) obj;
        return this.getId().equals(booking.getId());
    }

    @Override
    public int hashCode(){
        return this.getId().hashCode();
    }
}
