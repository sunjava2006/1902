package com.thzhima.mq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class PublishMQ {

	private static ConnectionFactory factory;
	
	static {
		factory  = new ActiveMQConnectionFactory("admin", "admin", "tcp://127.0.0.1:61616");
	}
	
	public static void publish(String msg) throws JMSException {
		Connection conn  = null;
		Session session = null;
		MessageProducer producer = null;
		
		try {
			conn = factory.createConnection();
			conn.start();
			
			session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
			
			Topic topic = session.createTopic("about1902");
			
			producer = session.createProducer(topic);
			
			TextMessage message = session.createTextMessage(msg);
			
			producer.send(message);
			
			
			session.commit();
		} catch (JMSException e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			producer.close();
			session.close();
			conn.close();
		}
		
	}
	
	
	public static void listenMsg() throws JMSException {
	
		try {
			final Connection conn = factory.createConnection();
			conn.start();
			
			final Session session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
			Topic topic = session.createTopic("about1902");
			final MessageConsumer consumer = session.createConsumer(topic);
			
		    consumer.setMessageListener(new MessageListener() {
				
				@Override
				public void onMessage(Message message) {
					TextMessage msg=(TextMessage) message;
					String txt;
					try {
						txt = msg.getText();
						System.out.println("收到:" + txt);
						session.commit();
					} catch (JMSException e) {
						
						e.printStackTrace();
					} finally {
						
						try {
							consumer.close();
							session.close();
							conn.close();
						} catch (JMSException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					
				}
			});
			
			
		} catch (JMSException e) {
			
			e.printStackTrace();
		} finally {
			
		}
	}
	
	
	public static void main(String[] args) throws JMSException {
		listenMsg();
		
		publish("hello world!!!!!");
	}
	
}
