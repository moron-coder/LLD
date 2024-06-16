package com.LLD.MovieBookingFinal;


import com.LLD.MovieBookingFinal.Entity.*;
import com.LLD.MovieBookingFinal.Service.*;
import com.LLD.MovieBookingFinal.Utils.Enum;

import java.util.HashMap;
import java.util.Set;

public class MovieBookingFinalApp{
    public static void main(String[] args) {
        BaseSeedDataService.populateBaseCinemahallData();

        //  Display available schedules
        ScheduleService scheduleService = ScheduleService.getInstance();
        HashMap<Movie, Set<Schedule>> movieSchedules = scheduleService.fetchMovieSchedules();

        System.out.println("Movie schedules : "+movieSchedules);

        BookingFacade bookingFacade = BookingFacade.getInstance();

        //  register user
        UserService userService = UserService.getInstance();
        User registeredUser = userService.registerUser("Utkarsh","kutkarsh460@gmail.com");

        //  select schedule
        for(Movie movie : movieSchedules.keySet()){
            Set<Schedule> allSchedules = movieSchedules.get(movie);
            for(Schedule oneSchedule : allSchedules){
                System.out.println("Try to take booking on : "+oneSchedule);
                Set<Seat> availableSeats = bookingFacade.fetchAvailableSeats(oneSchedule);
                System.out.println("Available seats : "+availableSeats);
                if(availableSeats.isEmpty()){
                    continue;
                }
                //  book all seats
                System.out.println("Bookings started..");
                Enum.PaymentMode paymentMode = Enum.PaymentMode.UPI;
                Booking newBooking = bookingFacade.createBooking(registeredUser, oneSchedule, availableSeats, paymentMode);
                if(newBooking!=null){
                    System.out.println("Successfully created booking ");
                }
            }
        }

    }
}
