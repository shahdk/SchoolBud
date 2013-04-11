import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Assert;
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
	public void testFileParserInitialize() throws Exception {
		FileParser parse = new FileParser();
		assertNotNull(parse);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParserIntializesException() throws Exception {
		FileParser parse = new FileParser();
		parse.createFile("");}

	@Test
	public void testCreateFile() throws Exception {
		FileParser parse = new FileParser();
		File toBeDeleted = new File("test2.txt");
		assertTrue(parse.createFile("test2.txt"));
		toBeDeleted.delete();
	}

	@Test
	public void testCreateFileWithOnlyNumbers() throws Exception {
		FileParser parse = new FileParser();
		ArrayList<String> files = this.list("1.txt", "2.txt", "3.txt", "4.txt",
				"5.txt", "6.txt", "7.txt", "8.txt", "9.txt", "0.txt");
		for (int i = 0; i < files.size(); i++) {
			File temp = new File(files.get(i));
			assertTrue(parse.createFile(files.get(i)));
			temp.delete();
		}
	}

	@Test(expected = IOException.class)
	public void testCreateFileWithAsteriscException() throws Exception {
		FileParser parse = new FileParser();
		parse.createFile("*.txt");}
	
	@Test(expected = IOException.class)
	public void testCreateFileWithPipeException() throws Exception {
		FileParser parse = new FileParser();
		parse.createFile("|.txt");}
	
	@Test(expected = IOException.class)
	public void testCreateFileWithQuestionMarkException() throws Exception {
		FileParser parse = new FileParser();
		parse.createFile("?.txt");}

	@Test
	public void testCreateFileWithOnlyCharacters() throws Exception {
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
	public void testCreateFileWithOnlyCharacters2() throws Exception {
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
	public void testWriteFile() throws Exception {
		FileParser parse = new FileParser();
		ArrayList<String> data = this.list("A", "1", "B", "2");
		parse.createFile("test3.txt");
		File fileWrittenTo = new File("test3.txt");
		parse.writeFile("test3.txt", ";", data, 4);
		assertEquals(data, parse.readFile("test3.txt", ";", 4));
		fileWrittenTo.delete();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWriteFileException() throws Exception {
		FileParser parse = new FileParser();
		ArrayList<String> data = this.list("A", "1", "B", "2");
		parse.createFile("test4.txt");
		parse.writeFile("test4.txt", " ", data, 5);}

	@Test
	public void testReadFileConfig() throws Exception {
		FileParser parse = new FileParser();
		ArrayList<String> data = this.list("Rubric", "4", "Course", "5",
				"Quarter", "6");
		Assert.assertEquals(data, parse.readFile("config.txt", ";", 2));
	}

	@Test(expected = FileNotFoundException.class)
	public void testReadFileExceptionFileNotFound() throws Exception {
		FileParser parse = new FileParser();
		parse.readFile("nonExistent.txt", ";", 2);}

	@Test(expected = Exception.class)
	public void testReadFileExceptionImproperFile() throws Exception {
		FileParser parse = new FileParser();
		parse.readFile("improperFile.txt", ";", 2);}

	@Test
	public void testGetRubricSize() throws Exception {
		FileParser parse = new FileParser();
		assertEquals(parse.getRubricSize(), 4);
	}

	@Test
	public void testGetQuarterSize() throws Exception {
		FileParser parse = new FileParser();
		assertEquals(parse.getQuarterSize(), 6);
	}

	@Test
	public void testGetCourseSize() throws Exception {
		FileParser parse = new FileParser();
		assertEquals(parse.getCourseSize(), 5);
	}

	public ArrayList<String> list(String... words) {
		ArrayList<String> temp = new ArrayList<String>();
		for (String i : words) {
			temp.add(i);}
		return temp;
	}

}
