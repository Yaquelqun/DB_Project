package Data;

import java.sql.Date;

public class File {
	public int getRefFile() {
		return refFile;
	}

	public void setRefFile(int refFile) {
		this.refFile = refFile;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getRefFolder() {
		return refFolder;
	}

	public void setRefFolder(int refFolder) {
		this.refFolder = refFolder;
	}

	public float getFileSize() {
		return fileSize;
	}

	public void setFileSize(float fileSize) {
		this.fileSize = fileSize;
	}

	public Date getVerDate() {
		return verDate;
	}

	public void setVerDate(Date verDate) {
		this.verDate = verDate;
	}

	public String getFileVer() {
		return fileVer;
	}

	public void setFileVer(String fileVer) {
		this.fileVer = fileVer;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Date getLastModif() {
		return lastModif;
	}

	public void setLastModif(Date lastModif) {
		this.lastModif = lastModif;
	}

	int refFile;
	String fileName;
	int refFolder;
	float fileSize;
	Date verDate;
	String fileVer;
	String fileType;
	Date lastModif;
	
	public File(){}
	

}
