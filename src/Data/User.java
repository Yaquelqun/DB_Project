package Data;

public class User {
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

String userName;
String login;
String psw;
String SIRET;
String mail;
String mdp;
String subName;
 int refUser;
 int lastCo;
 int machineNb;
 int subStart;
 int subSize;
 
 public User(){
	 
 }
 
 public User(String userName, String login, String psw, String SIRET, String mail, String mdp, String subName, int refUser, int lastCo, int machineNb, int subStart, int subSize){
	 this.userName = userName;
	 this.login = login;
	 this.psw = psw;
	 this.SIRET = SIRET;
	 this.mail = mail;
	 this.mdp = mdp;
	 this.subName = subName;
	  this.refUser = refUser;
	  this.lastCo = lastCo;
	  this.machineNb = machineNb;
	  this.subStart = subStart;
	  this.subSize = subSize;
 }
}
