package com.cinexpress.videofriend.services;

import java.util.List;

import com.cinexpress.videofriend.models.Movie;

public interface MovieService {
    Movie addMovie(Movie movie);  
    Movie updateMovie(Long id, Movie movie);  
    void updateAvailability(Long id, Boolean availability);  
    List<Movie> getAllMovies();  
    Movie getMovieById(Long id);  
    void deleteMovie(Long id); 
}
