import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Data.Sub;

public class AbonnementChoiceIHM extends JPanel implements ActionListener {
	private Client client;
	private JButton OKButton;
	private JList<String> subList;
	private String subChoice;
	private Vector<Sub> availableSubs;
	Dimension fenSize = new Dimension(300,200);
	
	public AbonnementChoiceIHM(Client client){
		this.client = client;
		this.client.setPreferredSize(fenSize);
		this.setPreferredSize(fenSize);
//TODO ajouter une image au login

		availableSubs = client.sqlback.getSubs();
		Vector<String> names = new Vector<String>();
		for( int i=0; i< availableSubs.size(); i++)
		{
			names.add(availableSubs.get(i).getSubName());
		}

		subList = new JList<String>(names);
		this.add(subList);
		OKButton = new JButton("OK");
		OKButton.addActionListener(this);
		this.add(OKButton);
		this.client.pack();
	}
	
	public void actionPerformed(ActionEvent evnt) {
		Object s = evnt.getSource();
		if(s == OKButton){
// enregistrement de l'abonnement choisi
			subChoice = subList.getSelectedValue();
//TODO récupérer les carac de l'abonnement choisi pour l'enregistrer dans un objet sub
			System.out.println(subChoice + " connexion..."); 
//TODO affichage de la derniere page (choix moyen de paiement + si entreprise enregistrement)
			if(subChoice.equals("Corporate")){
				System.out.println(subChoice + " connexion..."); 
			}
			else{
				client.pageMdp();
			}
		}
	}
}
