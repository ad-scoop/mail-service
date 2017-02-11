package com.adscoop.mailservice.services;

import com.adscoop.mailservice.modules.MailConfig;
import com.google.inject.Inject;
import  javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by kleistit on 09/02/2017.
 */
public class MailServiceImpl  {



    private MailConfig mailConfig;
    @Inject
    public MailServiceImpl(MailConfig mailConfig) {
      this.mailConfig = mailConfig;
    }


    public boolean sendMaill(String email,String subject, String text) throws MessagingException {
        try {
            Transport.send(mimeMessage(text,subject, email));
        } catch (MessagingException e) {
            throw  new MessagingException(e.toString());
        }
        return false;
    }






    private Message mimeMessage(String message, String subject, String email) throws MessagingException {
        Session session = Session.getDefaultInstance(properties());
     MimeMessage mimeMessage = new MimeMessage(session);
     mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
     mimeMessage.setSubject(subject);

        mimeMessage.setFrom(new InternetAddress(mailConfig.getFrom()));
     mimeMessage.setText(message);


        return mimeMessage;
    }


    private Properties properties()
    {
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host",mailConfig.getSmtp());
        return  properties;

    }



}
