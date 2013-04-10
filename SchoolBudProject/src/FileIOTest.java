import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;


/**
* TODO Put here a description of what this class does.
*
* @author padillbt.
* Created Mar 20, 2013.
*/
public class FileIOTest {

@Test
public void testJUnit() throws IOException {
assertTrue("Testing JUnit", true);
}

@Test
public void testFileIOInitializes() throws IOException{
FileIO temp = new FileIO("username");
assertNotNull(temp);
}

@Test
public void testFileIOInitializesWithNumbers() throws IOException{
FileIO temp = new FileIO("1234567890");
assertNotNull(temp);
}

@Test
public void testFileIOInitializesWithSpecialCharacters() throws IOException{
FileIO temp = new FileIO("!@#$%^&(");
assertNotNull(temp);
}

@Test(expected = IllegalArgumentException.class)
public void testFileintializesException() throws IOException{
FileIO temp = new FileIO("");
}

@Test
public void testcreateFileTrue() throws IOException{
FileIO temp = new FileIO("username");
assertTrue(temp.createFile());
}

@Test
public void testcreateFileFalse() throws IOException{
FileIO temp = new FileIO("username");
assertFalse(temp.createFile());	
}

@Test
public void testcreateFileWithNumbersForName() throws IOException{
FileIO temp = new FileIO("1234567890");
assertTrue(temp.createFile());
}

@Test
public void testcreateFileWithSpecialCharsForName1() throws IOException{
FileIO temp = new FileIO("!");
assertTrue(temp.createFile());
}

@Test
public void testcreateFileWithSpecialCharsForName2() throws IOException{
FileIO temp = new FileIO("@");
assertTrue(temp.createFile());
}

@Test
public void testcreateFileWithSpecialCharsForName3() throws IOException{
FileIO temp = new FileIO("#");
assertTrue(temp.createFile());
}

@Test(expected = IllegalArgumentException.class)
public void testcreateFileWithSpecialCharsForName4() throws IOException{
FileIO temp = new FileIO("*");
}

@Test
public void testWriteToFile() throws IOException{
FileIO temp = new FileIO("test0");
temp.createFile();
temp.writeFile("testing");
}

@Test(expected = IOException.class)
public void testWriteToFileException() throws IOException{
FileIO temp = new FileIO("test1");
temp.createFile();
temp.writeFile("testing1");
temp.writeFile("testing2");
}

@Test
public void testReadFile() throws IOException{
FileIO temp = new FileIO("test");
temp.createFile();
temp.writeFile("testing");
assertEquals("testing", temp.readFile());
}

@Test(expected = IOException.class)
public void testReadFileException() throws IOException{
FileIO temp = new FileIO("test2");
temp.createFile();
temp.writeFile("testing2");
temp.readFile();
temp.readFile();
}

@Test
public void testGetFileNameTrue() throws IOException{
FileIO temp = new FileIO("username");
assertEquals("username.txt", temp.getFileName());
}

@Test
public void testGetFileNameFalse() throws IOException{
FileIO temp = new FileIO("username");
assertNotSame("username", temp.getFileName());
}

}