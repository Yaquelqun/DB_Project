import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginIHM extends JPanel implements ActionListener {

	private Client client;
	private JButton connectButton, signInButton;
	private JTextField loginEnter, pswEnter;
	private String login, psw;
	Dimension fenSize = new Dimension(300,200);
	
	public LoginIHM(Client client){
		this.client = client;
		this.client.setPreferredSize(fenSize);
		this.setPreferredSize(fenSize);
//TODO ajouter une image au login
		loginEnter = new JTextField("Votre login",20);
		this.add(loginEnter);
//TODO mettre le psw en caché
		pswEnter = new JTextField("Votre mot de passe",20);
		this.add(pswEnter);
		connectButton = new JButton("Se connecter");
		connectButton.addActionListener(this);
		this.add(connectButton);
		signInButton = new JButton("S'inscrire");
		signInButton.addActionListener(this);
		this.add(signInButton);
		this.client.pack();
	}
	
	public void actionPerformed(ActionEvent evnt) {
		Object s = evnt.getSource();
		if(s == connectButton){
			//enregistrement du login/psw
			login = loginEnter.getText();
			psw = pswEnter.getText();
			System.out.println(login + " " + psw + " connexion..."); 
//TODO comparer à la base de données et connexion done ou pas
		}
		if(s == signInButton){
			System.out.println("changement de panneau");
			client.pageInscription();
		}
	}

}
