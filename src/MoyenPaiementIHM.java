import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		names.addElement("Prélèvement Automatique");
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
			mdpChoice = mdpList.getSelectedValue();
//TODO récupérer le moyen de paiement choisi pour l'enregistrer dans l'objet user
			System.out.println(mdpChoice + " connexion..."); 
//TODO message pop-up inscription complète + affichage client
		}
	}
}
