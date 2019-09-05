package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;

import server.Server;

public class ServerGui {
	private Frame frame;
	private Server sr;
	private String txt;
	private PrintWriter out;
	private JTextField text;
	private List<PrintWriter> list = new ArrayList<PrintWriter>();
	private Iterator<PrintWriter> it;

	public void Make() {
		frame = new JFrame("Server");

		text = new JTextField();
		text.setBounds(10, 100, 350, 300);

		JButton send = new JButton("Broadcast");
		send.setBounds(200, 50, 100, 40);
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				while (it.hasNext()) {
					out = it.next();

					out.println("Hi");
				}
			}
		});

		frame.add(text);
		frame.add(send);

		frame.setSize(400, 500);// 400 width and 500 height
		frame.setLayout(null);// using no layout managers
		frame.setVisible(true);// making the frame visible
	}

	public void setList(List<PrintWriter> pw) {
		list = pw;
		it = list.iterator();
	}

	public JTextField getField() {
		return text;
	}

}
