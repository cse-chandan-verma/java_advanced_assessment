package com.assessment.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.app.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
