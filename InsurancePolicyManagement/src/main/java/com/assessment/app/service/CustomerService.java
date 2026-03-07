package com.assessment.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.assessment.app.dto.CustomerRequestDTO;
import com.assessment.app.dto.CustomerResponseDto;
import com.assessment.app.exception.CustomerNotFoundException;
import com.assessment.app.mapper.CustomerMapper;
import com.assessment.app.model.Customer;
import com.assessment.app.repository.CustomerRepository;

@Service
public class CustomerService {
	private CustomerRepository customerRepository;
	private CustomerMapper customerMapper;
	
	
	public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}
	
	public CustomerResponseDto createCustomer(CustomerRequestDTO dto) {
		Customer customer = customerMapper.toEntity(dto);
		return customerMapper.toDto(customerRepository.save(customer));
	}
	
	public List<CustomerResponseDto> getAllCustomer(){
		return customerRepository.findAll()
				.stream()
				.map(customerMapper::toDto)
				.collect(Collectors.toList());
	}
	
	public CustomerResponseDto getCustomerById(Long id) {
		Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: "+id));
		return customerMapper.toDto(customer);
	}
	
	public Customer getCustomerEntityById(Long id) {
		return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: "+ id));
	}
	
	public CustomerResponseDto updateCustomer(Long id, CustomerRequestDTO dto) {
	    Customer customer = customerRepository.findById(id)
	        .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));

	    // Update fields
	    customer.setName(dto.getName());
	    customer.setEmail(dto.getEmail());
	    customer.setPhoneNumber(dto.getPhoneNumber());
	    customer.setAddress(dto.getAddress());

	    return customerMapper.toDto(customerRepository.save(customer));
	}
}
