package com.adscoop.mailservice.modules;

import com.adscoop.mailservice.services.MailServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

/**
 * Created by thokle on 08/02/2017.
 */
public class EmailModule extends AbstractModule {
    @Override
    protected void configure() {

    }


    @Singleton
    @Provides
    public MailServiceImpl mailService(MailConfig mailConfig){

        return  new MailServiceImpl(mailConfig);
    }
}

