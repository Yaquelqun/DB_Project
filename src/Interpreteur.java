import java.sql.*;
import java.util.Vector;

import Data.Company;
import Data.Sub;
import Data.User;

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
	
	public boolean checkLogin(String login, String psw) throws Exception{
		
		//creation et execution de la requete
		System.out.println("creation et execution de la requ�te");
		requete = "SELECT psw FROM utilisateur WHERE login = '"+login+"'";
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
		requete = ("SELECT * FROM utilisateur where mail ='"+mail+"'");
		Vector<Sub> sublist = new Vector<Sub>();
		try {
			state = connec.createStatement();
			res = state.executeQuery(requete);
		} catch (SQLException e) {
			System.out.println("probleme requete");
			return false;
		}

		try {
			if(res.next() == false) return true;
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
		String requete = "INSERT INTO utilisateur VALUES ('"+mec.getUserName()+"','"+mec.getLogin()+"','"+mec.getPsw()+"',"+mec.getRefUser()+",'"+mec.getSIRET()+"','"+mec.getLastCo()+"','"+mec.getMail()+"','"+mec.getSub()+"',"+mec.getMAchNb()+",'"+mec.getSubStart()+"',"+mec.getSubSize()+",'"+mec.getMdp()+"')";
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

}
