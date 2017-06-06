package libsys;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;

/**
 * Test Handler related operations
 */
public class HandlerTest extends TestCase
{
    private Handler handler = new Handler();

    /**
     * Test Handler related operations
     * @param testName name of the test case
     */
    public HandlerTest(String testName)
    {
        super(testName);
    }

    /**
     * @return suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(HandlerTest.class);
    }

    /**
     * Run all tests
     */
    public void testApp()
    {
        borrowBookTest();
        returnBookTest();
        calDueDateTest();
        bookIdsToTitlesStringTest();
    }

    /**
     * Set up before testing
     * @throws Exception Exception
     */
    public void setUp() throws Exception
    {
        super.setUp();
        handler.users = new UserFactory();
        handler.users.setUserFileName("usersTest.json");
        handler.books = new BookFactory();
        handler.books.setBookFileName("booksTest.json");
        handler.users.newUser("User1", 2);
        handler.users.newUser("User2", 1);
        handler.users.newUser("User3", 1);
        handler.books.newBook("Book1", "AVAILABLE");
        handler.books.newBook("Book2", "AVAILABLE");
        handler.books.newBook("Book3", "NOT AVAILABLE");
        handler.books.newBook("Book4", "AVAILABLE");
    }

    /**
     * Delete files after testing
     * @throws Exception Exception
     */
    public void tearDown() throws Exception
    {
        super.tearDown();
        File file = new File("usersTest.json");
        if(!file.delete())
            System.out.println("usersTest.json not deleted");
        file = new File("booksTest.json");
        if(!file.delete())
            System.out.println("booksTest.json not deleted");
    }

    /**
     * Test the borrowBook function
     */
    private void borrowBookTest()
    {
        assertTrue("User1 borrows Book1 successful (Book is AVAILABLE, User status is True)", handler.borrowBook(handler.users.getUser(0), handler.books.getBook(0)));
        assertEquals("Book1 is now RENTED", handler.books.getBook(0).getStatus(), "RENTED");
        assertTrue("User2 borrows Book2 successful (Book is AVAILABLE, User status is True)", handler.borrowBook(handler.users.getUser(1), handler.books.getBook(1)));
        assertEquals("Book2 is now RENTED", handler.books.getBook(1).getStatus(), "RENTED");
        assertFalse("User3 borrows Book3 unsuccessful (Book is NOT AVAILABLE, User status is True)", handler.borrowBook(handler.users.getUser(2), handler.books.getBook(2)));
        assertEquals("Book3 is still NOT AVAILABLE", handler.books.getBook(2).getStatus(), "NOT AVAILABLE");
        assertFalse("User3 borrows Book1 unsuccessful (Book is RENTED, User status is True)", handler.borrowBook(handler.users.getUser(2), handler.books.getBook(0)));
        assertFalse("User2 borrows Book4 unsuccessful (Book is AVAILABLE, User status is False)", handler.borrowBook(handler.users.getUser(1), handler.books.getBook(3)));
        assertEquals("Book4 is still AVAILABLE", handler.books.getBook(3).getStatus(), "AVAILABLE");
        assertFalse("User2 borrows Book3 unsuccessful (Book is NOT AVAILABLE, User status is False)", handler.borrowBook(handler.users.getUser(1), handler.books.getBook(2)));
        assertEquals("Book3 is still NOT AVAILABLE", handler.books.getBook(2).getStatus(), "NOT AVAILABLE");
        assertFalse("User2 borrows Book1 unsuccessful (Book is RENTED, User status is False)", handler.borrowBook(handler.users.getUser(1), handler.books.getBook(0)));
    }

    /**
     * Test the returnBook function
     */
    private void returnBookTest()
    {
        assertFalse("User2 returns Book1 unsuccessful (Not renter of the Book)", handler.returnBook(handler.users.getUser(1), handler.books.getBook(0)));
        assertFalse("User3 returns Book3 unsuccessful (Not renter of the Book, Book NOT AVAILABLE", handler.returnBook(handler.users.getUser(2), handler.books.getBook(2)));
        assertTrue("User1 returns Book1 successful (User is renter, Book is rented)", handler.returnBook(handler.users.getUser(0), handler.books.getBook(0)));
        assertEquals("Book1 is now AVAILABLE", handler.books.getBook(0).getStatus(), "AVAILABLE");
        assertFalse("User3 returns Book2 unsuccessful (Not renter of the Book", handler.returnBook(handler.users.getUser(2), handler.books.getBook(1)));
        assertFalse("User3 returns Book4 unsuccessful (Not renter of the Book, Book is AVAILABLE", handler.returnBook(handler.users.getUser(2), handler.books.getBook(3)));
        assertTrue("User2 returns Book2 successful (User is renter, Book is rented)", handler.returnBook(handler.users.getUser(1), handler.books.getBook(1)));
        assertEquals("Book2 is now AVAILABLE", handler.books.getBook(1).getStatus(), "AVAILABLE");
    }

    /**
     * Test the calDueDate function
     */
    private void calDueDateTest()
    {
        int[] date1 = new int[]{2017, 10, 10};
        int[] date2 = new int[]{2017, 2, 26};
        int[] date3 = new int[]{2017, 4, 20};
        int[] date4 = new int[]{2017, 8, 30};
        int[] date5 = new int[]{2017, 12, 29};
        int[] date6 = new int[]{2012, 2, 25};

        int[] temp = handler.calDueDate(10, date1);
        assertEquals("Basic addition year", temp[0], 2017);
        assertEquals("Basic addition month", temp[1], 10);
        assertEquals("Basic addition day", temp[2], 20);

        temp = handler.calDueDate(5, date2);
        assertEquals("Cross February year", temp[0], 2017);
        assertEquals("Cross February month", temp[1], 3);
        assertEquals("Cross February day", temp[2], 3);

        temp = handler.calDueDate(15, date3);
        assertEquals("Cross 30-days-month year", temp[0], 2017);
        assertEquals("Cross 30-days-month month", temp[1], 5);
        assertEquals("Cross 30-days-month day", temp[2], 5);

        temp = handler.calDueDate(10, date4);
        assertEquals("Cross 31-days-month year", temp[0], 2017);
        assertEquals("Cross 31-days-month month", temp[1], 9);
        assertEquals("Cross 31-days-month day", temp[2], 9);

        temp = handler.calDueDate(10, date5);
        assertEquals("Cross year year", temp[0], 2018);
        assertEquals("Cross year month", temp[1], 1);
        assertEquals("Cross year day", temp[2], 8);

        temp = handler.calDueDate(5, date6);
        assertEquals("Cross leap-year February year", temp[0], 2012);
        assertEquals("Cross leap-year February month", temp[1], 3);
        assertEquals("Cross leap-year February day", temp[2], 1);
    }

    /**
     * Test the bookIdsToTitlesString function
     */
    private void bookIdsToTitlesStringTest()
    {
        int[] bookIds = new int[]{3};
        assertEquals("Get String of 1 bookId", handler.bookIdsToTitlesString(bookIds), "Book4; ");

        bookIds = new int[]{0, 1, 2};
        assertEquals("Get String of 3 bookIds", handler.bookIdsToTitlesString(bookIds), "Book1; Book2; Book3; ");

        bookIds = new int[]{2, 1, 0};
        assertEquals("Get String of 3 bookIds reversed", handler.bookIdsToTitlesString(bookIds), "Book3; Book2; Book1; ");
    }
}
