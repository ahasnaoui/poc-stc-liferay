package com.stc.poc.model;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.stc.poc.helpers.PocUtils;
import com.stc.poc.model.beans.DeductionDTO;
import com.stc.poc.service.IStcDeductionsService;
import com.stc.poc.service.impl.StcDeductionsServiceImpl;

/**
 * Deductions Search container;
 * @author ahasnaoui
 *
 */
@Component
public class DeductionSearchContainer extends SearchContainer<DeductionDTO> {
	
	private static Log _log = LogFactoryUtil.getLog(DeductionSearchContainer.class);
	
	private final static int DELTA = SearchContainer.DEFAULT_DELTA;
	
	/**
	 * Deduction Service.
	 */
	@Autowired
	private IStcDeductionsService stcDeductionService;
	
	public DeductionSearchContainer() {
		super();
	}
	
	public DeductionSearchContainer(RenderRequest request, PortletURL portletURL) {
		
		super(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, DELTA, portletURL, null, "no-deductions-were-found");
		
		//Headers
		List<String> headerNames = new ArrayList<String>();
		headerNames.add("title");
		headerNames.add("url");
		headerNames.add("position");
		this.setHeaderNames(headerNames);
		
		int total = 0;
		List<DeductionDTO> results = new ArrayList<DeductionDTO>();
		
		try {
			String authId = PocUtils.getUserAuthId(request);
			stcDeductionService = new StcDeductionsServiceImpl();
			results = stcDeductionService.getAllDeductions(authId);
			total = results.size();
		} catch (Exception e) {
			_log.error(e,e);
		}
		
		this.setResults(results);
		this.setTotal(total);
		
	}

}
