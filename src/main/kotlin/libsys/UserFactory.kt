package libsys

/*
 *  Written by : Bin Hong Lee
 *  Last edited : 7/4/2017
 */

import org.json.JSONObject
import org.json.JSONTokener

import java.io.FileInputStream
import java.io.PrintWriter
import java.util.ArrayList

/**
 * Handles all the User(s)
 */
class UserFactory {
    private val users = ArrayList<User>()
    private var id: Int = 0
    private var userFilename: String? = null

    /**
     * @constructor Create a new empty UserFactory
     */
    constructor() {
        id = 0
        userFilename = "users.json"
    }

    /**
     * @constructor Create a new UserFactory and fill it with information from a JSON file
     * @param  userFilename  Name of the input JSON file
     */
    constructor(userFilename: String) {
        try {
            val `in` = FileInputStream(userFilename)
            val obj = JSONObject(JSONTokener(`in`))
            val ids = JSONObject.getNames(obj)

            for (id1 in ids) {
                val jsonUser = obj.getJSONObject(id1)
                val id = Integer.parseInt(id1)
                val name = jsonUser.getString("Name")
                val limit = jsonUser.getInt("Limit")

                val jsonBooks = jsonUser.getJSONArray("Books")
                val books = (0..jsonBooks.length() - 1).mapTo(ArrayList<Int>())
                {
                    Integer.parseInt(jsonBooks.get(it).toString())
                }

                users.add(User(name, id, limit, books))
            }
            `in`.close()
            id = getUser(users.size - 1).id + 1
        } catch (ex: Exception) {
            println("Exception importing from json: " + ex.message)
            id = 0
        }

        this.userFilename = userFilename
    }

    /**
     * Output the data into a JSON file replacing the input file (or if filename not given, "users.json")
     */
    fun toJsonFile() {
        try {
            val out = PrintWriter(userFilename!!)
            val usersObj = JSONObject()
            for (user in users) {
                val userObj = JSONObject()
                userObj.put("Name", user.name)
                userObj.put("Limit", user.limit)
                userObj.put("Books", user.bookStatus())
                usersObj.put(Integer.toString(user.id), userObj)
            }
            out.println(usersObj.toString(4))
            out.close()
        } catch (e: Exception) {
            println("Invalid output filename")
        }

    }

    /**
     * Update the output filename for the object
     * @param userFilename The new filename
     */
    fun setUserFileName(userFilename: String) {
        this.userFilename = userFilename
    }

    /**
     * Adds a new User into this class
     * @param  name          Name of the User
     * @param  limit         Limit of Book the User can borrow
     *
     * @return The new User that is just created
     */
    fun newUser(name: String, limit: Int): User {
        val temp = User(name, id, limit)
        users.add(temp)

        id++
        toJsonFile()

        return temp
    }

    /**
     * Looks for the User with the given name
     * @param  name          Name of the User to be found
     *
     * @return User with the given name
     */
    fun getUser(name: String): User {
        users
                .asSequence()
                .filter { it.name == name }
                .forEach { return it }

        throw NullPointerException()
    }

    /**
     * Looks for a User with the given id
     * @param  index         id of the User to be found
     *
     * @return User with the given id
     */
    fun getUser(index: Int): User {
        return search(index, 0, users.size - 1)
    }

    /**
     * Recursive binary search through the array list for the User with the given id
     * @param  index         id of the User to be found
     * @param  start         Starting point to search
     * @param  end           Ending point to search
     *
     * @return User with the given id
     */
    private fun search(index: Int, start: Int, end: Int): User {
        if (start == end && users[start].id == index) {
            return users[start]
        }

        if (start >= end) {
            throw NullPointerException()
        }

        val currentId = (start + end) / 2

        if (users[currentId].id == index) {
            return users[currentId]
        } else if (users[currentId].id > index) {
            return search(index, start, currentId - 1)
        } else {
            return search(index, currentId + 1, end)
        }
    }

    /**
     * Replacing a User in the array list with a new User
     * @param oldUser User to be replaced
     * @param newUser User replacing it
     */
    fun update(oldUser: User, newUser: User) {
        for (i in users.indices) {
            val temp = users[i]

            if (temp.id == oldUser.id) {
                users[i] = newUser
            }
        }

        toJsonFile()
    }
}
