package gui;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ServerAction implements ActionListener {
	private int port;


	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		new Thread(new ServerThread(port)).start();
		
	
	}
	
	public void setPort(int ports)
	{
		port = ports;
	}
	
	

}
