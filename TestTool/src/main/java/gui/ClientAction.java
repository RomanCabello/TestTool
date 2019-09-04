package gui;


import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClientAction implements ActionListener{
private Frame frame;
private int port;
private int ip;



	public  ClientAction(Frame mframe)
	{
		frame = mframe;
		
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		new Thread(new ClientThread(frame,port,ip)).start();
		
		
	}
	
	public void setPort(int ports)
	{
		port = ports;
	}
	
	public void setIP(int ipa)
	{
		ip = ipa;
	}

}
