package libsys

import org.junit.*
import java.io.File

/**
 * Test BookFactory related operations
 */
class BookFactoryTest
{
    private var bookFactory: BookFactory? = null

    init
    {

    }

    /**
     * Set up before testing
     */
    @Before fun prepareTest()
    {
        bookFactory = BookFactory()
        bookFactory!!.setBookFileName("testBookFactory.json")
    }

    /**
     * Delete files created during test
     */
    @After fun cleanupTest()
    {
        var file = File("noSuchFile.json")
        if (!file.delete())
        {
            println("noSuchFile.json is not found / deleted")
        }

        file = File("someTestFile.json")
        if (!file.delete())
        {
            println("someTestFile.json is not found / deleted")
        }

        file = File("testBookFactory.json")
        if (!file.delete())
        {
            println("testBookFactory.json is not found / deleted")
        }
    }

    /**
     * Test BookFactory related operations
     */
    @Test fun bookFactoryTest()
    {
        var book1 = bookFactory!!.newBook("Whole new Book", "AVAILABLE")
        Assert.assertTrue("Book ID is 0", book1.id == 0)
        Assert.assertTrue("Book title is \"Whole new Book\"", book1.title == bookFactory!!.getBook(0).title)
        Assert.assertTrue("Book status is \"AVAILABLE\"", book1.status == bookFactory!!.getBook(0).status)
        Assert.assertTrue("Comparing Book with to the Book in BookFactory", bookFactory!!.getBook(0) == book1)

        var filename = "."
        bookFactory!!.setBookFileName(filename)
        bookFactory!!.toJsonFile()
        Assert.assertFalse("File does not exist", File(filename).exists() && !File(filename).isDirectory)
        filename = "someTestFile.json"
        bookFactory!!.setBookFileName(filename)
        bookFactory!!.toJsonFile()
        val newBookFactory = BookFactory(filename)
        Assert.assertTrue("newBookFactory : Book title is \"Whole new Book\"", newBookFactory.getBook(0).title == "Whole new Book")
        Assert.assertEquals("newBookFactory : Book id is 0", newBookFactory.getBook("Whole new Book").id, 0)
        Assert.assertTrue("newBookFactory : Book status is \"AVAILABLE\"", newBookFactory.getBook(0).status == "AVAILABLE")

        val anotherBookFactory = BookFactory("noSuchFile.json")
        Assert.assertTrue("Check ID for new Book of non-existent import file", anotherBookFactory.newBook("Some book", "NOT AVAILABLE").id == 0)

        try
        {
            anotherBookFactory.getBook(20)
            assert(false)
        }
        catch (e: Exception)
        {
            assert(true)
        }

        try
        {
            val someBook = Book(20)
            val anotherBook = someBook
            anotherBookFactory.update(someBook, anotherBook)
            assert(false)
        }
        catch (e: Exception)
        {
            assert(true)
        }

        try
        {
            anotherBookFactory.getBook("No Such Book")
            assert(false)
        }
        catch (e: Exception)
        {
            assert(true)
        }

        Assert.assertTrue(bookFactory!!.deleteBook(0))
        Assert.assertFalse(bookFactory!!.deleteBook(0))
        book1 = bookFactory!!.newBook("todelete", "AVAILABLE")
        Assert.assertTrue(bookFactory!!.deleteBook(book1))
        Assert.assertFalse(bookFactory!!.deleteBook(book1))
    }
}