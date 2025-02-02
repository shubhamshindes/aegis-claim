package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ClaimDTO;
import com.app.entity.Claim;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.ClaimRepository;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private ModelMapper modelMapper;  // Inject ModelMapper

    public ClaimDTO createClaim(ClaimDTO claimDTO) {
        // Convert DTO to Entity
        Claim claim = modelMapper.map(claimDTO, Claim.class);

        // Save to DB
        Claim savedClaim = claimRepository.save(claim);

        // Convert Entity back to DTO
        return modelMapper.map(savedClaim, ClaimDTO.class);
    }

    public ClaimDTO getClaimById(Long id) {
        Claim claim = claimRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found"));

        return modelMapper.map(claim, ClaimDTO.class);
    }

    public List<ClaimDTO> getClaimsByStatus(String status) {
        List<Claim> claims = claimRepository.findByStatus(status);

        return claims.stream()
                .map(claim -> modelMapper.map(claim, ClaimDTO.class))
                .collect(Collectors.toList());
    }
}
