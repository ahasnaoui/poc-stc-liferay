package com.stc.poc.facade;

import javax.portlet.RenderRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stc.poc.service.IStcDeductionsService;

/**
 * Facade of the portlet.
 * @author ahasnaoui
 *
 */
@Component
public class StcPocFacade {
	
	

	/**
	 * 
	 * @param request
	 * @return
	 */
	public static int count(RenderRequest request) {
		return 0;
	}

}
