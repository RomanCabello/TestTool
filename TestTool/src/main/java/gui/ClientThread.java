package gui;

import java.awt.Frame;
import java.io.IOException;

import javax.swing.JOptionPane;

import client.Client;

public class ClientThread  implements Runnable{
	private Client cliente;
	private Frame frame;
	private int port;
	private int ip;
	
	public ClientThread(Frame mfraim, int ports, int ipa)
	{
		frame = mfraim;
		port = ports;
		ip = ipa;
	}

	public void run() {
		// TODO Auto-generated method stub
		cliente = new Client(port, ip);
		
		try {
			cliente.go();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	JOptionPane.showMessageDialog(null, cliente.getReport());
		
	}
	
	public void passFrame(Frame mfraim)
	{
		frame = mfraim;
	}

}
