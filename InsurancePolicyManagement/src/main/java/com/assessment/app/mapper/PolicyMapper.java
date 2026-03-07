package com.assessment.app.mapper;

import org.springframework.stereotype.Component;

import com.assessment.app.dto.PolicyRequestDto;
import com.assessment.app.dto.PolicyResponseDto;
import com.assessment.app.model.Customer;
import com.assessment.app.model.Policy;

@Component
public class PolicyMapper {
	private CustomerMapper customerMapper;

	public PolicyMapper(CustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
	}
	
	public Policy toEntity(PolicyRequestDto dto, Customer customer) {
		return new Policy(
				dto.getPolicyNumber(),
				dto.getPolicyType(),
				dto.getPremiumAmount(),
				dto.getCoverageAmount(),
				dto.getStartDate(),
				dto.getEndDate(),
				"ACTIVE",
				customer);
	}
	
	public PolicyResponseDto toDto(Policy policy) {
		return new PolicyResponseDto(policy.getId(), 
									policy.getPolicyNumber(), 
									policy.getPolicyType(), 
									policy.getPremiumAmount(), 
									policy.getCoverageAmount(), 
									policy.getStarDate(), 
									policy.getEndDate(), 
									policy.getStatus(), 
									customerMapper.toDto(policy.getCustomer()));
	}
}
