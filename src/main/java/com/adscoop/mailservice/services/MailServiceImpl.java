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
public class MailServiceImpl implements MailService {


    private String from;
    private  String smtp;

    @Inject
    public MailServiceImpl(MailConfig mailConfig) {
      setSmtp(mailConfig.getSmtp());
      setFrom(mailConfig.getFrom());
    }

    @Override
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

        mimeMessage.setFrom(new InternetAddress(from));
     mimeMessage.setText(message);


        return mimeMessage;
    }


    private Properties properties()
    {
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host",getSmtp());
        return  properties;

    }


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }


    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }
}
