package com.LLD.MovieBookingFinal.Entity;

import java.util.Date;
import java.util.UUID;

public class Schedule extends Entity{
    Movie movie;
    Date startTime;          //  1100, 1300 like this
    Date endTime;
    Screen screen;
    CinemaHall hall;

    public Schedule(Movie movie, Date startTime, Date endTime, Screen screen, CinemaHall hall) {
        super(UUID.randomUUID().toString());

        this.movie = movie;
        this.startTime = startTime;
        this.endTime = endTime;
        this.screen = screen;
        this.hall = hall;
    }

    public Screen getScreen() {
        return screen;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Movie getMovie() {
        return movie;
    }

    @Override
    public String toString(){
        return " start_time : "+startTime+
                " end_time : "+endTime+
                " screen : "+screen+
                " hall : "+hall;
    }
}
