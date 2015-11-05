package Data;

public class Folder {
	public int getRefFolder() {
		return refFolder;
	}

	public void setRefFolder(int refFolder) {
		this.refFolder = refFolder;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public float getFolderWeight() {
		return folderWeight;
	}

	public void setFolderWeight(float folderWeight) {
		this.folderWeight = folderWeight;
	}

	public int getFolderComponentsNumber() {
		return folderComponentsNumber;
	}

	public void setFolderComponentsNumber(int folderComponentsNumber) {
		this.folderComponentsNumber = folderComponentsNumber;
	}

	int refFolder;
	String folderName;
	float folderWeight;
	int folderComponentsNumber;
	
	public Folder(){
	}
	

}
