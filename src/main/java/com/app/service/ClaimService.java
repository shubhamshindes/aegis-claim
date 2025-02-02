package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

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

    public ClaimDTO createClaim(ClaimDTO claimDTO) {
        // Map ClaimDTO to Entity and save it to the DB
        Claim claim = new Claim();
        claim.setClaimNumber(claimDTO.getClaimNumber());
        claim.setDescription(claimDTO.getDescription());
        claim.setFiledDate(claimDTO.getFiledDate());
        claim.setPolicyId(claimDTO.getPolicyId());
        claim.setProcessedDate(claimDTO.getProcessedDate());
        claim.setStatus(claimDTO.getStatus());

        // Save the claim entity to the database
        Claim savedClaim = claimRepository.save(claim);

        // Set the generated id in the ClaimDTO before returning it
        claimDTO.setId(savedClaim.getId());

        return claimDTO;  // Return the DTO with the id after creation
    }


    public ClaimDTO getClaimById(Long id) {
        Claim claim = claimRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Claim not found"));
        ClaimDTO claimDTO = new ClaimDTO();
        claimDTO.setId(claim.getId());
        claimDTO.setClaimNumber(claim.getClaimNumber());
        claimDTO.setDescription(claim.getDescription());
        claimDTO.setFiledDate(claim.getFiledDate());
        claimDTO.setProcessedDate(claim.getProcessedDate());
        claimDTO.setStatus(claim.getStatus());
        claimDTO.setPolicyId(claim.getPolicyId());
        return claimDTO;
    }

    public List<ClaimDTO> getClaimsByStatus(String status) {
        List<Claim> claims = claimRepository.findByStatus(status);
        return claims.stream().map(claim -> {
            ClaimDTO claimDTO = new ClaimDTO();
            claimDTO.setId(claim.getId());
            claimDTO.setClaimNumber(claim.getClaimNumber());
            claimDTO.setDescription(claim.getDescription());
            claimDTO.setFiledDate(claim.getFiledDate());
            claimDTO.setProcessedDate(claim.getProcessedDate());
            claimDTO.setStatus(claim.getStatus());
            claimDTO.setPolicyId(claim.getPolicyId());
            return claimDTO;
        }).collect(Collectors.toList());
    }
}

