package Data;

public class Sub {
 public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
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

String subName;
 int totSize;
 int machineMax;
 int sharedFolderMax;
 int shareUserMax;
 int subPrice;
 
 public Sub(){
	 
 }
 
 public Sub(String name, int totsize, int machinemas, int sharedfoldermax, int shareusermax,int subprice){
	 this.subName = name;
	 this.totSize = totsize; 
	 this.machineMax = machinemas;
	 this.sharedFolderMax = sharedfoldermax;
	 this.shareUserMax = shareusermax;
	 this.subPrice = subprice;
 }
}
