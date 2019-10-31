package com.thzhima.mq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MqTools {
	
	private static ConnectionFactory factory;
	static {
		factory = new ActiveMQConnectionFactory("user", "user", "tcp://127.0.0.1:61616");
	}
	

	public static void send(String msg) throws JMSException {
		
		Connection connection = null;
		Session session = null;
		Queue queue = null;
		MessageProducer producer = null;
		try {
			connection = factory.createConnection();
			connection.start();
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			
			queue = session.createQueue("20"); //创建一个命名的消息队列
			producer = session.createProducer(queue); // 消息发送者
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT); // 不收就过期的消息
			Message message = session.createTextMessage(msg); // 创建消息对象
			
			producer.send(message);
			
			session.commit();
		} catch (JMSException e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			producer.close();
			session.close();
			connection.close();
			System.out.println("==================send end===================");
		}
		
	}
	
	public static String receive() throws JMSException {
		String msg = null;
		
		Connection connection = null;
		Session session = null;
		MessageConsumer consumer = null;
		Queue queue = null;
		try {
			connection = factory.createConnection();
			connection.start();
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			
			queue = session.createQueue("20");
			consumer = session.createConsumer(queue);
			
			TextMessage message = (TextMessage) consumer.receive();
			if(null != message) {
				msg = message.getText();
			}
			
			session.commit();
		} catch (JMSException e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			consumer.close();
			session.close();
			connection.close();
		}
		return msg;
	}

}
