package com.stc.poc.rest.ws;

import com.stc.poc.model.beans.DeductionList;
import com.stc.poc.rest.exception.ServicesConnectException;

/**
 * 
 * @author ahasnaoui
 *
 */
public interface DeductionServiceRest {

	
	/**
	 * Get All deductions for the authId passed en parameters.
	 * @param aythId
	 */
	public DeductionList getAllDeductions(String authId) throws ServicesConnectException;
	
	/**
	 * Cancel deduction
	 */
	public void cancelDeduction();
	
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
