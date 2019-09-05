package client;
import java.net.*;
import java.io.*;
import gui.ClientGui;

public class Client extends Thread{

	private Socket s;
	private String report;
	private int port;
	private PrintWriter out;
    private BufferedReader in;
	private ClientGui cg;
	
    
	public Client(int ports)
	{
		port = ports;
	}
	
	public Client()
	{
		
	}
	
	public void run()
	{
		boolean flag = true;
		
			try {
				s = new Socket("127.0.0.1", port);
				System.out.println(s.getLocalAddress());
				
				report = "success";
			} catch (java.net.ConnectException e) {
				// TODO Auto-generated catch block
				report = "sorry bud";
				flag = false;
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			if (flag) {
				cg = new ClientGui();
				cg.Make();
				cg.setClient(this);
				try {
					out = new PrintWriter(s.getOutputStream(), true);
					in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				new CListen(cg.getField(),in).start();
				
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
