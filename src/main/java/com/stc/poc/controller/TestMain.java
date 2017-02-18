package com.stc.poc.controller;

import java.util.List;

import com.stc.poc.model.beans.DeductionDTO;
import com.stc.poc.rest.exception.ServicesConnectException;
import com.stc.poc.service.impl.StcDeductionsServiceImpl;

public class TestMain {

	public static void main(String[] args) throws ServicesConnectException {
		
		StcDeductionsServiceImpl service = new StcDeductionsServiceImpl();
		String authId ="7F68A8D9-289D-4D0D-8DB7-B3AF582BC5D2";
		List<DeductionDTO> retal = service.getAllDeductions(authId);
		System.out.print(retal.size());
	}

}
