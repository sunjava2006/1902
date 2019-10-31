package com.thzhima.mq;

import java.util.Scanner;

import javax.jms.JMSException;

/**
 * Hello world!
 *
 */
public class App 
{
	

    public static void main( String[] args ) throws JMSException
    {
        Thread t = new Thread() {
        	public void run() {
        		try {
        			while(true) {
        				System.out.println("---will receive message: ------");
            			String msg = MqTools.receive();
            			System.out.println("---msg is :----------" + msg);
            		}
        		}catch (Exception ex) {
        			ex.printStackTrace();
        		}
        		
        	}
        };
        
        t.setDaemon(true);
        
        t.start();
        
        
        Scanner s = new Scanner(System.in);
        for(int i=0; i<10; i++) {
        	String msg = s.next();
        	MqTools.send(msg);
        }
        
    }
}
