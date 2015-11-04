import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

import com.sun.corba.se.impl.naming.pcosnaming.NameServer;

import Data.Sub;

public class AbonnementChoiceIHM extends JPanel implements ActionListener {
	private Client client;
	private JButton OKButton;
	private JTextField SIRETEnter;
	private JList<String> subList;
	private String subChoice;
	private Vector<Sub> availableSubs;
	private ListSelectionListener listenerCorporate;
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
		subList.addListSelectionListener(listenerCorporate);
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
			int indexChoice = subList.getSelectedIndex();
			client.subChoice = availableSubs.get(indexChoice);
			if(subChoice.equals("Corporate")){
				System.out.println("vérification présence entreprise..."); 
				boolean verifCompany = false;
				if(verifCompany == false){
					client.pageCorpSub();
				}
				else{
//TODO affichage de la derniere page (choix moyen de paiement + si entreprise enregistrement)
				}
			}
			else{
				client.pageMdp();
			}
		}
		if(s == listenerCorporate){
			subChoice = subList.getSelectedValue();
			if(subChoice.equals("Corporate")){
				SIRETEnter = new JTextField("Siret de votre entreprise");
				this.add(SIRETEnter);
				this.repaint();
			}
			else{
				SIRETEnter = new JTextField("Siret de votre entreprise");
				this.add(SIRETEnter);
				client.pack();
			}
		}
	}
}
