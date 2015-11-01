import java.sql.*;

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
}
