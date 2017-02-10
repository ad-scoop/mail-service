package com.adscoop.mailservice.handlers;


import com.adscoop.mailservice.models.Email;

import com.adscoop.mailservice.services.MailServiceImpl;
import com.google.inject.Inject;
import ratpack.handling.Context;
import ratpack.handling.Handler;


import static ratpack.jackson.Jackson.fromJson;

/**
 * Created by thokle on 08/02/2017.
 */
public class SendEmailHandler implements Handler{

MailServiceImpl mailService;

    @Inject
    public SendEmailHandler( MailServiceImpl mailService ) {

        this.mailService = mailService;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        String token = ctx.getPathTokens().get("token");

         ctx.parse(fromJson(Email.class)).then( (Email email) -> {


             mailService.sendMaill(email.getEmail(),email.getSubject(),email.getBody());



         });
    }
}
