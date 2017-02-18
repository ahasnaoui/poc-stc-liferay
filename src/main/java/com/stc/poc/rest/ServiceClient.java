package com.stc.poc.rest;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.stc.poc.rest.exception.ExceptionTechnique;
import com.stc.poc.rest.exception.ServicesConnectException;

/**
 * 
 * @author ahasnaoui
 *
 */
public class ServiceClient {
	
	private static final Logger _log = LoggerFactory.getLogger(ServiceClient.class);
	
	private final static String PREFIX = "/rest/stc/poc/restdfs";
	
	protected RemoteServiceConfiguration configuration;
	
	private RestTemplate template;
	
	public ServiceClient(RemoteServiceConfiguration configuration) {
		super();
		this.configuration = configuration;
		this.template = new RestTemplate(getClientHttpRequestFactory());
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		interceptors.add(new HeaderRequestInterceptor("Accept", MediaType.APPLICATION_JSON_VALUE));
		interceptors.add(new HeaderRequestInterceptor("Content-Type", MediaType.APPLICATION_JSON_VALUE));
		interceptors.add(new HeaderRequestInterceptor("Cache-Control", "no-cache"));
		
		this.template.setInterceptors(interceptors);
		
	}

	public void delete(String url, Object... urlVariables)  throws ServicesConnectException {
		
		if (configuration.isRemoteHostEnabled()) {
			try {
				
				template.delete(url, urlVariables);
				
			} catch (ResourceAccessException e) {
				throw new ServicesConnectException(e.getMessage(), e);
			}
		} else {
			_log.warn("External services connexion is currently disabled.");
		}
		
		
	}

	public <T> T postForObject(String url, Object request, Class<T> responseType) throws ServicesConnectException {
		
		if (configuration.isRemoteHostEnabled()) {
			try {
				return template.postForObject(url, request, responseType);
			} catch (ResourceAccessException e) {
				throw new ServicesConnectException(e.getMessage(), e);
			}
		} else {
			_log.warn("External services connexion is currently disabled.");
			return null;
		}
		
	}
	
	public <T> T getForObject(String url, Class<T> responseType, Object... urlVariables) throws ServicesConnectException {
		
		if (configuration.isRemoteHostEnabled()) {
			try {
				return template.getForObject(url, responseType, urlVariables);
			} catch (ResourceAccessException e) {
				throw new ServicesConnectException(e.getMessage(), e);
			} 
		} else {
			_log.warn("External services connexion is currently disabled.");
			return null;		
		}		
	}
	
	/**
	 * Build service URL
	 * @param serviceId
	 * @return
	 */
	public String getUrl(String serviceId) {
		
		String url = null;
		try {
			url = getPrefixUrl(this.configuration) + serviceId;
		} catch (ExceptionTechnique e) {
			_log.error(e.getMessage(), e);
		}
		
		return url;
		
	}
    
	public RemoteServiceConfiguration getConfiguration() {
		return configuration;
	}

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
    	SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(10000);
        factory.setConnectTimeout(10000);
        
        return factory;
    }
    
	private String getPrefixUrl(RemoteServiceConfiguration configuration) throws ExceptionTechnique  {
		
		//Configuration validation
		if (configuration == null ) {
			_log.error("Configuration error");
			throw new ExceptionTechnique("Unable to load configuration for null");
		} 
		configuration.validate();
	      
		return configuration.getURI() + PREFIX;
		
	}
	
}
