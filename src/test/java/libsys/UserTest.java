package libsys;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;

/**
 * Test User related operations
 */
public class UserTest extends TestCase
{
    private User user1;
    private User user2;

    /**
     * Test User related operations
     * @param testName name of the test case
     */
    public UserTest(String testName)
    {
        super(testName);
    }

    /**
     * @return suite of the tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(UserTest.class);
    }

    /**
     * Run all tests
     */
    public void testApp()
    {
        valueTest();
        setterTest();
        bookInteractionTest();
    }

    /**
     * Set up before testing
     * @throws Exception Exception
     */
    public void setUp() throws Exception
    {
        super.setUp();
        user1 = new User("User1", 0, 10, new ArrayList<Integer>());
        ArrayList<Integer> user2List = new ArrayList<Integer>();
        user2List.add(0);
        user2 = new User("User2", 2, 8, user2List);
    }

    /**
     * Test if the values are accurate
     */
    private void valueTest()
    {
        assertEquals("Name is \"User1\"", user1.getName(), "User1");
        assertEquals("id is 0", user1.getId(), 0);
        assertEquals("Limit is 10", user1.getLimit(), 10);
        int[] bookIds = user1.bookStatus();
        assertEquals("Book list is empty", bookIds.length, 0);

        assertEquals("Name is \"User2\"", user2.getName(), "User2");
        assertEquals("id is 2", user2.getId(), 2);
        assertEquals("Limit is 8", user2.getLimit(), 8);
        bookIds = user2.bookStatus();
        assertEquals("Book list is empty", bookIds.length, 1);
        assertEquals("Book id is 0", bookIds[0], 0);
    }

    /**
     * Test the setter functions
     */
    private void setterTest()
    {
        String newName = "New User 1";
        user1.setName(newName);
        assertEquals("New name for User1 is \"New User 1\"", user1.getName(), newName);
        user1.setLimit(1);
        assertEquals("New limit for User1 is 8", user1.getLimit(), 1);

        newName = "New User 2";
        user2.setName(newName);
        assertEquals("New name for User2 is \"New User 2\"", user2.getName(), newName);
        user2.setLimit(3);
        assertEquals("New limit for User2 is 3", user2.getLimit(), 3);
    }

    /**
     * Test all functions related to Book
     */
    private void bookInteractionTest()
    {
        assertTrue(user1.borrowNewBook(3));
        int[] bookIds = user1.bookStatus();
        assertEquals("User1 is now borrowing Book3", bookIds[0], 3);
        assertFalse("User1 reached the limit", user1.status());
        assertFalse("User1 failed to return Book2 that was not borrowed", user1.returnBook(2));
        assertTrue("User1 return Book3", user1.returnBook(3));
        assertTrue("User1 can now borrow book", user1.status());
        assertEquals("User1 is not borrowing anything", user1.bookStatus().length, 0);
    }
}
