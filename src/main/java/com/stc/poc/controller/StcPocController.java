/*
 * This file is part of liferay-spring-mvc-portlet.
 *
 * liferay-spring-mvc-portlet is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * liferay-spring-mvc-portlet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * liferay-spring-mvc-portlet. If not, see <http://www.gnu.org/licenses/>.
 */
package com.stc.poc.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.stc.poc.facade.StcPocFacade;
import com.stc.poc.model.DeductionSearchContainer;
import com.stc.poc.model.beans.DeductionDTO;
import com.stc.poc.rest.exception.ServicesConnectException;

/**
 * Poc STC Controller.
 * @author ahasnaoui
 *
 */
@Controller
@RequestMapping("VIEW")
@Scope("request")
public class StcPocController  {

	/**
	 * Logger.
	 */
	Log _log = LogFactoryUtil.getLog(StcPocController.class);
	
	@Autowired
	StcPocFacade facade;
	/**
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RenderMapping
	public String render(RenderRequest request, RenderResponse response, ModelMap model) {
		
		String navigation = request.getParameter("navigation");
		String action = ParamUtil.get(request, "action", StringPool.BLANK);
		if(!action.isEmpty() && action.equals("cancelDeduction")) {
			cancelDeduction(request, response,model);
		}
		
		if(!action.isEmpty() && action.equalsIgnoreCase("EditDeduction")) {
			return editDeduction(request, response);
		}
		if(!action.isEmpty() && action.equalsIgnoreCase("submitDeduction")) {
			
			return "EditDeduction";
			
		}
		
		if (navigation == null || navigation.equals("")) {
			PortletURL portletURL = response.createRenderURL();
			DeductionSearchContainer searchContainer = new DeductionSearchContainer(request, portletURL);
			model.addAttribute("searchContainer", searchContainer);
			
			navigation = "view";
			
		}
		
		
		return "view";
		
	}
	
	@ModelAttribute("deductionDTO")
	public DeductionDTO getDeductionDTO() {
		return new DeductionDTO();
	}
	
	/**
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @param model 
	 */
	public void cancelDeduction(RenderRequest actionRequest, RenderResponse actionResponse, ModelMap model) {
		
		String deductionId = ParamUtil.get(actionRequest, "idDeduction", "");
		if(deductionId != null) {
			try {
				
				String message = facade.cancelDeduction(deductionId, actionRequest);
				if(SessionErrors.isEmpty(actionRequest)) {
					SessionMessages.add(actionRequest, "cancel-succes");
					model.addAttribute("message",message);
				} else {
					SessionErrors.add(actionRequest, "succes-cancel-deduction");
					model.addAttribute("message", message);
				}
				
			} catch (NumberFormatException e) {
				_log.error(e.getMessage(),e);
				SessionErrors.add(actionRequest, "poc-stc-error");
			} catch (ServicesConnectException e) {
				_log.error(e.getMessage(),e);
				SessionErrors.add(actionRequest, "poc-stc-error");
			} catch (PortalException e) {
				_log.error(e.getMessage(),e);
				SessionErrors.add(actionRequest, "poc-stc-error");
			} catch (SystemException e) {
				_log.error(e.getMessage(),e);
				SessionErrors.add(actionRequest, "poc-stc-error");
			} 
		}
	}
	
	@RenderMapping(params="action=editDeduction")
	public String editDeduction(RenderRequest actionRequest, RenderResponse actionResponse) {
		
		_log.info(">>>>>>>>> Edit Deduction");
		String deductionId = ParamUtil.get(actionRequest, "deductionId", "");
		if(deductionId != null) {
			try {
				
				//facade.editDeduction(deductionId, actionRequest);
				if(!SessionErrors.isEmpty(actionRequest)) {
					_log.info(">>>>>>>>> ErrorEdit Deduction");
				} else {
					SessionMessages.add(actionRequest, "succes-delete-deduction");
				}
				
			} catch (NumberFormatException e) {
				_log.error(e.getMessage(),e);
			} 
		}
		return "EditDeduction";
	}
	
	@ActionMapping(params="action=cancel")
	public void cancel(ActionRequest actionRequest, ActionResponse actionResponse) {
		_log.debug("cancel");
	}
	

}
