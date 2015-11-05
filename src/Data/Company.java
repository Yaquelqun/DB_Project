package Data;

public class Company {
<<<<<<< HEAD
 public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	 public String getSIRET() {
		return SIRET;
	}

	public void setSIRET(String SIRET) {
		this.SIRET = SIRET;
	}
	
	public String getFinanceMail() {
		return financeMail;
	}

	public void setFinanceMail(String financeMail) {
		this.financeMail = financeMail;
	}

	public int getEmplNb() {
		return employeeNb;
	}

	public void setEmplNb(int emplNb) {
		this.employeeNb = emplNb;
	}

String SIRET;
String companyName;
String financeMail;
int employeeNb;

 
 public Company(){
	 
 }
 
 public Company(String SIRET, String companyName, String financeMail,int employeeNb){
	 this.SIRET = SIRET;
	 this.companyName = companyName; 
	 this.financeMail = financeMail;
	 this.employeeNb = employeeNb;
 }
=======
	
	public String getSIRET() {
		return SIRET;
	}
	public void setSIRET(String sIRET) {
		SIRET = sIRET;
	}
	public int getEmployeeNb() {
		return employeeNb;
	}
	public void setEmployeeNb(int employeeNb) {
		this.employeeNb = employeeNb;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getFianceMail() {
		return fianceMail;
	}
	public void setFianceMail(String fianceMail) {
		this.fianceMail = fianceMail;
	}
	String SIRET;
	int employeeNb;
	String companyName;
	String fianceMail;
	public Company(){
		
	}

>>>>>>> refs/remotes/origin/integration
}
