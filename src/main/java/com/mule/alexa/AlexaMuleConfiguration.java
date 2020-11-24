package com.mule.alexa;

import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.values.OfValues;


import com.mule.alexa.model.urlregion.EnvirommentProvider;

import com.mule.alexa.model.urlregion.RegionProvider;

@Operations(MuleAlexaOperations.class)
public class AlexaMuleConfiguration {
	@Parameter
	private String clientId;
	@Parameter
    private String secretId;
	
	@Parameter
	@OfValues(EnvirommentProvider.class)
	private String environment;
	
	@Parameter
	@OfValues(RegionProvider.class)
	private String region;
    
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getSecretId() {
		return secretId;
	}
	public void setSecretId(String secretId) {
		this.secretId = secretId;
	}
    


}
