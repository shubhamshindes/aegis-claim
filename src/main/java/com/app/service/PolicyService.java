package com.app.service;

import com.app.dto.PolicyDTO;
import com.app.entity.Policy;
import com.app.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    public PolicyDTO createPolicy(PolicyDTO policyDTO) {
        Policy policy = new Policy();
        policy.setPolicyNumber(policyDTO.getPolicyNumber());
        policy.setPolicyHolder(policyDTO.getPolicyHolder());
        policy.setEffectiveDate(policyDTO.getEffectiveDate());
        policy.setExpiryDate(policyDTO.getExpiryDate());
        policy.setCoverageDetails(policyDTO.getCoverageDetails());

        Policy savedPolicy = policyRepository.save(policy);
        policyDTO.setId(savedPolicy.getId());

        return policyDTO;
    }

    public PolicyDTO getPolicyById(Long id) {
        Optional<Policy> policyOpt = policyRepository.findById(id);
        if (policyOpt.isPresent()) {
            Policy policy = policyOpt.get();
            PolicyDTO policyDTO = new PolicyDTO();
            policyDTO.setId(policy.getId());
            policyDTO.setPolicyNumber(policy.getPolicyNumber());
            policyDTO.setPolicyHolder(policy.getPolicyHolder());
            policyDTO.setEffectiveDate(policy.getEffectiveDate());
            policyDTO.setExpiryDate(policy.getExpiryDate());
            policyDTO.setCoverageDetails(policy.getCoverageDetails());

            return policyDTO;
        } else {
            return null; // Handle this appropriately in the controller
        }
    }

    public List<PolicyDTO> getAllPolicies() {
        List<Policy> policies = policyRepository.findAll();
        return policies.stream().map(policy -> {
            PolicyDTO policyDTO = new PolicyDTO();
            policyDTO.setId(policy.getId());
            policyDTO.setPolicyNumber(policy.getPolicyNumber());
            policyDTO.setPolicyHolder(policy.getPolicyHolder());
            policyDTO.setEffectiveDate(policy.getEffectiveDate());
            policyDTO.setExpiryDate(policy.getExpiryDate());
            policyDTO.setCoverageDetails(policy.getCoverageDetails());
            return policyDTO;
        }).toList();
    }
}
