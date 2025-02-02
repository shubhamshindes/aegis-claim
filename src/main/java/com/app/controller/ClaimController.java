package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ClaimDTO;
import com.app.service.ClaimService;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

	@Autowired
	private ClaimService claimService;

	@PostMapping
	public ResponseEntity<ClaimDTO> createClaim(@RequestBody ClaimDTO claimDTO) {
		ClaimDTO createdClaim = claimService.createClaim(claimDTO);
		return new ResponseEntity<>(createdClaim, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClaimDTO> getClaimById(@PathVariable Long id) {
		ClaimDTO claimDTO = claimService.getClaimById(id);
		return new ResponseEntity<>(claimDTO, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<ClaimDTO>> getClaimsByStatus(@RequestParam String status) {
		List<ClaimDTO> claimDTOs = claimService.getClaimsByStatus(status);
		return new ResponseEntity<>(claimDTOs, HttpStatus.OK);
	}
}
