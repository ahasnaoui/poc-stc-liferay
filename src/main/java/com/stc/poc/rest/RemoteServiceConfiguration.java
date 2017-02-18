package com.stc.poc.rest;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.stc.poc.rest.exception.ExceptionTechnique;

/**
 * 
 * @author ahasnaoui
 * Implementation for remote client configuration
 *
 */
public class RemoteServiceConfiguration {
	

	private static final Logger _log = LoggerFactory.getLogger(RemoteServiceConfiguration.class);
	
	private String protocol;
	private String host;
	private int port;
	private boolean remoteHostEnabled;
	
	public RemoteServiceConfiguration() {
		super();
	}
	
	public RemoteServiceConfiguration(String host, int port, boolean enabled) {
		super();
		this.host = host;
		this.port = port;
		this.protocol = "http";
		this.remoteHostEnabled = enabled;
	}
	
	public void validate() throws ExceptionTechnique {
		
		if (this.host == null || this.host.equals("")) {
			throw new ExceptionTechnique("Invalid Host");
		}
		
		if (this.protocol == null || this.protocol.equals("")) {
			throw new ExceptionTechnique("Invalid protocol");
		}
		
		String uri = getURI();
		try {
			new URI(uri);
		} catch (URISyntaxException e) {
			_log.error(e.getMessage() ,e);
			throw new ExceptionTechnique(e);
		}
		
	}
	
	@Override
	public String toString() {
		return "Creating client configuration [protocol=" + protocol + ", host="
				+ host + ", port=" + port + ", remoteHostEnabled=" + remoteHostEnabled + "]";
	}
	
	public String getURI() {
		return this.protocol + "://" + this.host + ":" + this.port;
	}
	
	public String getProtocol() {
		return protocol;
	}
	public String getHost() {
		return host;
	}
	public int getPort() {
		return port;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public void setPort(int port) {
		this.port = port;
	}

	public boolean isRemoteHostEnabled() {
		return remoteHostEnabled;
	}

	public void setRemoteHostEnabled(boolean remoteHostEnabled) {
		this.remoteHostEnabled = remoteHostEnabled;
	}

}
