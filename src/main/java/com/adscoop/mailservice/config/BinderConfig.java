package com.adscoop.mailservice.config;

import com.adscoop.mailservice.handlers.SendEmailHandler;
import com.google.inject.AbstractModule;

/**
 * Created by thokle on 08/02/2017.
 */
public class BinderConfig extends AbstractModule {
    @Override
    protected void configure() {
        //Handlers
        bind(SendEmailHandler.class).asEagerSingleton();





    }
}
