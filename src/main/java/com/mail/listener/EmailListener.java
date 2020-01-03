package com.mail.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.mail.dto.JokeDto;
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
        JokeDto joke = messageHelper.getMessage(message, JokeDto.class);
        emailService.sendSimpleMessage("phrazevideos@gmail.com", "New joke for you!", joke.toString());
    }
}

