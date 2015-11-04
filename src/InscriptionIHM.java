import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InscriptionIHM extends JPanel implements ActionListener {

	private Client client;
	private JButton OKButton;
	private JTextField nomEnter, mailEnter, loginEnter, psw1Enter, psw2Enter;
	//TODO passer les psw en private ou protected et faire les fonctions de récup des données en sécurisé
	private String login, psw1, psw2, nom, mail;
	Dimension fenSize = new Dimension(300,200);
	
	public InscriptionIHM(Client client){
		this.client = client; 
		this.client.setPreferredSize(fenSize);
		this.setPreferredSize(fenSize);
//TODO ajouter une image inscription
		nomEnter = new JTextField("Votre nom",20);
		this.add(nomEnter);
		mailEnter = new JTextField("Votre mail",20);
		this.add(mailEnter);
		loginEnter = new JTextField("Votre login",20);
		this.add(loginEnter);
//TODO mettre les psw en caché
		psw1Enter = new JTextField("Votre mot de passe",20);
		this.add(psw1Enter);
		psw2Enter = new JTextField("Votre mot de passe",20);
		this.add(psw2Enter);
		OKButton = new JButton("Se connecter");
		OKButton.addActionListener(this);
		this.add(OKButton);
		this.client.pack();
	}
	
	public void actionPerformed(ActionEvent evnt) {
		Object s = evnt.getSource();
		if(s == OKButton){
			//enregistrement des données
			client.currentUser.setUserName(nomEnter.getText());
			client.currentUser.setMail(mailEnter.getText());
			client.currentUser.setLogin(loginEnter.getText());
			psw1 = psw1Enter.getText();
			psw2 = psw2Enter.getText();
			if(psw1.equals(psw2)){
				if (Client.sqlback.UserCheck(mail))
				{
					client.currentUser.setPsw(psw1);
					this.client.pageAbonnement();
					System.out.println(login + " " + psw1 + " choix abonnement..."); 
				}
				else{
					System.out.println("cet addresse mail est déjà utilisée");
				}
			}
			else{
				System.out.println("mots de passe différents"); 
			}
		}
	}
}
