package libsys

/*
 *  Written by : Bin Hong Lee
 *  Last edited : 7/4/2017
 */

import java.util.*

/**
 * User object
 */
class User {

    /**
     * Name of the User
     */
    var name: String? = null
        set
        get
    /**
     * ID of the User
     */
    var id: Int = 0
        private set
        get
    /**
     * Limit of the User
     */
    var limit: Int = 0
        set
        get

    private var books = ArrayList<Int>()

    /**
     * @constructor Creates a new User with name, id and limit (usually used to add new User)
     * @param  name          Name of this User
     * @param  id            id of this User
     * @param  limit         Limit of Book this User can borrow
     */
    constructor(name: String, id: Int, limit: Int) {
        this.name = name
        this.id = id
        this.limit = limit
    }

    /**
     * @constructor Creates a new User with name, id, limit and books (usually used to initialize from database)
     * @param  name          Name of this User
     * @param  id            id of this User
     * @param  limit         Limit of Book this User can borrow
     * @param  books         ArrayList of Book ids borrowed by the User
     */
    constructor(name: String, id: Int, limit: Int, books: ArrayList<Int>) {
        this.name = name
        this.id = id
        this.limit = limit
        this.books = books
    }

    /**
     * Check status of the User
     * @return If the User is already at the borrowing limit
     */
    fun status(): Boolean {
        return books.size < limit

    }

    /**
     * Get Book ids of the books
     * @return Array of Book ids borrowed by this User
     */
    fun bookStatus(): IntArray {
        val currentBooks = IntArray(books.size)

        for (i in books.indices) {
            currentBooks[i] = books[i]
        }

        return currentBooks
    }

    /**
     * User borrows a Book
     * @param  id            id of the Book to tbe borrowed
     * @return If the borrowing operation is successful
     */
    fun borrowNewBook(id: Int): Boolean {
        if (status()) {
            books.add(id)
            return true
        } else {
            return false
        }
    }

    /**
     * User returns a Book
     * @param  id            id of the Book to be returned
     * @return If the returning operation is successful
     */
    fun returnBook(id: Int): Boolean {
        for (i in books.indices) {
            if (books[i] == id) {
                books.removeAt(i)
                return true
            }
        }

        return false
    }
}
