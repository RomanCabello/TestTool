package server;
import java.net.*;
import java.io.*;
import gui.ServerGui;

public class Server {
	private ServerSocket ss;
	private int port;
	private int ip;
	private PrintWriter out;
    private BufferedReader in;
    private Socket s;
    private ServerGui sg;
	
    
	public Server(int ports, int ipa)
	{
		port = ports;
		ip = ipa;
	}
	
	public void go() throws IOException
	{
		String address = "127.0.0."+ip;
		
		
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
			s = ss.accept();
			out = new PrintWriter(s.getOutputStream(), true);
	        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		}
	}
	
	public SocketAddress turn(String a, int port)
	{
		SocketAddress addr = new InetSocketAddress(a, port);
		return addr;
	}
	
	public String read() throws IOException
	{
		String text = in.readLine();
		return text;
	}
	
	public void setOut(String msg)
	{
		out.println(msg);
	}
}
