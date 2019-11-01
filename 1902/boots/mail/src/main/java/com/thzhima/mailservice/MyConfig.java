package com.thzhima.mailservice;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.thzhima.blog.bean.User;

@Configuration
public class MyConfig {
	
	@Autowired
	private JavaMailSender sender;

	@JmsListener(destination = "emailMQ")
	public void listen(Message m) throws JMSException {
		System.out.println("--------------listen-------------");
		ObjectMessage msg = (ObjectMessage) m;
		User user = (User) msg.getObject();
		System.out.println(user);
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		simpleMessage.setFrom("392977758@qq.com");
		simpleMessage.setTo(user.getEmail());
		simpleMessage.setSubject("用户注册激活");
		simpleMessage.setText("http://127.0.0.1:8088/active?id="+user.getUserID()+"&token="+user.getToken());
		sender.send(simpleMessage);
	}
}
