import java.net.* ;
import javax.swing.*;
import java.io.* ; 

public class Client extends JFrame  {

	LoginIHM loginPage;
	static Interpreteur sqlback;
	InscriptionIHM inscriptionPage;
	AbonnementChoiceIHM abonnementPage;
	
	public Client() {
		//IHM
		loginPage = new LoginIHM(this);
		setContentPane(loginPage);
		//affichage interface
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public void pageInscription(){
		inscriptionPage = new InscriptionIHM(this);
		setContentPane(inscriptionPage);
		pack();
	}
	
	public void pageAbonnement(){
		abonnementPage = new AbonnementChoiceIHM(this);
		setContentPane(abonnementPage);
		pack();
	}
	
	public static void main(String[] args) {
		System.out.println("coucou toi^^");
		System.out.println("�a va ?^^");
		System.out.println("ouais et toi ?^^");
		System.out.println("top d�lire ?^^");
		Client client = new Client();
		sqlback = new Interpreteur();
	}
}
