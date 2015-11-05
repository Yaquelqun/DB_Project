import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

public class BrowsingFoldersIHM extends JPanel implements ActionListener {
	
	private Client client;
	private JPanel panelBrowse, panelInfos, panelButton, panelManagement;
	private JButton shareButton;
	private JList<String> mdpList;
	private String mdpChoice;
	Dimension fenSize = new Dimension(300,200);
	
	public BrowsingFoldersIHM(Client client){
		this.client = client;
		this.client.setPreferredSize(fenSize);
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
		panelInfos = new JPanel();
		this.add(panelInfos);
		panelButton = new JPanel();
		this.add(panelButton);
	}

	private void creaPanelBrowse() {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
