import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionListener;
import com.sun.corba.se.impl.naming.pcosnaming.NameServer;

import Data.Sub;

public class AbonnementChoiceIHM extends JPanel implements ActionListener,ListSelectionListener {
	private Client client;
	private JButton OKButton;
	private JTextField SIRETEnter;
	private JList<String> subList;
	private String subChoice;
	private Vector<Sub> availableSubs;
	private ListSelectionListener listenerCorporate;
	Dimension fenSize = new Dimension(300,200);
	private boolean pouet;

	public AbonnementChoiceIHM(Client client){
		this.client = client;
		this.client.setPreferredSize(fenSize);
		this.setPreferredSize(fenSize);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//TODO ajouter une image au login

		availableSubs = client.sqlback.getSubs();
		Vector<String> names = new Vector<String>();
		for( int i=0; i< availableSubs.size(); i++)
		{
			names.add(availableSubs.get(i).getSubName());
		}

		subList = new JList<String>(names);
		subList.addListSelectionListener(this);
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
				if(client.sqlback.verifCompany(subChoice)){
					client.currentUser.setSIRET(SIRETEnter.getText());
					client.pageCorpSub();
				}
				else{
					client.currentUser.setSub(subChoice);
					client.currentUser.setSIRET(SIRETEnter.getText());
					//TODO remplir la fin de User et l'enregistrer en BDD
					client.pageMain();
				}
			}
			else{
				client.currentUser.setSub(subChoice);
				client.currentUser.setSIRET("noComp");
				client.pageMdp();
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if (e.getValueIsAdjusting() == false) {

			if (subList.getSelectedIndex() == -1) {

			} else {
				if(subList.getSelectedValue().equals("corporate")){
					pouet = true;
					SIRETEnter = new JTextField("Siret de votre entreprise");
					this.add(SIRETEnter);
					this.repaint();
					this.client.pack();
				}
				else{
					if(pouet ==true){
						this.remove(SIRETEnter);

						this.repaint();
						this.client.pack();
					}
				}
			}
		}

	}
}
