package com.stc.poc.model.beans;

import java.util.List;

/**
 * 
 * @author ahasnaoui
 *
 */
public class DeductionList  {

	private String statusCode;
	private String statusMessage;
	private List<DeductionDTO> deductions;
	private String authGuid;
	private String authguid;
	private String $resourceID;
	/**
	 * @return the statusMessage
	 */
	public String getStatusMessage() {
		return statusMessage;
	}
	/**
	 * @param statusMessage the statusMessage to set
	 */
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
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
	/**
	 * @return the authGuid
	 */
	public String getAuthGuid() {
		return authGuid;
	}
	/**
	 * @param authGuid the authGuid to set
	 */
	public void setAuthGuid(String authGuid) {
		this.authGuid = authGuid;
	}
	/**
	 * @return the authguid
	 */
	public String getAuthguid() {
		return authguid;
	}
	/**
	 * @param authguid the authguid to set
	 */
	public void setAuthguid(String authguid) {
		this.authguid = authguid;
	}
	/**
	 * @return the $resourceID
	 */
	public String get$resourceID() {
		return $resourceID;
	}
	/**
	 * @param $resourceID the $resourceID to set
	 */
	public void set$resourceID(String $resourceID) {
		this.$resourceID = $resourceID;
	}
	
	

}
