package com.assessment.app.repository;

// ❌ REMOVE this if present:
// import java.awt.print.Pageable;

// ✅ ADD this correct import:
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assessment.app.model.Policy;

import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {

    List<Policy> findByPolicyType(String policyType);
    List<Policy> findByCustomerId(Long customerId);
    List<Policy> findByPremiumAmountBetween(Double min, Double max);

    Page<Policy> findAll(Pageable pageable); // ✅ Now uses correct Pageable

    @Query("SELECT p FROM Policy p WHERE p.customer.email = :email")
    List<Policy> findByCustomerEmail(@Param("email") String email);
}