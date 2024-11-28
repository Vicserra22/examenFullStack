package com.cinexpress.videofriend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.repository.MovieRepository;
import com.cinexpress.videofriend.services.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;  

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);  
    }

    @Override
    public Movie updateMovie(Long id, Movie movie) {
        Optional<Movie> existingMovie = movieRepository.findById(id);
        if (existingMovie.isPresent()) {
            Movie updatedMovie = existingMovie.get();
            updatedMovie.setTitle(movie.getTitle());
            updatedMovie.setFormat(movie.getFormat());
            updatedMovie.setGenre(movie.getGenre());
            updatedMovie.setLanguage(movie.getLanguage());
            updatedMovie.setAvailability(movie.getAvailability());
            updatedMovie.setCompany(movie.getCompany());
            updatedMovie.setCustomer(movie.getCustomer());
            return movieRepository.save(updatedMovie);  
        }
        throw new RuntimeException("Movie not found with id: " + id);  
    }

    @Override
    public void updateAvailability(Long id, Boolean availability) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            movie.get().setAvailability(availability);  
            movieRepository.save(movie.get());
        } else {
            throw new RuntimeException("Movie not found with id: " + id);  
        }
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();  
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));  
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);  
    }
}
