import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ShareUserIHM extends JPanel implements ActionListener {

	private Client client;
	private JButton OKButton;
	private JTextField mailUserEnter;
	private int refFolder;
	Dimension fenSize = new Dimension(300,200);
	
	public ShareUserIHM(Client client, int refFolder){
		this.refFolder = refFolder;
		this.client = client; 
		this.client.setPreferredSize(fenSize);
		this.setPreferredSize(fenSize);
		mailUserEnter = new JTextField("Le mail de l'utilisateur",20);
		this.add(mailUserEnter);
		OKButton = new JButton("Partager le dossier");
		OKButton.addActionListener(this);
		this.add(OKButton);
		this.client.pack();
	}
	
	public void actionPerformed(ActionEvent evnt) {
		Object s = evnt.getSource();
		if(s == OKButton){
			//enregistrement des données
			client.sqlback.shareFolder(refFolder, mailUserEnter.getText());
			client.pageMain();
		}
	}
}
