import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class AjoutFolderIHM extends JPanel implements ActionListener {

	private Client client;
	private JButton OKButton;
	private JTextField nomFolderEnter;
	private String nomFolder;
	Dimension fenSize = new Dimension(300,200);
	
	public AjoutFolderIHM(Client client){
		this.client = client; 
		this.client.setPreferredSize(fenSize);
		this.setPreferredSize(fenSize);
		nomFolderEnter = new JTextField("Le nom du dossier",20);
		this.add(nomFolderEnter);
		OKButton = new JButton("Créer le dossier");
		OKButton.addActionListener(this);
		this.add(OKButton);
		this.client.pack();
	}
	
	public void actionPerformed(ActionEvent evnt) {
		Object s = evnt.getSource();
		if(s == OKButton){
			//enregistrement des données
			client.sqlback.addFolder(client.currentUser.getRefUser(), nomFolderEnter.getText());
			client.pageMain();
		}
	}
}
