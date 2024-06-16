package com.LLD.MovieBookingFinal.Service;

import com.LLD.MovieBookingFinal.Entity.Movie;
import com.LLD.MovieBookingFinal.Entity.Schedule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ScheduleService {
    private static ScheduleService instance;
    private ScheduleService(){};
    public synchronized static ScheduleService getInstance(){
        if(instance==null){
            instance = new ScheduleService();
        }
        return instance;
    }

    private static HashMap<String, Schedule> schedules = new HashMap<>();

    public HashMap<Movie, Set<Schedule>> fetchMovieSchedules(){
        HashMap<Movie, Set<Schedule>> res = new HashMap<>();
        for(Schedule schedule : schedules.values()){
            Movie movie = schedule.getMovie();
            if(res.containsKey(movie)){
                res.get(movie).add(schedule);
            }else{
                Set<Schedule> movieSchedules = new HashSet<>();
                movieSchedules.add(schedule);
                res.put(movie, movieSchedules);
            }
        }
        return res;
    }

    //todo: check for overlapping schedules being added on the same screen
    public static void populateSchedules(List<Schedule> toPopulate){
        for(Schedule schedule : toPopulate){
            schedules.put(schedule.getId(), schedule);
        }
    }
}
