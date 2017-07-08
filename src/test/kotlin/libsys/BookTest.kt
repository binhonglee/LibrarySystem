package libsys

import org.junit.*

/**
 * Test Book related operations
 */
class BookTest
{
    private var book1: Book? = null
    private var book2: Book? = null

    /**
     * Set up before testing
     */
    @Before fun prepareTest()
    {
        book1 = Book("Book1", 10, "AVAILABLE")
        book2 = Book("Book2", 12, "NOT AVAILABLE")
    }

    init
    {

    }

    /**
     * Test Book related operations
     */
    @Test fun bookTest()
    {
        Assert.assertEquals("Title is \"Book1\"", book1!!.title, "Book1")
        Assert.assertEquals("Status is \"AVAILABLE\"", book1!!.status, "AVAILABLE")
        Assert.assertEquals("Book id is 10", book1!!.id, 10)
        Assert.assertEquals("Title is \"Book2\"", book2!!.title, "Book2")
        Assert.assertEquals("Status is \"NOT AVAILABLE\"", book2!!.status, "NOT AVAILABLE")
        Assert.assertEquals("Book id is 12", book2!!.id, 12)

        val date = intArrayOf(2018, 10, 5)
        Assert.assertTrue("Rent should be successful", book1!!.rent(date))
        Assert.assertEquals("Book status is \"RENTED\"", book1!!.status, "RENTED")
        Assert.assertEquals("Book due date is 2018/10/5", book1!!.dueDate, date)
        Assert.assertFalse("Book2 is not rent-able", book2!!.rent(date))

        book1!!.returned()
        Assert.assertTrue("Book1 is \"AVAILABLE\"", book1!!.status == "AVAILABLE")

        val newBook1Title = "New Book 1"
        book1!!.title = newBook1Title
        Assert.assertEquals("Title is \"New Book 1\"", book1!!.title, newBook1Title)
        val newBook2Title = "New Book 2"
        book2!!.title = newBook2Title
        Assert.assertEquals("Title is \"New Book 2\"", book2!!.title, newBook2Title)

        val testBook1 = Book(10)
        val testBook2 = Book("Test Title", 20, "RESERVED")
        val testBook3 = Book(15, "Test Title 2", "RENTED", intArrayOf(2019, 3, 23))

        Assert.assertEquals("Book name is \"UNDEFINED\"", testBook1.title, "UNDEFINED")
        Assert.assertEquals("Book1 id is 10", testBook1.id, 10)
        Assert.assertEquals("Book1 status is \"NOT AVAILABLE\"", testBook1.status, "NOT AVAILABLE")

        Assert.assertEquals("Book2 title is \"Test Title\"", testBook2.title, "Test Title")
        Assert.assertEquals("Book2 id is 20", testBook2.id, 20)
        Assert.assertEquals("Book2 status is \"RESERVED\"", testBook2.status, "RESERVED")

        Assert.assertEquals("Book3 title is \"Test Title 2\"", testBook3.title, "Test Title 2")
        Assert.assertEquals("Book3 id is 15", testBook3.id, 15)
        Assert.assertEquals("Book3 status is \"RENTED\"", testBook3.status, "RENTED")
        val dueDate = testBook3.dueDate
        Assert.assertEquals("Book3 due date year is 2019", dueDate[0], 2019)
        Assert.assertEquals("Book3 due date month is 3", dueDate[1], 3)
        Assert.assertEquals("Book3 due date day is 23", dueDate[2], 23)
    }

}
