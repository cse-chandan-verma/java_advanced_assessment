package com.assessment.app.mapper;

import org.springframework.stereotype.Component;

import com.assessment.app.dto.CustomerRequestDTO;
import com.assessment.app.dto.CustomerResponseDto;
import com.assessment.app.model.Customer;

@Component
public class CustomerMapper {
	public Customer toEntity(CustomerRequestDTO dto) {
		return new Customer(dto.getName(), dto.getEmail(), dto.getPhoneNumber(), dto.getAddress());
	}
	
	public CustomerResponseDto toDto(Customer customer) {
		return new CustomerResponseDto(customer.getId(), customer.getName(), customer.getEmail(), customer.getPhoneNumber(), customer.getAddress());
	}
}
