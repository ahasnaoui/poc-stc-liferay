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

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.stc.poc.model.DeductionSearchContainer;

/**
 * Poc STC Controller.
 * @author ahasnaoui
 *
 */
@Controller
@RequestMapping("VIEW")
public class StcPocController extends BaseController {

	/**
	 * Logger.
	 */
	Logger log = LoggerFactory.getLogger(StcPocController.class);
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RenderMapping
	public String setModelAndView(RenderRequest request, RenderResponse response, ModelMap model) {
		
		log.debug("action=default");
		String navigation = request.getParameter("navigation");
		
		if (navigation == null || navigation.equals("")) {
			PortletURL portletURL = response.createRenderURL();
			DeductionSearchContainer searchContainer = new DeductionSearchContainer(request, portletURL);
			model.addAttribute("searchContainer", searchContainer);	
			navigation = "view";
			
		}
		
		
		return navigation;
		
	}
	
	

}
