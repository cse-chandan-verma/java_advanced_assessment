package com.assessment.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.app.dto.CustomerRequestDTO;
import com.assessment.app.dto.CustomerResponseDto;
import com.assessment.app.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService;
    

    public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping
    public ResponseEntity<CustomerResponseDto> create(@Valid @RequestBody CustomerRequestDTO dto) {
        return new ResponseEntity<>(customerService.createCustomer(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getAll() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> update(	
            @PathVariable Long id,
            @Valid @RequestBody CustomerRequestDTO dto) {
        return ResponseEntity.ok(customerService.updateCustomer(id, dto));
    }
}