package libsys;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;

/**
 * Test Settings related operations
 */
public class SettingsTest extends TestCase
{
    private Settings settings;

    /**
     * Test Settings related operations
     * @param testName name of the test case
     */
    public SettingsTest(String testName)
    {
        super(testName);
    }

    /**
     * @return suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(SettingsTest.class);
    }

    /**
     * Run all tests
     */
    public void testApp()
    {
        constructorTest();
        setUsersFilenameTest();
        setBooksFilenameTest();
    }

    /**
     * Test the constructor
     */
    private void constructorTest()
    {
        settings = new Settings(".");
        settings.setTitle("Failed to save");
        File file = new File(".");
        if (file.exists() && !file.isDirectory())
        {
            assert false;
        }
        else
        {
            assert true;
        }
        String filename = "noSuchFile.txt";
        file = new File(filename);
        if (file.exists())
        {
            file.delete();
        }
        settings = new Settings(filename);
        assertEquals("Default size is 3", settings.size(), 3);
        assertEquals("Default title", settings.get(settings.getKey(0)), "Welcome to the library");
        assertEquals("Default users filename", settings.get(settings.getKey(1)), "users.json");
        assertEquals("Default books filename", settings.get(settings.getKey(2)), "books.json");
        settings.setTitle("noSuchFile");
        assertTrue("noSuchFile.txt is created", file.exists());
        settings = new Settings(filename);
        assertEquals("Default title", settings.get(settings.getKey(0)), "noSuchFile");
    }

    /**
     * Test the setUsersFilename function
     */
    private void setUsersFilenameTest()
    {
        String newUsersFilename = "newUsersFilename";
        settings.setUsersFilename(newUsersFilename);
        assertEquals("Set settings usersFilename to \"newUsersFilename\"", settings.get(settings.getKey(1)), newUsersFilename);
    }

    /**
     * Test the setBooksFilename function
     */
    private void setBooksFilenameTest()
    {
        String newBooksFilename = "newBooksFilename";
        settings.setBooksFilename(newBooksFilename);
        assertEquals("Set settings booksFilename to \"newBooksFilename\"", settings.get(settings.getKey(2)), newBooksFilename);
    }

    /**
     * Delete test files
     * @throws Exception Exception
     */
    public void tearDown() throws Exception
    {
        super.tearDown();
        File file = new File("noSuchFile.txt");
        if (!file.delete())
            System.out.println("noSuchFile.txt was not deleted");
    }
}
