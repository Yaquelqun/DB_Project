import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Data.Company;

public class CorporateSubIHM extends JPanel implements ActionListener {

	private Client client;
	private JButton OKButton;
	private JTextField SIRETEnter, mailEnter, nomEnter, nbEnter;
	//TODO passer les psw en private ou protected et faire les fonctions de récup des données en sécurisé
	private String SIRET, nomCompany, financeMail;
	private int nbEmployee;
	Dimension fenSize = new Dimension(300,200);
	
	public CorporateSubIHM(Client client) {
		this.client = client; 
		this.client.setPreferredSize(fenSize);
		this.setPreferredSize(fenSize);
//TODO ajouter une image inscription
		SIRETEnter = new JTextField("SIRET de l'entreprise",20);
		this.add(SIRETEnter);
		nomEnter = new JTextField("Nom de l'entreprise",20);
		this.add(nomEnter);
		mailEnter = new JTextField("Mail de votre financier",20);
		this.add(mailEnter);
		nbEnter = new JTextField("Nombre d'employés de l'entreprise",20);
		this.add(nbEnter);
		OKButton = new JButton("Se connecter");
		OKButton.addActionListener(this);
		this.add(OKButton);
		this.client.pack();
	}
	
	public void actionPerformed(ActionEvent evnt) {
		Object s = evnt.getSource();
		if(s == OKButton){
			//enregistrement des données
			nomCompany = nomEnter.getText();
			financeMail = mailEnter.getText();
			SIRET = SIRETEnter.getText();
			nbEmployee = Integer.parseInt(nbEnter.getText());
			client.currentCompany.setSIRET(SIRET);
			client.currentCompany.setCompanyName(nomCompany);
			client.currentCompany.setFinanceMail(financeMail);
			client.currentCompany.setEmplNb(1);
//TODO enregistrement de la companie dans la base de donnée
			client.pageMdp();
		}
	}
}
