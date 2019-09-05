package server;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import client.Client;

import java.io.*;
import gui.ServerGui;

public class Server {
	private ServerSocket ss;
	private int port;
	private List<PrintWriter> out = new ArrayList<PrintWriter>(); ;
    private List <BufferedReader> in = new ArrayList<BufferedReader>();
    private List <Socket> s = new ArrayList<Socket>();
    private ServerGui sg;
    private JTextField tf;
    
    private int i;
	
    
	public Server(int ports)
	{
		port = ports;
	}
	
	public void go() throws IOException
	{
		
		
		
        boolean flag = true;
		
		try {
			ss = new ServerSocket();
			ss.bind(new InetSocketAddress("127.0.0.1",port));
			
			System.out.println("Listening");
		} catch (java.net.BindException e) {
			// TODO Auto-generated catch block
			System.out.println("taken");
			flag = false;
		}
		
		if (flag)
		{
			sg = new ServerGui();
			sg.Make();
			sg.setServer(this);
			tf = sg.getField();
			i = 0;
		}
		
		while (true) {
			s.add(ss.accept());
			out.add(new PrintWriter(s.get(i).getOutputStream(), true));
			in.add(new BufferedReader(new InputStreamReader(s.get(i).getInputStream())));
			new SListen(tf, in.get(i), out.get(i)).start();
			//sg.setReader(in.get(i));
			new Client().start();
			i++;
		}
	}
	
	public SocketAddress turn(String a, int port)
	{
		SocketAddress addr = new InetSocketAddress(a, port);
		return addr;
	}
	
	public String read() throws IOException
	{
		String text = in.get(i-1).readLine();
		return text;
	}
	
	public void setOut(String msg)
	{
		out.get(i-1).println(msg);
	}
}
