import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

public class MoyenPaiementIHM extends JPanel implements ActionListener {
	private Client client;
	private JButton OKButton;
	private JList<String> mdpList;
	private String mdpChoice;
	Dimension fenSize = new Dimension(300,200);
	
	public MoyenPaiementIHM(Client client){
		this.client = client;
		this.client.setPreferredSize(fenSize);
		this.setPreferredSize(fenSize);
//TODO ajouter une image au login

		Vector<String> names = new Vector<String>();
		names.addElement("Carte Bancaire");
		names.addElement("Paypal");
		names.addElement("Pr�l�vement Automatique");
		mdpList = new JList<String>(names);
		this.add(mdpList);
		OKButton = new JButton("OK");
		OKButton.addActionListener(this);
		this.add(OKButton);
		this.client.pack();
	}
	
	public void actionPerformed(ActionEvent evnt) {
		Object s = evnt.getSource();
		if(s == OKButton){
// enregistrement de l'abonnement choisi
			java.util.Date currentDate = new Date();
			java.sql.Date sqlDate = (java.sql.Date) new Date(currentDate.getTime());
			mdpChoice = mdpList.getSelectedValue();
			client.currentUser.setMdp(mdpChoice);
			client.currentUser.setSubStart(sqlDate);
			client.currentUser.setSubSize(30);
			client.currentUser.setLastCo(sqlDate);
//TODO enregistrer l'objet user dans la base
			System.out.println(mdpChoice + " connexion..."); 
			client.infoBox("Votre inscription a bien �t� enregistr�e et vous allez �tre redirig� vers votre page d'accueil", "Inscription compl�te");
			client.pageMain();
		}
	}
}
