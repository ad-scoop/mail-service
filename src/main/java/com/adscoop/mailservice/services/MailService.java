package com.adscoop.mailservice.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by thokle on 09/02/2017.
 */
public interface MailService {

    boolean sendMaill(String email, String subject, String text, MimeMessage.RecipientType type) throws MessagingException;

}
