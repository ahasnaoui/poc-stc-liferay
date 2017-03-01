package com.stc.poc.rest.ws;

import com.stc.poc.model.beans.DeductionList;
import com.stc.poc.model.beans.StcResponseBean;
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
	public StcResponseBean cancelDeduction(String authId, String deductionId) throws ServicesConnectException;
	
	/**
	 * Submit a deduction
	 */
	public StcResponseBean submitDeductionService() throws ServicesConnectException;
	
	/**
	 * retrieve the deduction detail by Id
	 */
	public StcResponseBean getDeductionDetailById(String authId, String id) throws ServicesConnectException;
	
	/**
	 * Retrieve deduction type details
	 */
	public StcResponseBean getDeductionTypeDetails(String authId) throws ServicesConnectException;
	
	
	
	

}
