package com.assessment.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.assessment.demo.model.Movie;
import com.assessment.demo.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

	private final MovieService movieService;

	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
		return movieService.getMovieById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
}