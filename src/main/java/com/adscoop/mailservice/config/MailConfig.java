package com.adscoop.mailservice.config;

/**
 * Created by thokle on 08/02/2017.
 */
public class MailConfig {
    private String smtp;
    private String activation;


    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public String getActivation() {
        return activation;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }
}
