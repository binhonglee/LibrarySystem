package libsys;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Test Book related operations
 */
public class BookTest extends TestCase
{
    private Book book1;
    private Book book2;

    /**
     * Test Book related operations
     * @param testName name of the test case
     */
    public BookTest(String testName)
    {
        super(testName);
    }

    /**
     * @return suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(BookTest.class);
    }

    /**
     * Run all tests
     */
    public void testApp()
    {
        valueTest();
        rentTest();
        returnTest();
        setTitlesTest();
        constructorTest();
    }

    /**
     * Set up before testing
     * @throws Exception Exception
     */
    public void setUp() throws Exception
    {
        super.setUp();
        book1 = new Book("Book1", 10, "AVAILABLE");
        book2 = new Book("Book2", 12, "NOT AVAILABLE");
    }

    /**
     * Test if the values are accurate
     */
    private void valueTest()
    {
        assertEquals("Title is \"Book1\"", book1.getTitle(), "Book1");
        assertEquals("Status is \"AVAILABLE\"", book1.getStatus(), "AVAILABLE");
        assertEquals("Book id is 10", book1.getId(), 10);
        assertEquals("Title is \"Book2\"", book2.getTitle(), "Book2");
        assertEquals("Status is \"NOT AVAILABLE\"", book2.getStatus(), "NOT AVAILABLE");
        assertEquals("Book id is 12", book2.getId(), 12);
    }

    /**
     * Test the rent(int[]) function functionality
     */
    private void rentTest()
    {
        int[] date = new int[]{2018, 10, 5};
        assertTrue("Rent should be successful", book1.rent(date));
        assertEquals("Book status is \"RENTED\"", book1.getStatus(), "RENTED");
        assertEquals("Book due date is 2018/10/5",book1.getDueDate(), date);
        assertFalse("Book2 is not rent-able", book2.rent(date));
    }

    /**
     * Test the returned() function functionality
     */
    private void returnTest()
    {
        book1.returned();
        assertTrue("Book1 is \"AVAILABLE\"", book1.getStatus().equals("AVAILABLE"));
    }

    /**
     * Test the setTitles(String) functionality
     */
    private void setTitlesTest()
    {
        String newBook1Title = "New Book 1";
        book1.setTitle(newBook1Title);
        assertEquals("Title is \"New Book 1\"", book1.getTitle(), newBook1Title);
        String newBook2Title = "New Book 2";
        book2.setTitle(newBook2Title);
        assertEquals("Title is \"New Book 2\"", book2.getTitle(), newBook2Title);
    }

    /**
     * Test the functionality for all different types of constructor
     */
    private void constructorTest()
    {
        Book testBook1 = new Book(10);
        Book testBook2 = new Book("Test Title", 20, "RESERVED");
        Book testBook3 = new Book(15, "Test Title 2", "RENTED", (new int[]{2019, 3, 23}));

        assertEquals("Book name is \"UNDEFINED\"", testBook1.getTitle(), "UNDEFINED");
        assertEquals("Book1 id is 10", testBook1.getId(), 10);
        assertEquals("Book1 status is \"NOT AVAILABLE\"", testBook1.getStatus(), "NOT AVAILABLE");

        assertEquals("Book2 title is \"Test Title\"", testBook2.getTitle(), "Test Title");
        assertEquals("Book2 id is 20", testBook2.getId(), 20);
        assertEquals("Book2 status is \"RESERVED\"", testBook2.getStatus(), "RESERVED");

        assertEquals("Book3 title is \"Test Title 2\"", testBook3.getTitle(), "Test Title 2");
        assertEquals("Book3 id is 15", testBook3.getId(), 15);
        assertEquals("Book3 status is \"RENTED\"", testBook3.getStatus(), "RENTED");
        int[] dueDate = testBook3.getDueDate();
        assertEquals("Book3 due date year is 2019", dueDate[0], 2019);
        assertEquals("Book3 due date month is 3", dueDate[1], 3);
        assertEquals("Book3 due date day is 23", dueDate[2], 23);
    }
}
