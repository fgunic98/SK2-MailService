package com.mail.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.mail.dto.JokeMail;
import com.mail.listener.helper.MessageHelper;
import com.mail.service.EmailService;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class EmailListener {

    private MessageHelper messageHelper;
    private EmailService emailService;

    public EmailListener(MessageHelper messageHelper, EmailService emailService) {
        this.messageHelper = messageHelper;
        this.emailService = emailService;
    }

    @JmsListener(destination = "${destination.sendEmails}", concurrency = "5-10")
    public void addOrder(Message message) throws JMSException {
        JokeMail joke = messageHelper.getMessage(message, JokeMail.class);
        emailService.sendSimpleMessage(joke.getUserMail(), "New joke for you!", joke.toString());
    }
}

