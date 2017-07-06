package libsys

import org.junit.*
import java.util.ArrayList

/**
 * Test User related operations
 */
class UserTest
{
    private var user1: User? = null
    private var user2: User? = null

    @Before fun prepareTest()
    {
        user1 = User("User1", 0, 10, ArrayList<Int>())
        val user2List = ArrayList<Int>()
        user2List.add(0)
        user2 = User("User2", 2, 8, user2List)
    }

    /**
     * Test User related operations
     */
    @Test fun userTest()
    {
        Assert.assertEquals("Name is \"User1\"", user1!!.name, "User1")
        Assert.assertEquals("id is 0", user1!!.id, 0)
        Assert.assertEquals("Limit is 10", user1!!.limit, 10)
        var bookIds: IntArray = user1!!.bookStatus()
        Assert.assertEquals("Book list is empty", bookIds.size, 0)

        Assert.assertEquals("Name is \"User2\"", user2!!.name, "User2")
        Assert.assertEquals("id is 2", user2!!.id, 2)
        Assert.assertEquals("Limit is 8", user2!!.limit, 8)
        bookIds = user2!!.bookStatus()
        Assert.assertEquals("Book list is empty", bookIds.size, 1)
        Assert.assertEquals("Book id is 0", bookIds[0], 0)

        var newName = "New User 1"
        user1!!.name = newName
        Assert.assertEquals("New name for User1 is \"New User 1\"", user1!!.name, newName)
        user1!!.limit = 1
        Assert.assertEquals("New limit for User1 is 8", user1!!.limit, 1)

        newName = "New User 2"
        user2!!.name = newName
        Assert.assertEquals("New name for User2 is \"New User 2\"", user2!!.name, newName)
        user2!!.limit = 3
        Assert.assertEquals("New limit for User2 is 3", user2!!.limit, 3)

        Assert.assertTrue(user1!!.borrowNewBook(3))
        bookIds = user1!!.bookStatus()
        Assert.assertEquals("User1 is now borrowing Book3", bookIds[0], 3)
        Assert.assertFalse("User1 reached the limit", user1!!.status())
        Assert.assertFalse("User1 fail to borrow another book", user1!!.borrowNewBook(5))
        Assert.assertFalse("User1 failed to return Book2 that was not borrowed", user1!!.returnBook(2))
        Assert.assertTrue("User1 return Book3", user1!!.returnBook(3))
        Assert.assertTrue("User1 can now borrow book", user1!!.status())
        Assert.assertEquals("User1 is not borrowing anything", user1!!.bookStatus().size, 0)
    }
}