import java.sql.*;
import java.util.Iterator;
import java.util.Vector;

import Data.*;

public class Interpreteur {

	Connection connec = null;
	Statement state = null;
	ResultSet res = null;
	String requete = null;
	
	private static void arret(String message) {
		System.err.println(message);
		System.exit(99);
	}
	
	public Interpreteur (){
		System.out.println("démarrage de l'interpréteur");
		// chargement du pilote
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e) {
					arret("Impossible de charger le pilote jdbc:odbc");
				}
				
				//connection a la base de donn�es
				try{
					connec = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","yaquelqun","renard");
				} catch (SQLException e){
					arret("Connection a la base de donnees impossible");
				}	
			System.out.println("interpréteur connecté");
	}
	
	public boolean checkLogin(String mail, String psw) throws Exception{
		
		//creation et execution de la requete
		System.out.println("creation et execution de la requ�te");
		requete = "SELECT psw FROM utilisateur WHERE mail = '"+mail+"'";
		System.out.println(requete);
		try {
			state = connec.createStatement();
			res = state.executeQuery(requete);
		} catch (SQLException e) {
			System.out.println("probleme requete");
			return false;
		}

		//parcours des donn�es retourn�es
		System.out.println("parcours des donn�es retourn�es");
		try {
			while (res.next()) {
				String result = res.getString(1);
				if( result.equals(psw))
				{
					System.out.println("Cet utilisateur existe");
					return true;
				}
			}
			
			System.out.println("utilisateur inconnu");
			return false;
		} catch (SQLException e) {
			arret(e.getMessage());
		}		
		return false ;
	}

	public Vector<Sub> getSubs() {

		requete = "SELECT * FROM sub";
		System.out.println(requete);
		Vector<Sub> sublist = new Vector<Sub>();
		try {
			state = connec.createStatement();
			res = state.executeQuery(requete);
		} catch (SQLException e) {
			System.out.println("probleme requete");
			return null;
		}

		//parcours des donn�es retourn�es
		System.out.println("parcours des donn�es retourn�es");
		try {
			while (res.next()) {
				Sub tmp = new Sub();
				tmp.setSubName(res.getString(1));
				tmp.setTotSize(res.getInt(2));
				tmp.setMachineMax(res.getInt(3));
				tmp.setSharedFolderMax(res.getInt(4));
				tmp.setShareUserMax(res.getInt(5));
				tmp.setSubPrice(res.getInt(6));
				sublist.add(tmp);
			}
			
		} catch (SQLException e) {
			arret(e.getMessage());
		}		
		return sublist;
	}

	public boolean UserCheck(String mail)
	{
		requete = ("SELECT mail FROM utilisateur where mail ='"+mail+"'");
		Vector<Sub> sublist = new Vector<Sub>();
		try {
			state = connec.createStatement();
			res = state.executeQuery(requete);
		} catch (SQLException e) {
			System.out.println("probleme requete");
			return false;
		}
		
		try {
			if (!res.next())
			{
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean verifCompany(String Siret){
		System.out.println("creation et execution de la requ�te");
		requete = "SELECT companyname FROM company WHERE siret = '"+Siret+"'";
		try {
			state = connec.createStatement();
			res = state.executeQuery(requete);
		} catch (SQLException e) {
			System.out.println("probleme requete");
			return false;
		}

		try {
			if(res.next() == false) return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public void ajoutUser(User mec){
		String requete = "INSERT INTO utilisateur VALUES ('"+mec.getUserName()+"','"+mec.getLogin()+"','"+mec.getPsw()+"',"+mec.getRefUser()+",'"+mec.getSIRET()+"',TO_DATE('"+mec.getLastCo()+"','YYYY-MM-DD'),'"+mec.getMail()+"','"+mec.getSub()+"',"+mec.getMAchNb()+",TO_DATE('"+mec.getSubStart()+"','YYYY-MM-DD'),"+mec.getSubSize()+",'"+mec.getMdp()+"')";
		System.out.println(requete);
		try {
			state= connec.createStatement();
			int nbMaj = state.executeUpdate(requete);
			System.out.println("nb mise a jour = "+nbMaj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ajoutCompany(Company societe){
		String requete = "INSERT INTO utilisateur VALUES ('"+societe.getSIRET()+"',"+societe.getEmplNb()+",'"+societe.getCompanyName()+"','"+societe.getFinanceMail()+"')";
		try {
			state= connec.createStatement();
			int nbMaj = state.executeUpdate(requete);
			System.out.println("nb mise a jour = "+nbMaj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Vector<Folder> getUserFolder(int refUser) {

		requete = "select * from folder,groupe where groupe.REFUSER = "+refUser+" and groupe.REFFOLDER = folder.REFFOLDER ";
		System.out.println(requete);
		Vector<Folder> folderList = new Vector<Folder>();
		try {
			state = connec.createStatement();
			res = state.executeQuery(requete);
		} catch (SQLException e) {
			System.out.println("probleme requete");
			return null;
		}

		//parcours des donn�es retourn�es
		System.out.println("parcours des donn�es retourn�es");
		try {
			while (res.next()) {
				Folder tmp = new Folder();
				tmp.setRefFolder(res.getInt(1));
				tmp.setFolderName(res.getString(2));
				folderList.add(tmp);
			}
			
			for (int i=0;i<folderList.size();i++){
				int weight = 0;
				int number =0;
				requete = "select filesize from fichier where REFFOLDER ="+folderList.get(i).getRefFolder();
				state = connec.createStatement();
				res = state.executeQuery(requete);
				while (res.next()) {
					number++;
					weight+=res.getFloat(1);
				}
				folderList.get(i).setFolderComponentsNumber(number);
				folderList.get(i).setFolderWeight(weight);
			}
			
		} catch (SQLException e) {
			arret(e.getMessage());
		}
		
		
		return folderList;
	}

	public Vector<File> getFolderFiles(int refFolder) {

		requete = "SELECT * FROM fichier where reffolder ="+refFolder;
		System.out.println(requete);
		Vector<File> fileList = new Vector<File>();
		try {
			state = connec.createStatement();
			res = state.executeQuery(requete);
		} catch (SQLException e) {
			System.out.println("probleme requete");
			return null;
		}

		//parcours des donn�es retourn�es
		System.out.println("parcours des donn�es retourn�es");
		try {
			while (res.next()) {
				File tmp = new File();
				tmp.setRefFile(res.getInt(1));
				tmp.setFileName(res.getString(2));
				tmp.setRefFolder(res.getInt(3));
				tmp.setFileSize(res.getFloat(4));
				tmp.setVerDate(res.getDate(5));
				tmp.setFileVer(res.getString(6));
				tmp.setFileType(res.getString(7));
				fileList.add(tmp);
			}
			
		} catch (SQLException e) {
			arret(e.getMessage());
		}		
		return fileList;
	}
	
	public User getUser(String mail) {

		User tmp = new User();
		requete = "SELECT * FROM utilisateur where mail ="+mail;
		System.out.println(requete);
		try {
			state = connec.createStatement();
			res = state.executeQuery(requete);
		} catch (SQLException e) {
			System.out.println("probleme requete");
			return null;
		}

		//parcours des donn�es retourn�es
		System.out.println("parcours des donn�es retourn�es");
		try {
			while (res.next()) {

				tmp.setUserName(res.getString(1)); 
				tmp.setLogin(res.getString(2));
				tmp.setPsw(res.getString(3));
				tmp.setRefUser(res.getInt(4));
				tmp.setSIRET(res.getString(5));
				tmp.setLastCo(res.getDate(6));
				tmp.setMail(res.getString(7));
				tmp.setSub(res.getString(8));
				tmp.setMachNb(res.getInt(9));
				tmp.setSubStart(res.getDate(10));
				tmp.setSubSize(res.getInt(11));
				tmp.setMdp(res.getString(12));
			}
			
		} catch (SQLException e) {
			arret(e.getMessage());
		}		
		return tmp;
	}
}
