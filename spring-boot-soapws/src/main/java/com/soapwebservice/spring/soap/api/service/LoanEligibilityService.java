package com.soapwebservice.spring.soap.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.soapwebservice.spring.soap.api.loaneligibility.Acknowledgement;
import com.soapwebservice.spring.soap.api.loaneligibility.CustomerRequest;

@Service
public class LoanEligibilityService {
	
	public Acknowledgement checkLoanEligibility(CustomerRequest request) {
		Acknowledgement acknowledgement=new Acknowledgement();
		List<String> CritereaMismatch=acknowledgement.getCritereaMismatch();
		
		if(!(request.getAge()<20 || request.getAge()>80))
			CritereaMismatch.add("You are not within the Age norms for Loan");
		if(!(request.getYearlyIncome()<200000))
			CritereaMismatch.add("This income would not suffice your need for EMI of Loan");
		if(CritereaMismatch.size()>0) {
			acknowledgement.setApprovedAmount(0);
			acknowledgement.setIsEligible(false);
		}else {
			CritereaMismatch.clear();
			acknowledgement.setApprovedAmount(500000);
			acknowledgement.setIsEligible(true);
		}
		return acknowledgement;
	}
	
}
