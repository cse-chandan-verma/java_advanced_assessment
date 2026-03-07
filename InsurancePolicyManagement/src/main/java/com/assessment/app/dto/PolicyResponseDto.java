package com.assessment.app.dto;

import java.time.LocalDate;

public class PolicyResponseDto {
	private Long id;
    private String policyNumber;
    private String policyType;
    private Double premiumAmount;
    private Double coverageAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private CustomerResponseDto customer;
    
	public PolicyResponseDto(Long id, String policyNumber, String policyType, Double premiumAmount,
			Double coverageAmount, LocalDate startDate, LocalDate endDate, String status,
			CustomerResponseDto customer) {
		super();
		this.id = id;
		this.policyNumber = policyNumber;
		this.policyType = policyType;
		this.premiumAmount = premiumAmount;
		this.coverageAmount = coverageAmount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public Double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(Double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public Double getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(Double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CustomerResponseDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerResponseDto customer) {
		this.customer = customer;
	}
    
}
