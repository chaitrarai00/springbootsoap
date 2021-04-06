package com.soapwebservice.spring.soap.api.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soapwebservice.spring.soap.api.loaneligibility.Acknowledgement;
import com.soapwebservice.spring.soap.api.loaneligibility.CustomerRequest;
import com.soapwebservice.spring.soap.api.service.LoanEligibilityService;

@Endpoint
public class LoanEligibilityEndpoint {
	/*
	 * add url specified in xsd to be exposed as server endpoint
	 */
	private static final String NAMESPACE="http://www.soapwebservice.com/spring/soap/api/loanEligibility";
	
	/*
	 * call the service / inject the service
	 */
	@Autowired
	private  LoanEligibilityService eligibilityService;
	/*
	 * get request -->call service passing the request and generate the response
	 * localpart of payloadroot would be the xmlrootelement of request  
	 */
	@PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoganStatus(@RequestPayload CustomerRequest customerRequest) {
		return eligibilityService.checkLoanEligibility(customerRequest);
	}
	
}
