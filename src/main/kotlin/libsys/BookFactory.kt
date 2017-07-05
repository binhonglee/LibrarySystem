package libsys

/*
 *  Written by : Bin Hong Lee
 *  Last edited : 7/4/2017
 */

import java.util.ArrayList
import org.json.JSONObject
import org.json.JSONTokener
import java.io.FileInputStream
import java.io.PrintWriter

/**
 * Handles all the Book(s)
 */
class BookFactory {
    private val books = ArrayList<Book>()
    private var id: Int = 0
    private var bookFilename: String? = null

    /**
     * @constructor Create a new empty BookFactory
     */
    constructor() {
        id = 0
        bookFilename = "books.json"
    }

    /**
     * @constructor Create a new BookFactory and fill it with information from a JSON file
     *
     * @param  bookFilename  Name of the input JSON file
     */
    constructor(bookFilename: String) {
        try {
            val `in` = FileInputStream(bookFilename)
            val obj = JSONObject(JSONTokener(`in`))
            val ids = JSONObject.getNames(obj)

            for (id1 in ids) {
                val jsonBook = obj.getJSONObject(id1)
                val id = Integer.parseInt(id1)
                val title = jsonBook.getString("Title")
                val status = jsonBook.getString("Status")
                val jsonDueDate = jsonBook.getJSONArray("Due Date")
                val dueDate = IntArray(jsonDueDate.length())

                for (j in 0..jsonDueDate.length() - 1) {
                    dueDate[j] = jsonDueDate.optInt(j)
                }
                books.add(Book(id, title, status, dueDate))
            }
            `in`.close()
            id = books[books.size - 1].id + 1
        } catch (ex: Exception) {
            println(ex.message)
            id = 0
        }

        this.bookFilename = bookFilename
    }

    /**
     * Output the data into a JSON file replacing the input file (or if filename not given, "books.json")
     */
    fun toJsonFile()
    {
        try
        {
            val out = PrintWriter(bookFilename!!)
            val booksObj = JSONObject()

            for (book in books)
            {
                val bookObj = JSONObject()
                bookObj.put("Title", book.title)
                bookObj.put("Status", book.status)
                bookObj.put("Due Date", book.dueDate)
                booksObj.put(Integer.toString(book.id), bookObj)
            }

            out.println(booksObj.toString(4))
            out.close()
        }
        catch (e: Exception)
        {
            println("Invalid output filename.")
        }
    }

    /**
     * Update the output filename for the object
     * @param bookFilename The new filename
     */
    fun setBookFileName(bookFilename: String)
    {
        this.bookFilename = bookFilename
    }

    /**
     * Adds a new Book into this class
     * @param  title         Title of the Book
     * @param  status        Status of the Book
     *
     * @return The new Book that is just created
     */
    fun newBook(title: String, status: String): Book
    {
        val temp = Book(title, id, status)
        books.add(temp)

        id++
        toJsonFile()

        return temp
    }

    /**
     * Looks for a Book with the given id
     * @param  index         id of the Book to be found
     *
     * @return Book with the given id
     */
    fun getBook(index: Int): Book
    {
        return search(index, 0, books.size - 1)
    }

    /**
     * Recursive binary search through the array list for the Book with the given id
     * @param  index         id of the Book to be found
     * @param  start         Starting point to search
     * @param  end           Ending point to search
     *
     * @return Book with the given id
     */
    private fun search(index: Int, start: Int, end: Int): Book
    {
        if (start == end && books[start].id == index)
        {
            return books[start]
        }

        if (start >= end)
        {
            throw NullPointerException()
        }

        val currentId = (start + end) / 2

        if (books[currentId].id == index)
        {
            return books[currentId]
        }
        else if (books[currentId].id > index)
        {
            return search(index, start, currentId - 1)
        }
        else
        {
            return search(index, currentId + 1, end)
        }
    }

    /**
     * Linear search through the array list for Book with the given Title
     * @param  title         Title of the Book to be found
     *
     * @return Book with the given title
     */
    fun getBook(title: String): Book
    {
        books
                .asSequence()
                .filter { it.title == title }
                .forEach { return it }

        throw NullPointerException()
    }

    /**
     * Replacing a Book in the array list with a new Book
     * @param oldBook Book to be replaced
     * @param newBook Book replacing it
     */
    fun update(oldBook: Book, newBook: Book)
    {
        var found = false
        for (i in books.indices)
        {
            val temp = books[i]

            if (temp.id == oldBook.id)
            {
                books[i] = newBook
                found = true
            }
        }

        if (!found)
        {
            throw NullPointerException()
        }

        toJsonFile()
    }
}
