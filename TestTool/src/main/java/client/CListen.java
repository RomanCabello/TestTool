package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JTextField;

public class CListen extends Thread{
	
	private BufferedReader in;
	private JTextField tf;
	private String text;
	
	public CListen(JTextField f,BufferedReader str)
	{
		in = str;
		tf = f;
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
		}
	}
	
	public void write()
	{
		tf.setText(text);
	}

}
