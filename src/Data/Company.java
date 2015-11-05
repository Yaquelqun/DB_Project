package Data;

public class Company {

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
}
