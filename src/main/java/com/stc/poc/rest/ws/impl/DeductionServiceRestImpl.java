package com.stc.poc.rest.ws.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.stc.poc.model.beans.DeductionList;
import com.stc.poc.model.beans.StcResponseBean;
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
	public StcResponseBean cancelDeduction(String authId, String deductionId) throws ServicesConnectException {
		
		JsonObject jsonRet = super.getForObject(super.getUrl("/canceldeduction?authguid="+authId+"&deductionId="+deductionId), JsonObject.class);
		StcResponseBean retVal = new Gson().fromJson(jsonRet, StcResponseBean.class);
		return retVal;
	}

	@Override
	public StcResponseBean submitDeductionService()
			throws ServicesConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StcResponseBean getDeductionDetailById(String authId, String id)
			throws ServicesConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StcResponseBean getDeductionTypeDetails(String authId)
			throws ServicesConnectException {
		// TODO Auto-generated method stub
		return null;
	}
	


}
