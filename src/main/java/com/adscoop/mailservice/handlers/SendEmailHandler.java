package com.adscoop.mailservice.handlers;

import com.adscoop.mailservice.entites.UserNode;
import com.adscoop.mailservice.models.Email;
import com.adscoop.mailservice.services.MailService;
import com.google.inject.Inject;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import javax.mail.internet.MimeMessage;
import java.util.Optional;

import static ratpack.jackson.Jackson.fromJson;

/**
 * Created by thokle on 08/02/2017.
 */
public class SendEmailHandler implements Handler{

MailService mailService;

    @Inject
    public SendEmailHandler( MailService mailService ) {

        this.mailService = mailService;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        String token = ctx.getPathTokens().get("token");

         ctx.parse(fromJson(Email.class)).then( email -> {


             mailService.sendMaill(email.getEmail(),email.getSubject(),email.getBody(), (MimeMessage.RecipientType) MimeMessage.RecipientType.TO);



         });
    }
}
