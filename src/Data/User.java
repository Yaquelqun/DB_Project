package Data;
import java.util.*;

import java.sql.Date;

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
	
	public Date getLastCo() {
		return lastCo;
	}

	public void setLastCo(Date currentDate) {
		this.lastCo = currentDate;
	}
	
	public int getMAchNb() {
		return machineNb;
	}

	public void setMachNb(int machNb) {
		this.machineNb = machNb;
	}
	
	public Date getSubStart() {
		return subStart;
	}

	public void setSubStart(Date subStart) {
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
 Date lastCo;
 int machineNb;
 Date subStart;
 int subSize;
 
 public User(){
	 
 }
 
 public User(String userName, String login, String psw, String SIRET, String mail, String mdp, String subName, int refUser, Date lastCo, int machineNb, Date subStart, int subSize){
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
