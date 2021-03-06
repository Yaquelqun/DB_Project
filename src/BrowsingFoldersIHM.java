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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Data.Folder;

public class BrowsingFoldersIHM extends JPanel implements ActionListener, ListSelectionListener {
	
	private Client client;
	private JPanel panelBrowse, panelInfos, panelButton, panelManagement;
	private JButton shareButton, suppButton, syncButton, newButton;
	private JTextArea infoArea;
	private JList<String> folderNamesList;
	private Vector<String> folderNamesVector;
	private Vector<Folder> folderList;
	private String folderSelected;
	Dimension fenSize = new Dimension(900,600), infoSize = new Dimension(200,300), manageSize = new Dimension(200, 600), browseSize = new Dimension(600, 600);
	
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
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		panelInfos = new JPanel();
		panelInfos.setPreferredSize(infoSize);
		infoArea = new JTextArea();
		infoArea.setEditable(false);
		infoArea.setPreferredSize(infoSize);
		panelInfos.add(infoArea);
		panelManagement.add(panelInfos);
		
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
		panelManagement.add(panelButton);
	}

	private void creaPanelBrowse() {
		// TODO Auto-generated method stub
		panelBrowse.setPreferredSize(browseSize);
		folderList = client.sqlback.getUserFolder(client.currentUser.getRefUser());
		folderNamesVector = new Vector<String>();
		for( int i=0; i< folderList.size(); i++)
		{
			folderNamesVector.add(folderList.get(i).getFolderName());
		}

		folderNamesList = new JList<String>(folderNamesVector);
		folderNamesList.setPreferredSize(browseSize);
		folderNamesList.addListSelectionListener(this);
		panelBrowse.add(folderNamesList);
		
	}

	public void actionPerformed(ActionEvent evnt) {
		Object s = evnt.getSource();
		if(s == newButton){
			client.pageAddFolder();
		}
		if(s == shareButton){
			if(folderNamesList.getSelectedValue()!=null){
			folderSelected = folderNamesList.getSelectedValue();
			int indexChoice = folderNamesList.getSelectedIndex();
			Folder tmpFolder = new Folder();
			tmpFolder = folderList.get(indexChoice);
			client.pageShareFolder(tmpFolder.getRefFolder());
			}
			else client.infoBox("veuillez s�lectionner un Dossier a partager", "erreur");
		}
		if (s==suppButton){
			if(folderNamesList.getSelectedValue()!=null){
				folderSelected = folderNamesList.getSelectedValue();
				int indexChoice = folderNamesList.getSelectedIndex();
				Folder tmpFolder = new Folder();
				tmpFolder = folderList.get(indexChoice);
				client.sqlback.removeFolder(tmpFolder.getRefFolder(), client.currentUser.getMail());
				client.infoBox("Le dossier a bien �t� supprim�", "youpi");
				client.pageMain();
				
				}
				else client.infoBox("veuillez s�lectionner un Dossier a supprimer", "erreur");
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		folderSelected = folderNamesList.getSelectedValue();
		//TODO afficher les infos du dossier
	}

}
