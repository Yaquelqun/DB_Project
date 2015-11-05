package Data;

public class Company {
	
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

}
