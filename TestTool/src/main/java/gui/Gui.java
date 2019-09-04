package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Gui {
	Frame f;
	ClientAction cla = new ClientAction(f);
	ServerAction sra = new ServerAction();
	private int porta;
	private int portb;
	private int ipa;
	private int ipb;
	


	public void createNshow() {
		f = new JFrame("Test Tool");// creating instance of JFrame
		
		
		JButton client = new JButton ("Client");
		client.setBounds(30, 100, 100, 40);
		client.addActionListener(cla);
		
		JButton server = new JButton("Server");
		server.setBounds(230, 100, 100, 40);
		server.addActionListener(sra);
		
		final JSpinner port1 = new JSpinner();
		port1.setBounds(30, 200, 50, 30);
		
		final JSpinner port2 = new JSpinner();
		port2.setBounds(230, 200, 50, 30);
		
		final JSpinner ip1 = new JSpinner();
		ip1.setBounds(30, 300, 50, 30);
		
		final JSpinner ip2 = new JSpinner();
		ip2.setBounds(230, 300, 50, 30);
		
		
		
		port1.addChangeListener(new ChangeListener() {


			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				porta = (Integer) port1.getValue();
				cla.setPort(porta);
			}
		});
		
		port2.addChangeListener(new ChangeListener() {


			public void stateChanged(ChangeEvent f) {
				// TODO Auto-generated method stub
				portb = (Integer) port2.getValue();
				sra.setPort(portb);
			}
		});
		
		ip1.addChangeListener(new ChangeListener() {


			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				ipa = (Integer) ip1.getValue();
				cla.setPort(ipa);
			}
		});
		
		ip2.addChangeListener(new ChangeListener() {


			public void stateChanged(ChangeEvent f) {
				// TODO Auto-generated method stub
				ipb = (Integer) ip2.getValue();
				sra.setPort(ipb);
			}
		});
		
	
		f.add(ip1);
		f.add(ip2);
		
		f.add(port1);
		f.add(port2);
		
		f.add(client);	
		f.add(server);
		
		f.setSize(400, 500);// 400 width and 500 height
		f.setLayout(null);// using no layout managers
		f.setVisible(true);// making the frame visible
	}
	
	public int getPort1()
	{
		porta = 1;
		return porta;
		
	}

}
	

