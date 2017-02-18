package com.stc.poc.rest;


/**
 * 
 * @author ahasnaoui
 *
 */
public class DefaultRemoteServiceConfiguration extends RemoteServiceConfiguration {
	
	public DefaultRemoteServiceConfiguration() {
		this.setHost("127.0.0.1");
		this.setPort(9090);
		this.setProtocol("http");
		this.setRemoteHostEnabled(true);//PropsValues.AUCHAN_EXTERNAL_SERVICES_COMMUNICATION_ENABLED);
	}

}
