package com.adscoop.mailservice.models;

/**
 * Created by thokle on 10/02/2017.
 */
public class Email {

 private String subject;

 private String email;


 private String body;


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
