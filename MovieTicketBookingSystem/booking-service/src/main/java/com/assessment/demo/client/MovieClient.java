package com.assessment.demo.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.assessment.demo.booking.model.Movie;

@FeignClient(name = "movie-service")
public interface MovieClient {

    @GetMapping("/movies/{id}")
    @CircuitBreaker(name = "movieServiceCB", fallbackMethod = "getMovieFallback")
    Movie getMovieById(@PathVariable("id") int id);

    default Movie getMovieFallback(int id, Throwable throwable) {
        return null;
    }
}