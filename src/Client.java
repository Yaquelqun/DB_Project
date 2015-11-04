import java.net.* ;
import javax.swing.*;
import java.io.* ; 

public class Client extends JFrame  {

	static Interpreteur sqlback;
	
	
	public Client() {
		//IHM
		LoginIHM loginPage = new LoginIHM(this);
		setContentPane(loginPage);
		//affichage interface
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public void pageInscription(){
		InscriptionIHM inscriptionPage = new InscriptionIHM(this);
		setContentPane(inscriptionPage);
		pack();
	}
	
	public void pageAbonnement(){
		AbonnementChoiceIHM abonnementPage = new AbonnementChoiceIHM(this);
		setContentPane(abonnementPage);
		pack();
	}
	
	public void pageMdp(){
		MoyenPaiementIHM mdpPage = new MoyenPaiementIHM(this);
		setContentPane(mdpPage);
		pack();
	}
	
	public static void main(String[] args) {

		Client client = new Client();
		sqlback = new Interpreteur();
	}
}
