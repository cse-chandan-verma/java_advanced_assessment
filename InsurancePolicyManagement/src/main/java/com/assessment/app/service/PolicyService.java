package com.assessment.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.assessment.app.dto.PolicyRequestDto;
import com.assessment.app.dto.PolicyResponseDto;
import com.assessment.app.exception.PolicyNotFoundException;
import com.assessment.app.mapper.PolicyMapper;
import com.assessment.app.model.Customer;
import com.assessment.app.model.Policy;
import com.assessment.app.repository.PolicyRepository;

@Service
public class PolicyService {

	private PolicyRepository policyRepository;
	private PolicyMapper policyMapper;
	private CustomerService customerService;
	
	public PolicyService(PolicyRepository policyRepository, PolicyMapper policyMapper,
			CustomerService customerService) {
		this.policyRepository = policyRepository;
		this.policyMapper = policyMapper;
		this.customerService = customerService;
	}
	
	public PolicyResponseDto createPolicy(PolicyRequestDto dto) {
		Customer customer = customerService.getCustomerEntityById(dto.getCustomerId());
		Policy policy = policyMapper.toEntity(dto, customer);
		return policyMapper.toDto(policyRepository.save(policy));
	}
	
	public List<PolicyResponseDto> getAllPolicies(int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc")
            ? Sort.by(sortBy).descending()
            : Sort.by(sortBy).ascending();
        PageRequest pageable = PageRequest.of(page, size, sort);
        return policyRepository.findAll(pageable)
            .stream()
            .map(policyMapper::toDto)
            .collect(Collectors.toList());
    }

    public PolicyResponseDto getPolicyById(Long id) {
        Policy policy = policyRepository.findById(id)
            .orElseThrow(() -> new PolicyNotFoundException("Policy not found with id: " + id));
        return policyMapper.toDto(policy);
    }

    public PolicyResponseDto updatePolicy(Long id, PolicyRequestDto dto) {
        Policy policy = policyRepository.findById(id)
            .orElseThrow(() -> new PolicyNotFoundException("Policy not found with id: " + id));
        Customer customer = customerService.getCustomerEntityById(dto.getCustomerId());
        policy.setPolicyNumber(dto.getPolicyNumber());
        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setCoverageAmount(dto.getCoverageAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());
        policy.setCustomer(customer);
        return policyMapper.toDto(policyRepository.save(policy));
    }

    public void cancelPolicy(Long id) {
        Policy policy = policyRepository.findById(id)
            .orElseThrow(() -> new PolicyNotFoundException("Policy not found with id: " + id));
        policy.setStatus("CANCELLED");
        policyRepository.save(policy);
    }

    public List<PolicyResponseDto> getPoliciesByType(String policyType) {
        return policyRepository.findByPolicyType(policyType)
            .stream().map(policyMapper::toDto).collect(Collectors.toList());
    }

    public List<PolicyResponseDto> getPoliciesByPremiumRange(Double min, Double max) {
        return policyRepository.findByPremiumAmountBetween(min, max)
            .stream().map(policyMapper::toDto).collect(Collectors.toList());
    }

    public List<PolicyResponseDto> getPoliciesByCustomerEmail(String email) {
        return policyRepository.findByCustomerEmail(email)
            .stream().map(policyMapper::toDto).collect(Collectors.toList());
    }
}
