package com.app.service;

import com.app.dto.PolicyDTO;
import com.app.entity.Policy;
import com.app.repository.PolicyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private ModelMapper modelMapper;  // Inject ModelMapper

    public PolicyDTO createPolicy(PolicyDTO policyDTO) {
        // Convert DTO to Entity
        Policy policy = modelMapper.map(policyDTO, Policy.class);

        // Save to DB
        Policy savedPolicy = policyRepository.save(policy);

        // Convert Entity back to DTO
        return modelMapper.map(savedPolicy, PolicyDTO.class);
    }

    public PolicyDTO getPolicyById(Long id) {
        return policyRepository.findById(id)
                .map(policy -> modelMapper.map(policy, PolicyDTO.class))
                .orElse(null); // Handle this appropriately in the controller
    }

    public List<PolicyDTO> getAllPolicies() {
        List<Policy> policies = policyRepository.findAll();
        return policies.stream()
                .map(policy -> modelMapper.map(policy, PolicyDTO.class))
                .toList();
    }
}
