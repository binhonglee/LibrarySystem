package libsys;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;

/**
 * Test BookFactory related operations
 */
public class BookFactoryTest extends TestCase
{
    private BookFactory bookFactory;

    /**
     * Test BookFactory related operations
     * @param testName name of the test case
     */
    public BookFactoryTest(String testName)
    {
        super(testName);
    }

    /**
     * @return suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(BookFactoryTest.class);
    }

    /**
     * Set up before testing
     * @throws Exception Exception
     */
    public void setUp() throws Exception
    {
        super.setUp();
        bookFactory = new BookFactory();
        bookFactory.setBookFileName("testBookFactory.json");
    }

    /**
     * Run all tests
     */
    public void testApp()
    {
        newBookTest();
        outputAndInputTest();
        exceptionTest();
    }

    /**
     * Test the newBook function
     */
    private void newBookTest()
    {
        Book book1 = bookFactory.newBook("Whole new Book", "AVAILABLE");
        assertTrue("Book ID is 0", book1.getId() == 0);
        assertTrue("Book title is \"Whole new Book\"", book1.getTitle().equals(bookFactory.getBook(0).getTitle()));
        assertTrue("Book status is \"AVAILABLE\"", book1.getStatus().equals(bookFactory.getBook(0).getStatus()));
        assertTrue("Comparing Book with to the Book in BookFactory", bookFactory.getBook(0).equals(book1));
    }

    /**
     * Test the class in writing to and reading from files
     */
    private void outputAndInputTest()
    {
        String filename = ".";
        bookFactory.setBookFileName(filename);
        bookFactory.toJsonFile();
        assertFalse("File does not exist", (new File(filename)).exists() && !(new File(filename).isDirectory()));
        filename = "someTestFile.json";
        bookFactory.setBookFileName(filename);
        bookFactory.toJsonFile();
        BookFactory newBookFactory = new BookFactory(filename);
        assertTrue("newBookFactory : Book title is \"Whole new Book\"", newBookFactory.getBook(0).getTitle().equals("Whole new Book"));
        assertEquals("newBookFactory : Book id is 0", newBookFactory.getBook("Whole new Book").getId(), 0);
        assertTrue("newBookFactory : Book status is \"AVAILABLE\"", newBookFactory.getBook(0).getStatus().equals("AVAILABLE"));
    }

    /**
     * Test exception cases and error handling of the class
     */
    private void exceptionTest()
    {
        BookFactory anotherBookFactory = new BookFactory("noSuchFile.json");
        assertTrue("Check ID for new Book of non-existent import file", anotherBookFactory.newBook("Some book", "NOT AVAILABLE").getId() == 0);

        try
        {
            anotherBookFactory.getBook(20);
            assert false;
        }
        catch (Exception e)
        {
            assert true;
        }

        try
        {
            Book someBook = new Book(20);
            Book anotherBook = someBook;
            anotherBookFactory.update(someBook, anotherBook);
            assert false;
        }
        catch (Exception e)
        {
            assert true;
        }

        try
        {
            anotherBookFactory.getBook(12);
            assert false;
        }
        catch (Exception e)
        {
            assert true;
        }
    }

    /**
     * Delete files created during test
     * @throws Exception Exception
     */
    public void tearDown() throws Exception
    {
        super.tearDown();
        File file = new File("noSuchFile.json");
        if(!file.delete())
        {
            System.out.println("noSuchFile.json is not found / deleted");
        }

        file = new File("someTestFile.json");
        if(!file.delete())
        {
            System.out.println("someTestFile.json is not found / deleted");
        }

        file = new File("testBookFactory.json");
        if(!file.delete())
        {
            System.out.println("testBookFactory.json is not found / deleted");
        }
    }
}
