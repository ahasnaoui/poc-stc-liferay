package com.stc.poc.model.beans;

import java.util.List;

/**
 * 
 * @author ahasnaoui
 *
 */
public class DeductionList extends StcResponseBean  {

	private List<DeductionDTO> deductions;

	/**
	 * @return the deductions
	 */
	public List<DeductionDTO> getDeductions() {
		return deductions;
	}

	/**
	 * @param deductions the deductions to set
	 */
	public void setDeductions(List<DeductionDTO> deductions) {
		this.deductions = deductions;
	}
	
	
	
	

}
