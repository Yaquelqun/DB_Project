package Data;

public class User {
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLogin() {
		return userName;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPsw() {
		return userName;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}
	
	public String getSIRET() {
		return SIRET;
	}

	public void setSIRET(String SIRET) {
		this.SIRET = SIRET;
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public String getSub() {
		return subName;
	}

	public void setSub(String subName) {
		this.subName = subName;
	}
	
	public int getRefUser() {
		return refUser;
	}

	public void setRefUser(int refUser) {
		this.refUser = refUser;
	}
	
	public int getLastCo() {
		return lastCo;
	}

	public void setLastCo(int lastCo) {
		this.lastCo = lastCo;
	}
	
	public int getMAchNb() {
		return machineNb;
	}

	public void setMachNb(int machNb) {
		this.machineNb = machNb;
	}
	
	public int getSubStart() {
		return subStart;
	}

	public void setSubStart(int subStart) {
		this.subStart = subStart;
	}
	
	public int getSubSize() {
		return subSize;
	}

	public void setSubSize(int subSize) {
		this.subSize = subSize;
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
