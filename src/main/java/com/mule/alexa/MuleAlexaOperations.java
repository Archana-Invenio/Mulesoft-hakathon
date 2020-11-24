package com.mule.alexa;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.MediaType;

import com.mule.alexa.client.AlexaProactiveEventSenderClient;
import com.mule.alexa.model.event.ProactiveEvent;
import com.mule.alexa.model.urlregion.URLRegion;
import com.mule.alexa.utilities.LogUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MuleAlexaOperations {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MuleAlexaOperations.class);
	
	@MediaType(value=ANY ,strict =false)
    @Alias("echoAlexa")
	public void makeAnAlertToAlexa(@Config AlexaMuleConfiguration a)
	{
		LOGGER.info("Senting alert to subscribed devices");
	LogUtilities logger = new LogUtilities();
	String clientId = a.getClientId();
    String secretId = a.getSecretId();

    AlexaProactiveEventSenderClient client = new AlexaProactiveEventSenderClient(clientId, secretId);
    logger.log("Token: " + client.getToken());
    

    ProactiveEvent event = new ProactiveEvent();
    event.getEvent().getPayload().getMessageGroup().getCreator().setName("Test Alert 123");

    URLRegion urlRegion = new URLRegion();
    urlRegion.setRegion(a.getRegion());
    urlRegion.setEnvironment(a.getEnvironment());

    boolean ok = client.sendProactiveEvent(event, urlRegion);
    logger.log("Response was: " + ok);
   
	
	}
}
