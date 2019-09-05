package gui;

import java.awt.Frame;
import java.io.IOException;

import server.Server;

public class ServerThread implements Runnable{
	private Server server;
	private int port;
	private int ip;
	
	public ServerThread(int ports) {
		port = ports;
	}

	public void run() {
		// TODO Auto-generated method stub
		server = new Server(port);
		
		try {
			server.go();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
