package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
    List<Claim> findByStatus(String status);
}
