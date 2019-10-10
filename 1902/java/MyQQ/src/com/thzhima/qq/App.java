package com.thzhima.qq;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class App extends JFrame{
	private JTextArea text;
	private JTextField address;
	private JTextField port;
	private JButton btn;
	private JLabel clock;
	private Thread t ;
	
	public App() {
		JPanel panel= new JPanel(null);
		this.setContentPane(panel);
		
		JLabel addLbl = new JLabel("对方IP：");
		addLbl.setSize(100, 50);
		addLbl.setLocation(20, 50);
		panel.add(addLbl);
		
		this.address = new JTextField();
		this.address.setSize(200, 50);
		this.address.setLocation(100, 50);
		panel.add(this.address);
		
		JLabel portLbl = new JLabel("端口：");
		portLbl.setSize(50, 50);
		portLbl.setLocation(350, 50);
		panel.add(portLbl);
		
		this.port = new JTextField();
		this.port.setSize(80, 50);
		this.port.setLocation(400, 50);
		panel.add(this.port);
		
		
		
		this.text = new JTextArea();
		this.text.setSize(700, 200);
		this.text.setLocation(50, 250);
		this.text.setAutoscrolls(true);
		panel.add(text);
		
		this.btn = new JButton("stop");
		this.btn.setSize(80, 60);
		this.btn.setLocation(700, 500);
		panel.add(btn);
		
		
		//----------------------------------
		this.clock = new JLabel();
		this.clock.setSize(200, 50);
		this.clock.setLocation(10, 10);
		panel.add(clock);

		//-----------------------------------
		this.setTitle("MyQQ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setVisible(true);
		this.init();
	}
	
	private void init() {
		 this.btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				String address = App.this.address.getText();
//				String strport = App.this.port.getText();
//				int port = Integer.valueOf(strport);
//				String msg = App.this.text.getText();
//				System.out.println(address +","+port+","+msg);
				
				t.interrupt();
			
			}
		});
		 
		this.t= new Thread() {
			 public void run() {
				 long wait = 1000;
				
				 Date now = new Date();
				 try {
				 while(true) {
					   long next = now.getTime()+1000; //下次的理论时间;
					   
				    	SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				    	String time = fmt.format(now);
				    	App.this.clock.setText(time);
				    	System.out.println(time);
				    	
				    
						Thread.sleep(wait);
						
				    	now = new Date();
				    	long realTime = now.getTime();
				    	long x = realTime-next;
				    	wait -= x;
				    	System.out.println(wait);
				    }
				 }catch(InterruptedException e) {
					 e.printStackTrace();
				 }
				
			 }
			 
		 };
		 t.start();
	   
	}
	

	public static void main(String[] args) {
		App app = new App();
	}

}
