import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author padillbt. Created Mar 20, 2013.
 */
public class FileIO {
	private String fileName;
	private FileWriter writer;
	private File currentFile;
	private FileReader reader;

	/**
	 * TODO Put here a description of what this constructor does.
	 * 
	 * @param string
	 * @throws IOException
	 */
	public FileIO(String username) throws IOException {
		if (username.equals("")) {
			throw new IllegalArgumentException();
		}
		if (username.endsWith("*")) {
			throw new IllegalArgumentException();
		}
		this.fileName = username.concat(".txt");
	}

	/**
	 * TODO Put here a description of what this method does.
	 * 
	 * @return
	 * @throws IOException
	 * 
	 */
	public boolean createFile() throws IOException {
		this.currentFile = new File(this.fileName);
		if (this.currentFile.createNewFile()) {
			this.writer = new FileWriter(this.currentFile);
			this.reader = new FileReader(this.currentFile);
			return true;
		}
		return false;
	}

	/**
	 * TODO Put here a description of what this method does.
	 * 
	 * @return
	 */
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * TODO Put here a description of what this method does.
	 * 
	 * @param messege
	 * 
	 * @throws IOException
	 */
	public void writeFile(String messege) throws IOException {

		try {
			this.writer.write(messege);
			this.writer.flush();
			this.writer.close();
		} catch (Exception exception) {
			throw new IOException();
		}
	}

	/**
	 * TODO Put here a description of what this method does.
	 * 
	 * @return
	 * @throws IOException
	 * 
	 */
	public String readFile() throws IOException {
		char[] temp = new char[100];
		String messege = "";
		try {
			this.reader.read(temp);
			for (char a : temp) {
				if (a == '\u0000') {
					break;
				}
				messege += a;
			}
			this.reader.close();
		} catch (Exception exception) {
			throw new IOException();
		}

		return messege;
	}

}