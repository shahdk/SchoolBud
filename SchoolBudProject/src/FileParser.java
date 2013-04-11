import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author padillbt. Created Mar 26, 2013.
 */
public class FileParser {
	private File currentFile;
	/**
	 * TODO Put here a description of what this constructor does.
	 * 
	 * @param string
	 * @throws IOException
	 */
	public FileParser() throws IOException {

	}

	/**
	 * TODO Put here a description of what this method does.
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public boolean createFile(String fileName) throws IOException {
		if (fileName.equals("")) {
			throw new IllegalArgumentException();
		}

		this.currentFile = new File(fileName);
		return this.currentFile.createNewFile();
	}

	/**
	 * TODO Put here a description of what this method does.
	 * 
	 * @param fileName
	 * @param delimiter
	 * @param string
	 * @param string2
	 * @param data
	 * @param length 
	 * @return
	 * @throws Exception
	 */
	public void writeFile(String fileName, String delimiter,
			ArrayList<String> data, int length) throws Exception {
		int count = 0;
		String line = "";
		this.createFile(fileName);
		if((data.size()%length) != 0){
			throw new IllegalArgumentException();
		}
		
		PrintWriter writer = new PrintWriter(new FileWriter(this.currentFile, true));
		for (int i = 0; i < data.size(); i++) {
			count++;
			if (count == length) {
				line += data.get(i);
				writer.println(line);
				count = 0;
				line = "";
			} else {
				line += data.get(i) + delimiter;
			}
		}
		writer.println(line);
		writer.close();
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param fileName
	 * @param delimiter
	 * @param length
	 * @return 
	 * @throws Exception 
	 */
	public ArrayList<String> readFile(String fileName, String delimiter, int length) throws Exception {
		Scanner inScanner = new Scanner(new File(fileName));
		ArrayList<String> dataFromFile = new ArrayList<String>();
		int count = 0;
		
		while(inScanner.hasNext()){
			String data = inScanner.next();
			String[] splitData = data.split(delimiter);
			
			for (int k = 0; k < splitData.length; k++){
				dataFromFile.add(splitData[k]);
				count++;
			}
			
			if(count == length){
				count = 0;
			}
		}
		
		if(count != 0){
			System.out.println(count);
			throw new Exception();
		}
		
		return dataFromFile;
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return
	 */
	public Object getRubricSize() {
		// TODO Auto-generated method stub.
		return null;
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return
	 */
	public Object getQuarterSize() {
		// TODO Auto-generated method stub.
		return null;
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return
	 */
	public Object getCourseSize() {
		// TODO Auto-generated method stub.
		return null;
	}
}