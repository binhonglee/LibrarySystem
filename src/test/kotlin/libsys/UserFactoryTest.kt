package libsys

import org.junit.*
import java.io.File

/**
 * Test Book related operations
 */
class UserFactoryTest {
    private var userFactory: UserFactory? = null

    init
    {

    }

    /**
     * Set up before testing
     */
    @Before fun prepareTest()
    {
        userFactory = UserFactory()
        userFactory!!.setUserFileName("testUserFactory.json")
    }

    @After fun cleanupTest()
    {
        var file = File("testUserFactory.json")
        if (!file.delete())
        {
            println("testUserFactory.json is not found / deleted")
        }

        file = File("noSuchFile.json")
        if (!file.delete())
        {
            println("noSuchFile.json is not found / deleted")
        }

        file = File("someTestFile.json")
        if (!file.delete())
        {
            println("someTestFile.json is not found / deleted")
        }
    }

    /**
     * Test UserFactory related operations
     */
    @Test fun userFactoryTest()
    {
        var user1 = userFactory!!.newUser("User1", 10)
        val user2 = userFactory!!.newUser("User2", 3)
        Assert.assertEquals("User1 is the same User object as the one in userFactory", user1, userFactory!!.getUser(0))
        Assert.assertEquals("User2 is the same User object as the one in userFactory", user2, userFactory!!.getUser(1))
        Assert.assertEquals("Name of User1 in userFactory is the same as returned", user1, userFactory!!.getUser("User1"))
        Assert.assertEquals("Name of User2 in userFactory is the same as returned", user2, userFactory!!.getUser("User2"))
        Assert.assertEquals("Name of User1 is \"User1\"", user1.name, "User1")
        Assert.assertEquals("Name of User2 is \"User2\"", user2.name, "User2")
        Assert.assertEquals("Name of User1 in userFactory is \"User1\"", userFactory!!.getUser(0).name, "User1")
        Assert.assertEquals("Name of User1 in userFactory is \"User1\"", userFactory!!.getUser(1).name, "User2")
        Assert.assertEquals("Limit of User1 is 10", user1.limit, 10)
        Assert.assertEquals("Limit of User2 is 3", user2.limit, 3)
        Assert.assertEquals("Limit of User1 in userFactory is 10", userFactory!!.getUser(0).limit, 10)
        Assert.assertEquals("Limit of User2 in userFactory is 3", userFactory!!.getUser(1).limit, 3)

        user1 = userFactory!!.getUser(0)
        user1.borrowNewBook(0)
        user1.borrowNewBook(1)
        userFactory!!.update(userFactory!!.getUser(0), user1)

        var filename = "."
        userFactory!!.setUserFileName(filename)
        userFactory!!.toJsonFile()
        Assert.assertFalse("File does not exist", File(filename).exists() && !File(filename).isDirectory)
        filename = "someTestFile.json"
        userFactory!!.setUserFileName(filename)
        userFactory!!.toJsonFile()
        val newUserFactory = UserFactory(filename)
        Assert.assertEquals("newUserFactory : Name of User1 is \"User1\"", newUserFactory.getUser(0).name, "User1")
        Assert.assertEquals("newUserFactory : Name of User2 is \"User2\"", newUserFactory.getUser(1).name, "User2")
        Assert.assertEquals("newUserFactory : Name of User1 is 10", newUserFactory.getUser(0).limit, 10)
        Assert.assertEquals("newUserFactory : Name of User2 is 3", newUserFactory.getUser(1).limit, 3)

        val anotherUserFactory = UserFactory("noSuchFile.json")
        Assert.assertEquals("Check ID of new User of non-existent import file", anotherUserFactory.newUser("Some person", 1).id, 0)

        try
        {
            anotherUserFactory.getUser(1)
            assert(false)
        }
        catch (e: Exception)
        {
            assert(true)
        }

        try
        {
            anotherUserFactory.getUser("alk;jcnalk")
            assert(false)
        }
        catch (e: Exception)
        {
            assert(true)
        }

    }
}