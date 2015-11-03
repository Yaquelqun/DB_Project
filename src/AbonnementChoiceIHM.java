import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AbonnementChoiceIHM extends JPanel implements ActionListener {
	private Client client;
	private JButton OKButton;
	private JList<String> subList;
	private String subChoice;
	private Vector<String> availableSubs;
	Dimension fenSize = new Dimension(300,200);
	
	public AbonnementChoiceIHM(Client client){
		this.client = client;
		this.client.setPreferredSize(fenSize);
		this.setPreferredSize(fenSize);
//TODO ajouter une image au login

		availableSubs = client.sqlback.getSubs();
		for( int i=0; i< availableSubs.size(); i++)
		{
			System.out.println(availableSubs.get(i));
		}

		subList = new JList<String>(availableSubs);
		this.add(subList);
		OKButton = new JButton("OK");
		OKButton.addActionListener(this);
		this.add(OKButton);
		this.client.pack();
	}
	
	public void actionPerformed(ActionEvent evnt) {
		Object s = evnt.getSource();
		if(s == OKButton){
//TODO enregistrement de l'abonnement choisi
			//subChoice = loginEnter.getText();
			System.out.println(subChoice + " connexion..."); 
//TODO cr�ation de compte main et changement de panel via fonction main 
		}

	}
}
