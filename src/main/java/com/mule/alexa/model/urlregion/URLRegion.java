package com.mule.alexa.model.urlregion;

import com.mule.alexa.utilities.Constants;

public class URLRegion {

    private String environment;
    private String region;
    private String notificationServiceUrl;


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

    public String getNotificationServiceUrl() {
        switch (region){

            case "EU":
                this.notificationServiceUrl = Constants.PROACTIVE_EVENT_EU_URL;
                break;
            case "NA":
                this.notificationServiceUrl = Constants.PROACTIVE_EVENT_NA_URL;
                break;
            case "FE":
                this.notificationServiceUrl = Constants.PROACTIVE_EVENT_FE_URL;
                break;
        }

        if(environment.equals("DEV")){
            this.notificationServiceUrl += Constants.PROACTIVE_EVENT_DEV_URI;
        }

        return this.notificationServiceUrl;
    }

    public void setNotificationServiceUrl(String notificationServiceUrl) {
        this.notificationServiceUrl = notificationServiceUrl;
    }
}
