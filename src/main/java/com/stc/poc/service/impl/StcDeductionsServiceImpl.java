package com.stc.poc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.stc.poc.model.beans.DeductionDTO;
import com.stc.poc.model.beans.DeductionList;
import com.stc.poc.model.beans.StcResponseBean;
import com.stc.poc.rest.RemoteServiceConfiguration;
import com.stc.poc.rest.RemoteServiceConfigurationFactory;
import com.stc.poc.rest.exception.ServicesConnectException;
import com.stc.poc.rest.ws.impl.DeductionServiceRestImpl;
import com.stc.poc.service.IStcDeductionsService;

/**
 * Service deduction
 * @author ahasnaoui
 *
 */
@Service("stcDeductionService")
public class StcDeductionsServiceImpl implements IStcDeductionsService {

	/**
	 * {@inheritDoc}
	 * @throws ServicesConnectException 
	 */
	@Override
	public List<DeductionDTO> getAllDeductions(String authId) throws ServicesConnectException {
		
		RemoteServiceConfiguration configuration = RemoteServiceConfigurationFactory.getInstance().getConfiguration();

		if (configuration != null) {
			
			DeductionList deductions =new DeductionServiceRestImpl(configuration).getAllDeductions(authId);
			return deductions.getDeductions();
			
		}
		return null;
		
	}

	/**
	 * Cancel deduction
	 */
	@Override
	public StcResponseBean cancelDeduction(String authId, String deductionId) throws ServicesConnectException {
		
		RemoteServiceConfiguration configuration = RemoteServiceConfigurationFactory.getInstance().getConfiguration();

		if (configuration != null) {
			
			StcResponseBean restResp =new DeductionServiceRestImpl(configuration).cancelDeduction(authId, deductionId);
			return restResp;
			
		}
		return null;
	}
	
	

	@Override
	public void submitDeductionService() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getDeductionDetailById() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getDeductionTypeDetails() {
		// TODO Auto-generated method stub
		
	}

}
