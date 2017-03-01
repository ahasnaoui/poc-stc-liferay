package com.stc.poc.service;

import java.util.List;

import com.stc.poc.model.beans.DeductionDTO;
import com.stc.poc.model.beans.DeductionList;
import com.stc.poc.model.beans.StcResponseBean;
import com.stc.poc.rest.exception.ServicesConnectException;

/**
 * 
 * @author ahasnaoui
 *
 */
public interface IStcDeductionsService {
	
	
	/**
	 * Get All deductions for the authId passed en parameters.
	 * @param aythId
	 */
	public List<DeductionDTO> getAllDeductions(String authId) throws ServicesConnectException;
	
	/**
	 * Cancel deduction
	 */
	public StcResponseBean cancelDeduction(String authId, String deductionId) throws ServicesConnectException;
	
	/**
	 * Submit a deduction
	 */
	public void submitDeductionService();
	
	/**
	 * retrieve the deduction detail by Id
	 */
	public void getDeductionDetailById();
	
	/**
	 * Retrieve deduction type details
	 */
	public void getDeductionTypeDetails();

}
