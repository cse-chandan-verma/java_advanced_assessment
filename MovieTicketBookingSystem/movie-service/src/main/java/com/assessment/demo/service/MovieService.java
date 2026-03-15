package com.assessment.demo.service;

import org.springframework.stereotype.Service;

import com.assessment.demo.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

	private final List<Movie> movies = new ArrayList<>();

	public MovieService() {
		movies.add(new Movie(1, "Inception", "English", 250));
		movies.add(new Movie(2, "RRR", "Telugu", 200));
		movies.add(new Movie(3, "3 Idiots", "Hindi", 150));
	}

	public List<Movie> getAllMovies() {
		return movies;
	}

	public Optional<Movie> getMovieById(int id) {
		return movies.stream().filter(m -> m.getId() == id).findFirst();
	}
}
