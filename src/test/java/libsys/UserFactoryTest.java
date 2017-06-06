package libsys;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;

/**
 * Test UserFactory related operations
 */
public class UserFactoryTest extends TestCase
{
    private UserFactory userFactory;

    /**
     * Test UserFactory related operations
     * @param testName name of the test case
     */
    public UserFactoryTest(String testName)
    {
        super(testName);
    }

    /**
     * @return suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(UserFactoryTest.class);
    }

    /**
     * Set up before testing
     * @throws Exception Exception
     */
    public void setUp() throws Exception
    {
        super.setUp();
        userFactory = new UserFactory();
        userFactory.setUserFileName("testUserFactory.json");
    }

    /**
     * Run all tests
     */
    public void testApp()
    {
        newUserTest();
        fileIOTest();
        exceptionTest();
    }

    /**
     * Test the newUser function
     */
    private void newUserTest()
    {
        User user1 = userFactory.newUser("User1", 10);
        User user2 = userFactory.newUser("User2", 3);
        assertEquals("User1 is the same User object as the one in userFactory", user1, userFactory.getUser(0));
        assertEquals("User2 is the same User object as the one in userFactory", user2, userFactory.getUser(1));
        assertEquals("Name of User1 in userFactory is the same as returned", user1, userFactory.getUser("User1"));
        assertEquals("Name of User2 in userFactory is the same as returned", user2, userFactory.getUser("User2"));
        assertEquals("Name of User1 is \"User1\"", user1.getName(), "User1");
        assertEquals("Name of User2 is \"User2\"", user2.getName(), "User2");
        assertEquals("Name of User1 in userFactory is \"User1\"", userFactory.getUser(0).getName(), "User1");
        assertEquals("Name of User1 in userFactory is \"User1\"", userFactory.getUser(1).getName(), "User2");
        assertEquals("Limit of User1 is 10", user1.getLimit(), 10);
        assertEquals("Limit of User2 is 3", user2.getLimit(), 3);
        assertEquals("Limit of User1 in userFactory is 10", userFactory.getUser(0).getLimit(), 10);
        assertEquals("Limit of User2 in userFactory is 3", userFactory.getUser(1).getLimit(), 3);
    }

    /**
     * Test the class in writing to and reading from files
     */
    private void fileIOTest()
    {
        String filename = "someTestFile.json";
        userFactory.setUserFileName(filename);
        userFactory.toJsonFile();
        UserFactory newUserFactory = new UserFactory(filename);
        assertEquals("newUserFactory : Name of User1 is \"User1\"", newUserFactory.getUser(0).getName(), "User1");
        assertEquals("newUserFactory : Name of User2 is \"User2\"", newUserFactory.getUser(1).getName(), "User2");
        assertEquals("newUserFactory : Name of User1 is 10", newUserFactory.getUser(0).getLimit(), 10);
        assertEquals("newUserFactory : Name of User2 is 3", newUserFactory.getUser(1).getLimit(), 3);
    }

    /**
     * Test exception cases and error handling of the class
     */
    private void exceptionTest()
    {
        UserFactory anotherUserFactory = new UserFactory("noSuchFile.json");
        assertEquals("Check ID of new User of non-existent import file", anotherUserFactory.newUser("Some person", 1).getId(), 0);

        try
        {
            anotherUserFactory.getUser(1);
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
        File file = new File("testUserFactory.json");
        if(!file.delete())
        {
            System.out.println("testUserFactory.json is not found / deleted");
        }

        file = new File("noSuchFile.json");
        if(!file.delete())
        {
            System.out.println("noSuchFile.json is not found / deleted");
        }

        file = new File("someTestFile.json");
        if(!file.delete())
        {
            System.out.println("someTestFile.json is not found / deleted");
        }
    }
}
