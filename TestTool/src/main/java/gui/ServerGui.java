package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

import javax.swing.*;

import server.SListen;
import server.Server;

public class ServerGui {
	private Frame frame;
	private Server sr;
	private String txt;
	private BufferedReader br;
	private JTextField text;
	
	public void Make()
	{
		frame = new JFrame("Server");
		
		text = new JTextField();
		text.setBounds(10, 100, 350, 300);
		
		JButton send = new JButton("get");
		send.setBounds(200, 50, 100, 40);
		send.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0)
					{
				/*
				 * try { txt = sr.read(); } catch (IOException e) { // TODO Auto-generated catch
				 * block text.setText("nope"); }
				 */
						//new SListen(text,br).start();
						//text.setText(txt);
						sr.setOut("ok");
						
					}
				});
		
		
		frame.add(text);
		frame.add(send);
		
		frame.setSize(400, 500);// 400 width and 500 height
		frame.setLayout(null);// using no layout managers
		frame.setVisible(true);// making the frame visible
	}
	
	public void setServer(Server s)
	{
		sr = s;
	}
	
	public void setReader(BufferedReader in)
	{
		br = in;
	}
	
	public JTextField getField()
	{
		return text;
	}
	
}
