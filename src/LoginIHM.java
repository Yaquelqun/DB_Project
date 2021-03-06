import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginIHM extends JPanel implements ActionListener {

	private Client client;
	private JButton connectButton, signInButton;
	private JTextField mailEnter, pswEnter;
	private String mail, psw;
	Dimension fenSize = new Dimension(300,200);
	
	public LoginIHM(Client client){
		this.client = client;
		this.client.setPreferredSize(fenSize);
		this.setPreferredSize(fenSize);
//TODO ajouter une image au login

		mailEnter = new JTextField("jean.aimarre@gmail.com",20);
		this.add(mailEnter);
//TODO mettre le psw en cach�
		pswEnter = new JTextField("renard",20);
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
			mail = mailEnter.getText();
			psw = pswEnter.getText();
			System.out.println(mail + " " + psw + " connexion...");
			try {
				if(client.sqlback.checkLogin(mail, psw)){
					client.currentUser = client.sqlback.getUser(mail);
					client.pageMain();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(s == signInButton){
			System.out.println("changement de panneau");
			client.pageInscription();
		}
	}

}
