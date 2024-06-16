package com.LLD.MovieBookingFinal.Service;

import com.LLD.MovieBookingFinal.Entity.Movie;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class MovieService {
    static HashMap<String, Movie> movies = new HashMap<>();

    public static void populateMovies(List<Movie> toPopulate){
        for(Movie movie : toPopulate){
            movies.put(movie.getId(), movie);
        }
    }
}
