package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import client.Client;


import javax.swing.*;


public class ClientGui {
	private Frame frame;
	private PrintWriter out;
	private Client cl;
	private JTextField text;
	
	public void Make() {
		frame = new JFrame("Client");

		text = new JTextField();
		text.setBounds(10, 100, 350, 300);
		
		JButton send = new JButton("send");
		send.setBounds(200, 50, 100, 40);
		send.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0)
					{
						String msg = text.getText();
						cl.setOut(msg);
						
						
//						try {
//							text.setText(cl.read());
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
					}
				});

		frame.add(text);
		
		frame.add(send);

		frame.setSize(400, 500);// 400 width and 500 height
		frame.setLayout(null);// using no layout managers
		frame.setVisible(true);// making the frame visible
	}
	
	public void setClient(Client c)
	{
		cl = c;
	}
	
	public JTextField getField()
	{
		return text;
	}

}
