package Data;

public class User {
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getTotSize() {
		return totSize;
	}

	public void setTotSize(int totSize) {
		this.totSize = totSize;
	}

	public int getMachineMax() {
		return machineMax;
	}

	public void setMachineMax(int machineMax) {
		this.machineMax = machineMax;
	}

	public int getSharedFolderMax() {
		return sharedFolderMax;
	}

	public void setSharedFolderMax(int sharedFolderMax) {
		this.sharedFolderMax = sharedFolderMax;
	}

	public int getShareUserMax() {
		return shareUserMax;
	}

	public void setShareUserMax(int shareUserMax) {
		this.shareUserMax = shareUserMax;
	}

	public int getSubPrice() {
		return subPrice;
	}

	public void setSubPrice(int subPrice) {
		this.subPrice = subPrice;
	}

String userName;
 int totSize;
 int machineMax;
 int sharedFolderMax;
 int shareUserMax;
 int subPrice;
 
 public User(){
	 
 }
 
 public User(String name, int totsize, int machinemas, int sharedfoldermax, int shareusermax,int subprice){
	 this.subName = name;
	 this.totSize = totsize; 
	 this.machineMax = machinemas;
	 this.sharedFolderMax = sharedfoldermax;
	 this.shareUserMax = shareusermax;
	 this.subPrice = subprice;
 }
}
