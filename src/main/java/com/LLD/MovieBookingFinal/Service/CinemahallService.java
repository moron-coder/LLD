package com.LLD.MovieBookingFinal.Service;

import com.LLD.MovieBookingFinal.Entity.CinemaHall;
import com.LLD.MovieBookingFinal.Entity.Screen;
import com.LLD.MovieBookingFinal.Entity.Seat;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

public class CinemahallService {
    private final static HashMap<String, Seat> seats = new HashMap<>();
    private final static HashMap<String, Screen> screens = new HashMap<>();
    private final static HashMap<String, CinemaHall> cinemahalls = new HashMap<>();

    public static void populateData(CinemaHall hall){
        Set<Screen> hallScreens = hall.getScreens();

        for(Screen hallScreen : hallScreens){
            Set<Seat> screenSeats = hallScreen.getSeats();
            for(Seat screenSeat : screenSeats){
                seats.put(screenSeat.getId(), screenSeat);
            }
            hallScreen.setSeats(screenSeats);
            screens.put(hallScreen.getId(), hallScreen);
        }

        cinemahalls.put(hall.getId(), hall);
    }
}
