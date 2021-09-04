package com.pcwk.ehr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class DummyMailSender implements MailSender {
    final Logger  LOG = LoggerFactory.getLogger(getClass());

	public void send(SimpleMailMessage simpleMessage) throws MailException {
		LOG.debug("========================");
		LOG.debug("=개발, 실제로는 메일 모내지 않음!==");
		LOG.debug("========================");
		
	}

	public void send(SimpleMailMessage... simpleMessages) throws MailException {
		// TODO Auto-generated method stub
		
	}


}
