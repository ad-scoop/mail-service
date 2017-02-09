package com.adscoop.mailservice.config;

import com.adscoop.mailservice.handlers.ActivateUserHandler;
import com.adscoop.mailservice.services.MailService;
import com.adscoop.mailservice.services.MailServiceImpl;
import com.adscoop.mailservice.services.UserService;
import com.adscoop.mailservice.services.UserServiceImpl;
import com.google.inject.AbstractModule;

/**
 * Created by thokle on 08/02/2017.
 */
public class BinderConfig extends AbstractModule {
    @Override
    protected void configure() {
        //Handlers
        bind(ActivateUserHandler.class).asEagerSingleton();


        //Services
        bind(UserService.class).to(UserServiceImpl.class).asEagerSingleton();
        bind(MailService.class).to(MailServiceImpl.class).asEagerSingleton();

    }
}
