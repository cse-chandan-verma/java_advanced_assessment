package com.assessment.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.app.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
