package com.LLD.MovieBookingFinal.Service;

import com.LLD.MovieBookingApp2.Repository.ScheduleRepository;
import com.LLD.MovieBookingFinal.Entity.*;

import java.lang.reflect.Array;
import java.util.*;

public class BaseSeedDataService {
    private static void fillCalendarHH_MM(Calendar c, Integer hr, Integer mins){
        c.set(Calendar.HOUR_OF_DAY, hr);
        c.set(Calendar.MINUTE, mins);

        c.set(Calendar.SECOND,0);
        c.set(Calendar.MILLISECOND,0);
    }

    public static void populateBaseCinemahallData(){
        //  cinemahall creation
        Set<Seat> seatsScr1 = new HashSet<>(), seatsScr2= new HashSet<>();
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                Seat s = new Seat(i,j);
                seatsScr1.add(s);
                seatsScr2.add(s);
            }
        }

        Set<Screen> screens = new HashSet<>();
        Screen scr1 = new Screen("Screen 1", seatsScr1);
        Screen scr2 = new Screen("Screen 2", seatsScr2);
        screens.add(scr1);
        screens.add(scr2);

        CinemaHall cinemaHall = new CinemaHall("Cinemahall_1", screens);
        CinemahallService.populateData(cinemaHall);

        //  movie creation
        Movie movie1 = new Movie("Golmal",120);
        Movie movie2 = new Movie("Bahubali",180);
        MovieService.populateMovies(Arrays.asList(movie1, movie2));

        //  start and end time
        Calendar c = Calendar.getInstance();
        fillCalendarHH_MM(c,10,30);
        Date startTime = c.getTime();
        c.add(Calendar.MINUTE, movie1.getDurationInMinutes());
        Date endTime = c.getTime();

        //  schedule creation
        Schedule schedule1 = new Schedule(movie1, startTime, endTime, scr1, cinemaHall);
        fillCalendarHH_MM(c,17,00);
        startTime = c.getTime();
        c.add(Calendar.MINUTE, movie2.getDurationInMinutes());
        endTime = c.getTime();

        Schedule schedule2 = new Schedule(movie2, startTime, endTime, scr2, cinemaHall);
        ScheduleService.populateSchedules(Arrays.asList(schedule1, schedule2));

    }
}
