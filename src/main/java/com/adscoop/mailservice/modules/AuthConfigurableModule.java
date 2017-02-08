package com.adscoop.mailservice.modules;


import com.adscoop.userservice.congfig.AEService;
import com.adscoop.userservice.services.impls.IAuthorazationService;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.neo4j.ogm.session.Session;

/**
 * Created by thokle on 05/01/2017.
 */
public class AuthConfigurableModule extends AbstractModule {





    @Override
    protected void configure() {

    }


    @Provides
    public IAuthorazationService authorazationService(Session configure, AEService aeService){
        return new AuthorazationService(configure, aeService);


    }
}
