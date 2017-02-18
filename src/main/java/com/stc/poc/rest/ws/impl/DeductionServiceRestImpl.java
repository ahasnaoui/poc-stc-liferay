package com.stc.poc.rest.ws.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.stc.poc.model.beans.DeductionList;
import com.stc.poc.rest.RemoteServiceConfiguration;
import com.stc.poc.rest.ServiceClient;
import com.stc.poc.rest.exception.ServicesConnectException;
import com.stc.poc.rest.ws.DeductionServiceRest;

/**
 * Implementation of deduction service rest client.
 * @author ahasnaoui
 *
 */

public class DeductionServiceRestImpl extends ServiceClient implements DeductionServiceRest {

	/**
	 * 
	 * @param configuration
	 */
	public DeductionServiceRestImpl(RemoteServiceConfiguration configuration) {
		super(configuration);
	}
	
	/**
	 * {@inheritDoc}
	 * @throws ServicesConnectException 
	 */
	@Override
	public DeductionList getAllDeductions(String authId) throws ServicesConnectException {
		
		JsonObject jsonRet = super.getForObject(super.getUrl("/getalldeductions?authguid="+authId), JsonObject.class);
		DeductionList deductionsResp = new Gson().fromJson(jsonRet, DeductionList.class);
		return deductionsResp;
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void cancelDeduction() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void submitDeductionService() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void getDeductionDetailById() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void getDeductionTypeDetails() {
		// TODO Auto-generated method stub
		
	}

}
