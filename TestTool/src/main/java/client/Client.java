package client;
import java.net.*;
import java.io.*;
import gui.ClientGui;

public class Client {

	private Socket s;
	private String report;
	private int port;
	private int ip;
	private PrintWriter out;
    private BufferedReader in;
	private ClientGui cg;
	private boolean listen;
    
	public Client(int ports, int ipa)
	{
		port = ports;
		ip = ipa;
	}
	
	public void go() throws IOException
	{
		listen = false;
		boolean flag = true;
		
			try {
				s = new Socket("127.0.0.1", port);
				System.out.println(s.getLocalAddress());
				
				report = "success";
			} catch (java.net.ConnectException e) {
				// TODO Auto-generated catch block
				report = "sorry bud";
				flag = false;
				
			} 
			
			
			if (flag) {
				cg = new ClientGui();
				cg.Make();
				cg.setClient(this);
				out = new PrintWriter(s.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			}
		
	}
	public String getReport()
	{
		return report;
	}
	
	public void setOut(String msg)
	{
		out.println(msg);
	}
	
	public String read() throws IOException
	{
		String text = in.readLine();
		return text;
	}
	
	public void end() throws IOException
	{
		in.close();
		out.close();
		s.close();
	}
	
	

}
