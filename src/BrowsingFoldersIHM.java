import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BrowsingFoldersIHM extends JPanel implements ActionListener {
	
	private Client client;
	private JPanel panelBrowse, panelInfos, panelButton, panelManagement;
	private JButton shareButton, suppButton, syncButton, newButton;
	private JTextArea infoArea;
	private JList<String> mdpList;
	private String mdpChoice;
	Dimension fenSize = new Dimension(800,600), infoSize = new Dimension(200,300), manageSize = new Dimension(200, 600), browseSize = new Dimension(600, 600);
	
	public BrowsingFoldersIHM(Client client){
		this.client = client;
		this.client.setPreferredSize(fenSize);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setPreferredSize(fenSize);
		panelBrowse = new JPanel();
		creaPanelBrowse();
		this.add(panelBrowse);
		panelManagement = new JPanel();
		creaPanelManagement();
		this.add(panelManagement);
		this.client.pack();
	}

	private void creaPanelManagement() {
		// TODO Auto-generated method stub
		panelManagement.setPreferredSize(manageSize);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		panelInfos = new JPanel();
		panelInfos.setPreferredSize(infoSize);
		infoArea = new JTextArea();
		infoArea.setPreferredSize(infoSize);
		panelInfos.add(infoArea);
		this.add(panelInfos);
		
		panelButton = new JPanel();
		panelButton.setPreferredSize(infoSize);
		panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.Y_AXIS));
		newButton = new JButton("Nouveau Dossier");
		newButton.addActionListener(this);
		panelButton.add(newButton);
		shareButton = new JButton("Partager le Dossier");
		shareButton.addActionListener(this);
		panelButton.add(shareButton);
		syncButton = new JButton("Synchroniser le Dossier");
		syncButton.addActionListener(this);
		panelButton.add(syncButton);
		suppButton = new JButton("Supprimer le Dossier");
		suppButton.addActionListener(this);
		panelButton.add(suppButton);
		this.add(panelButton);
	}

	private void creaPanelBrowse() {
		// TODO Auto-generated method stub
		panelBrowse.setPreferredSize(browseSize);
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
