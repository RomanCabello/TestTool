package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.Client;


public class ClientAction implements ActionListener{

private int port;




	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		new Client(port).start();
		
		
	}
	
	public void setPort(int ports)
	{
		port = ports;
	}
	
	
}
