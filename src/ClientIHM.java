import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ClientIHM extends JPanel implements ActionListener {

	private Client client;
	private JPanel panneauConnect, panneauChat, panneauMessage;
	private JButton connectButton, sendButton;
	private JTextField nomEdit, messageEdit;
	private String nom, message;
	private JTextArea chatArea;
	Dimension fenSize = new Dimension(600,600);
	
	public ClientIHM(Client client){
		this.client = client;
		this.setPreferredSize(fenSize);
		panneauConnect = new JPanel();
		nomEdit = new JTextField("Entrez votre nom",20);
		panneauConnect.add(nomEdit);
		connectButton = new JButton("Connection");
		connectButton.addActionListener(this);
		panneauConnect.add(connectButton);
		add(panneauConnect, BorderLayout.NORTH);
		panneauChat = new JPanel();
		chatArea = new JTextArea();
		panneauChat.add(chatArea);
		add(panneauChat, BorderLayout.CENTER);
		panneauMessage = new JPanel();
		messageEdit = new JTextField("Entrez le message à envoyer");
		panneauMessage.add(messageEdit);
		sendButton = new JButton("Envoyer");
		sendButton.addActionListener(this);
		panneauMessage.add(sendButton);
		add(panneauMessage, BorderLayout.SOUTH);
		this.client.pack();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
