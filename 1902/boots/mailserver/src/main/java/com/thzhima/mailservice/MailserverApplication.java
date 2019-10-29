package com.thzhima.mailservice;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.thzhima.blog.bean.User;

@SpringBootApplication
public class MailserverApplication {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public static void main(String[] args) {
		SpringApplication.run(MailserverApplication.class, args);
	}
    
	@JmsListener(destination = "emailQueue")
	public void receive(Message msg) throws JMSException {
		System.out.println("receive:" + msg);
		ActiveMQObjectMessage m = (ActiveMQObjectMessage) msg;
		User u = (User) m.getObject();
		System.out.println(u);
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("392977758@qq.com");
		mail.setFrom("392977758@qq.com");
		mail.setSubject("regist active");
		mail.setText(u.toString());
		mail.setSentDate(new Date());
		this.javaMailSender.send(mail);
	}
	
	

}
