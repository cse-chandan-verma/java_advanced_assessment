package com.assessment.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.assessment.app.model.Movie;
import com.assessment.app.repository.MovieRepository;

@Service
public class MovieService {

	private MovieRepository movieRepository;

	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
	
	public Movie getMovieById(Long id) {
		return movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie Not found!!!"));
	}
	
	public void updateMovie(Long id, Movie updatedMovie) {
		Movie existingMovie = getMovieById(id);
		existingMovie.setTitle(updatedMovie.getTitle());
		existingMovie.setDirector(updatedMovie.getDirector());
		existingMovie.setGenre(updatedMovie.getGenre());
		existingMovie.setRating(updatedMovie.getRating());
		
		movieRepository.save(existingMovie);
	}
	
	public Movie saveMovie(Movie movie) {
	    return movieRepository.save(movie);
	}
	
	public void deleteMovieById(Long id) {
		getMovieById(id);
		movieRepository.deleteById(id);
	}
}
