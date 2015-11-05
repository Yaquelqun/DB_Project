import java.net.* ;
import javax.swing.*;
import java.io.* ; 
import Data.Sub;
import Data.User;
import Data.Company;

public class Client extends JFrame  {

	static Interpreteur sqlback;
	public Sub subChoice;
	public User currentUser;
	public Company currentCompany;
	
	
	public Client() {
		//IHM
		LoginIHM loginPage = new LoginIHM(this);
		setContentPane(loginPage);
		//affichage interface
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		currentUser = new User();
		currentCompany = new Company();
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
	
	public void pageCorpSub(){
		CorporateSubIHM corpSubPage = new CorporateSubIHM(this);
		setContentPane(corpSubPage);
		pack();
	}
	
	public void pageMain(){
		BrowsingFoldersIHM foldPage = new BrowsingFoldersIHM(this);
		setContentPane(foldPage);
		pack();
	}
	
	public void infoBox(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	
	public static void main(String[] args) {

		Client client = new Client();
		sqlback = new Interpreteur();
	}
}
