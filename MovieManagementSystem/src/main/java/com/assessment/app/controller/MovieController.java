package com.assessment.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.assessment.app.model.Movie;
import com.assessment.app.service.MovieService;


@Controller
public class MovieController {
	
	private MovieService movieService;
	
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping("/movies")
	public String getMovieDetails(Model model) {
		List<Movie> moviList = movieService.getAllMovies();
		model.addAttribute("movies", moviList);
		return "movies";
	}
	
	@GetMapping("/addMovies")
	public String addMovie(Model model) {
		model.addAttribute("movie", new Movie());
		model.addAttribute("formAction", "/addMovies");
		return "addMovies";
	}
	
	@GetMapping("/movies/edit/{id}")
	public String showUpdateForm(@PathVariable Long id, Model model) {
	    model.addAttribute("movie", movieService.getMovieById(id));
	    model.addAttribute("formAction", "/movies/edit/" + id);  
	    return "addMovies";  
	}
	
	@PostMapping("/movies/edit/{id}")
	public String updateMovie(@PathVariable Long id, Movie movie) {
		movieService.saveMovie(movie);
		return "redirect:/movies";
	}
	
	@PostMapping("/addMovies")
	public String saveMovie(Movie movie) {
		movieService.saveMovie(movie);
		return "redirect:/movies";
	}
	
	@GetMapping("/movies/{id}")
	public String deleteMovie(@PathVariable Long id) {
		movieService.deleteMovieById(id);
		return "redirect:/movies";
	}
}
