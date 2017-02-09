package com.adscoop.mailservice.services;

import com.adscoop.mailservice.config.MailConfig;
import com.google.inject.Inject;

/**
 * Created by kleistit on 09/02/2017.
 */
public class MailServiceImpl implements MailService {

    MailConfig mailConfig;

    @Inject
    public MailServiceImpl(MailConfig mailConfig) {
        this.mailConfig = mailConfig;
    }

    @Override
    public boolean sendActivationMail(String email, String url) {
        return false;
    }
}
