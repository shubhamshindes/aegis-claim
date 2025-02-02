package com.app.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String claimNumber;
    private Long policyId;
    private String status;
    private Date filedDate;
    private Date processedDate;
    private String description;
	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Claim(Long id, String claimNumber, Long policyId, String status, Date filedDate, Date processedDate,
			String description) {
		super();
		this.id = id;
		this.claimNumber = claimNumber;
		this.policyId = policyId;
		this.status = status;
		this.filedDate = filedDate;
		this.processedDate = processedDate;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}
	public Long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getFiledDate() {
		return filedDate;
	}
	public void setFiledDate(Date filedDate) {
		this.filedDate = filedDate;
	}
	public Date getProcessedDate() {
		return processedDate;
	}
	public void setProcessedDate(Date processedDate) {
		this.processedDate = processedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Claim [id=" + id + ", claimNumber=" + claimNumber + ", policyId=" + policyId + ", status=" + status
				+ ", filedDate=" + filedDate + ", processedDate=" + processedDate + ", description=" + description
				+ "]";
	}

    
}
