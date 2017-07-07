package libsys

/*
 *  Written by : Bin Hong Lee
 *  Last edited : 6/4/2017
 */

import java.util.Scanner
import java.io.FileInputStream
import java.io.PrintWriter
import java.util.HashMap
import java.util.ArrayList

/**
 * Handles all settings related operations and background processing of SettingsDialog
 *
 * @constructor Creates new Settings importing information from the given file name
 * @param  settingsFileName File name of existing settings stored
 */
class Settings(private val settingsFileName: String)
{
    private val items = HashMap<String, String>()
    private val keys = ArrayList<String>()

    init
    {
        try
        {
            val `in` = Scanner(FileInputStream(settingsFileName))
            while (`in`.hasNextLine())
            {
                val newInput = `in`.nextLine()
                val inputSplitted = newInput.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                keys.add(inputSplitted[0])
                items.put(keys[keys.size - 1], inputSplitted[1])
            }
        }
        catch (e: Exception)
        {
            println("Settings file not found!")
            setDefault()
        }

    }

    /**
     * Save the settings to the given input file
     */
    private fun toFile()
    {
        try
        {
            val out = PrintWriter(settingsFileName)
            for (key in keys)
            {
                out.println(key + ":" + items[key])
            }
            out.close()
        }
        catch (e: Exception)
        {
            println("Invalid output filename")
            setDefault()
        }

    }

    /**
     * Amount of fields in the settings
     * @return Amount of keys
     */
    fun size(): Int
    {
        return keys.size
    }

    /**
     * Get the field name from that specific location in the array list
     * @param  location      Location of the field in the array list
     * *
     * @return     The field name
     */
    fun getKey(location: Int): String
    {
        return keys[location]
    }

    /**
     * Get the value associated to the field name
     * @param  key           Field name
     * *
     * @return Field value
     */
    fun get(key: String): String
    {
        return items[key].toString()
    }

    /**
     * Change the title of the application
     * @param newTitle        New Title
     */
    fun setTitle(newTitle: String)
    {
        update("Title", newTitle)
    }

    /**
     * Change the file name for the Users
     * @param newUsersFilename  New file name for Users
     */
    fun setUsersFilename(newUsersFilename: String)
    {
        update("Users Filename", newUsersFilename)
    }

    /**
     * Change the file name for the Books
     * @param newBooksFilename  New file name for Books
     */
    fun setBooksFilename(newBooksFilename: String)
    {
        update("Books Filename", newBooksFilename)
    }

    private fun update(key: String, newValue: String)
    {
        items.remove(key)
        items.put(key, newValue)
        toFile()
    }

    private fun setDefault()
    {
        keys.add("Title")
        items.put(keys[0], "Welcome to the library")
        keys.add("Users Filename")
        items.put(keys[1], "users.json")
        keys.add("Books Filename")
        items.put(keys[2], "books.json")
    }
}
