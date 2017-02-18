package com.stc.poc.rest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.stc.poc.rest.exception.ExceptionTechnique;

/**
 * 
 * @author ahasnaoui
 *
 */
public class RemoteServiceConfigurationFactory {
	
	private static Log _log = LogFactoryUtil.getLog(RemoteServiceConfigurationFactory.class);
	
	private RemoteServiceConfiguration configuration;

	private RemoteServiceConfigurationFactory() {
		
		setConfiguration();
		
	}

	private static RemoteServiceConfigurationFactory INSTANCE = null;

	public static RemoteServiceConfigurationFactory getInstance() {
		
		if (INSTANCE == null) {
			synchronized (RemoteServiceConfigurationFactory.class) {
				if (INSTANCE == null) {
					INSTANCE = new RemoteServiceConfigurationFactory();
				}
			}
		}
		return INSTANCE;
		
	}
	
	public RemoteServiceConfiguration getConfiguration() {
		return configuration;
	}
	
	private void setConfiguration() {
		
		String host = "52.34.153.44";//PropsValues.EXTERNAL_SERVICES_HOST;
		int port = 5555;//PropsValues.EXTERNAL_SERVICES_PORT;
		String protocol = "http";//PropsValues.EXTERNAL_SERVICES_PROTOCOL;
		boolean enabled = true;//PropsValues.AUCHAN_EXTERNAL_SERVICES_COMMUNICATION_ENABLED;
		
		RemoteServiceConfiguration fromLiferayConfiguration = new RemoteServiceConfiguration(host, port, enabled);
		
		if (protocol != null) {
			fromLiferayConfiguration.setProtocol(protocol);
		}
		
		try {	
			
			fromLiferayConfiguration.validate();
			configuration = fromLiferayConfiguration;
			
		} catch (ExceptionTechnique e) {
			_log.error("Setting default configuration : " + e.getMessage());
			configuration = new DefaultRemoteServiceConfiguration();
		}
		_log.info(":: Initializing Remote client Configuration");
		_log.info(configuration.toString());
		_log.info(":: Done.");
		
	}

}
