package com.assessment.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.app.dto.PolicyRequestDto;
import com.assessment.app.dto.PolicyResponseDto;
import com.assessment.app.service.PolicyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    private PolicyService policyService; 
    

    public PolicyController(PolicyService policyService) {
		super();
		this.policyService = policyService;
	}

	@PostMapping
    public ResponseEntity<PolicyResponseDto> create(@Valid @RequestBody PolicyRequestDto dto) {
        return new ResponseEntity<>(policyService.createPolicy(dto), HttpStatus.CREATED);
    }

    @GetMapping
    
    public ResponseEntity<List<PolicyResponseDto>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        return ResponseEntity.ok(policyService.getAllPolicies(page, size, sortBy, direction));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolicyResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(policyService.getPolicyById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PolicyResponseDto> update(
            @PathVariable Long id, @Valid @RequestBody PolicyRequestDto dto) {
        return ResponseEntity.ok(policyService.updatePolicy(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancel(@PathVariable Long id) {
        policyService.cancelPolicy(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<PolicyResponseDto>> getByType(@PathVariable String type) {
        return ResponseEntity.ok(policyService.getPoliciesByType(type));
    }

    @GetMapping("/premium")
    public ResponseEntity<List<PolicyResponseDto>> getByPremiumRange(
            @RequestParam Double min,
            @RequestParam Double max) {
        return ResponseEntity.ok(policyService.getPoliciesByPremiumRange(min, max));
    }

    @GetMapping("/by-email")
    public ResponseEntity<List<PolicyResponseDto>> getByCustomerEmail(@RequestParam String email) {
        return ResponseEntity.ok(policyService.getPoliciesByCustomerEmail(email));
    }
}