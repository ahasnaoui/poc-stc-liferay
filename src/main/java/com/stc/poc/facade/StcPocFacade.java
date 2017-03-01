package com.stc.poc.facade;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.stc.poc.helpers.PocUtils;
import com.stc.poc.model.beans.StcResponseBean;
import com.stc.poc.rest.exception.ServicesConnectException;
import com.stc.poc.service.IStcDeductionsService;

/**
 * Facade of the portlet.
 * @author ahasnaoui
 *
 */
@Component
public class StcPocFacade {
	
	
	@Autowired
	public IStcDeductionsService deductionService;

	/**
	 * 
	 * @param request
	 * @return
	 */
	public static int count(RenderRequest request) {
		return 0;
	}

	/**
	 * Cancel deduction.
	 * @param deductionId
	 * @param actionRequest
	 * @return 
	 * @throws ServicesConnectException
	 * @throws PortalException
	 * @throws SystemException
	 */
	public String cancelDeduction(String deductionId,
			PortletRequest actionRequest) throws ServicesConnectException, PortalException, SystemException {
		
		String authId = PocUtils.getUserAuthId(actionRequest);
		StcResponseBean retVal = deductionService.cancelDeduction(authId, deductionId);
		if(!retVal.getStatusCode().equals("0")) {
			SessionErrors.add(actionRequest, "error-cancel-deduction",retVal.getStatusMessage());
		}
		return retVal.getStatusMessage();
	}

	/**
	 * Edit deduction.
	 * @param deductionId
	 * @param actionRequest
	 * @throws ServicesConnectException
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void editDeduction(String deductionId, ActionRequest actionRequest) throws ServicesConnectException, PortalException, SystemException {
		
		String authId = PocUtils.getUserAuthId(actionRequest);
		deductionService.cancelDeduction(authId, deductionId);
		
	}

	

}
