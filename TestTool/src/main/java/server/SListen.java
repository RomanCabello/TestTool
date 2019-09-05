package server;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JTextField;

public class SListen extends Thread{
	private BufferedReader in;
	private JTextField tf;
	private String text;
	private PrintWriter out;
	
	public SListen(JTextField f,BufferedReader str, PrintWriter pw)
	{
		in = str;
		tf = f;
		out = pw;
	}
	
	
	public void run()
	{
		while(true)
		{
			try {
				text = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			write();
			out.println("ok");
		}
	}
	
	public void write()
	{
		tf.setText(text);
	}

}
