package fr.esiea.log4esiea.handler;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements Handler {

	private String filename;
	private static int fileno = 1;
	private String fileExtension;
	private long maxSize; // en octets
	private boolean rotative;
	
	public FileHandler(String filename) {
		super();
		this.filename = filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public long getFileSize(File file) {
	    return file.length();
	}
	
	public long getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(long maxSize) {
		this.maxSize = maxSize;
	}

	public boolean isRotative() {
		return rotative;
	}

	public void setRotative(boolean rotative) {
		this.rotative = rotative;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = "." + fileExtension;
	}

	public void print(String message) {
		FileWriter writer = null;
		int messageSize = message.length();
		File file = new File(this.filename + this.fileno + this.fileExtension);
		if (this.rotative && this.getFileSize(file) + messageSize > this.maxSize) {
			this.fileno += 1;
		}
		message += "\n";
		try {
			if (this.rotative) {
				writer = new FileWriter(this.filename + this.fileno + this.fileExtension, true);
			}
			else {
				writer = new FileWriter(this.filename + this.fileExtension, true);
			}
			writer.write(message, 0, messageSize);
			writer.write("\r\n"); 
		} 
		catch (IOException ex) {
			ex.printStackTrace();
		} 
		finally {
			if (writer != null) {
				try {
					writer.close();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "FileAppender [filename=" + filename + ", fileExtension="
				+ fileExtension + ", maxSize=" + maxSize + ", rotative="
				+ rotative + "]";
	}
	
	
	
}
