import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author padillbt. Created Mar 26, 2013.
 */
public class ParserTest {

	@Test
	public void testJUnit() {
		assertTrue("Testing JUnit", true);
	}

	@Test
	public void testFileParserInitialize() throws IOException {
		FileParser parse = new FileParser();
		assertNotNull(parse);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParserIntializesException() throws IOException {
		FileParser parse = new FileParser();
		parse.createFile("");}

	@Test
	public void testCreateFile() throws IOException {
		FileParser parse = new FileParser();
		File toBeDeleted = new File("test2.txt");
		assertTrue(parse.createFile("test2.txt"));
		toBeDeleted.delete();
	}

	@Test
	public void testCreateFileWithOnlyCharacters() throws IOException {
		FileParser parse = new FileParser();
		ArrayList<String> files = this.list("!.txt", "@.txt", "#.txt", "$.txt",
				"%.txt", "^.txt", "&.txt", "(.txt", ").txt", "-.txt");
		for (int i = 0; i < files.size(); i++) {
			File temp = new File(files.get(i));
			assertTrue(parse.createFile(files.get(i)));
			temp.delete();
		}
	}

	@Test
	public void testCreateFileWithOnlyCharacters2() throws IOException {
		FileParser parse = new FileParser();
		ArrayList<String> files = this.list("_.txt", "+.txt", "=.txt", "`.txt",
				"~.txt", "[.txt", "].txt", "{.txt", "}.txt");
		for (int i = 0; i < files.size(); i++) {
			File temp = new File(files.get(i));
			assertTrue(parse.createFile(files.get(i)));
			temp.delete();
		}
	}
	
	@Test
	public void testWriteFile() throws Exception{
		FileParser parse = new FileParser();
		ArrayList<String> data = this.list("A", "1", "B", "2");
		parse.createFile("test3.txt");
		File fileWrittenTo = new File("test3.txt");
		parse.writeFile("test3.txt", ";", data, 4);
		fileWrittenTo.delete();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWriteFileException() throws Exception {
		FileParser parse = new FileParser();
		ArrayList<String> data = this.list("A", "1", "B", "2");
		parse.createFile("test3.txt");
		parse.writeFile("test3.txt", " ", data, 5);}

	public ArrayList<String> list(String... words) {
		ArrayList<String> temp = new ArrayList<String>();
		for (String i : words) {
			temp.add(i);
		}
		return temp;
	}

}
