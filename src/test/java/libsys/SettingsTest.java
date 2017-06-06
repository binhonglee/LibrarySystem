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
        setTitleTest();
        setUsersFilenameTest();
        setBooksFilenameTest();
    }

    /**
     * Test the constructor
     */
    private void constructorTest()
    {
        settings = new Settings("noSuchFile.txt");
        assertEquals("Default title", settings.get(settings.getKey(0)), "Welcome to the library");
        assertEquals("Default users filename", settings.get(settings.getKey(1)), "users.json");
        assertEquals("Default books filename", settings.get(settings.getKey(2)), "books.json");
    }

    /**
     * Test the setTitle function
     */
    private void setTitleTest()
    {
        String newTitle = "New Title";
        settings.setTitle(newTitle);
        assertEquals("Set settings title to \"New Title\"", settings.get(settings.getKey(0)), newTitle);
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
