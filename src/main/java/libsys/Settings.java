package libsys;
/*
 *  Written by : Bin Hong Lee
 *  Last edited : 6/4/2017
 */

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Handles all settings related operations and background processing of SettingsDialog
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class Settings
{
  private HashMap<String, String> items = new HashMap();
  private ArrayList<String> keys = new ArrayList();
  private String settingsFileName;

  /**
   * Creates new Settings importing information from the given file name
   * @param  settingsFileName File name of existing settings stored
   */
  public Settings(String settingsFileName)
  {
    this.settingsFileName = settingsFileName;

    try
    {
      Scanner in = new Scanner(new FileInputStream(settingsFileName));
      while (in.hasNextLine())
      {
        String newInput = in.nextLine();
        String[] inputSplitted = newInput.split(":");
        keys.add(inputSplitted[0]);
        items.put(keys.get(keys.size() - 1), inputSplitted[1]);
      }
    }
    catch (Exception e)
    {
      System.out.println("Settings file not found!");
      setDefault();
    }
  }

  /**
   * Save the settings to the given input file
   */
  private void toFile()
  {
    try
    {
      PrintWriter out = new PrintWriter(settingsFileName);
      for (String key : keys) {
        out.println(key + ":" + items.get(key));
      }
      out.close();
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
      setDefault();
    }
  }

  /**
   * Amount of fields in the settings
   * @return Amount of keys
   */
  public int size()
  {
    return keys.size();
  }

  /**
   * Get the field name from that specific location in the array list
   * @param  location      Location of the field in the array list
   * @return     The field name
   */
  String getKey(int location)
  {
    return keys.get(location);
  }

  /**
   * Get the value associated to the field name
   * @param  key           Field name
   * @return Field value
   */
  public String get(String key)
  {
    return items.get(key);
  }

  /**
   * Change the title of the application
   * @param newTitle        New Title
   */
  public void setTitle(String newTitle)
  {
    update("Title", newTitle);
  }

  /**
   * Change the file name for the Users
   * @param newUsersFilename  New file name for Users
   */
  void setUsersFilename(String newUsersFilename)
  {
    update("Users Filename", newUsersFilename);
  }

  /**
   * Change the file name for the Books
   * @param newBooksFilename  New file name for Books
   */
  void setBooksFilename(String newBooksFilename)
  {
    update("Books Filename", newBooksFilename);
  }

  private void update(String key, String newValue)
  {
    items.remove(key);
    items.put(key, newValue);
    toFile();
  }

  private void setDefault()
  {
    keys.add("Title");
    items.put(keys.get(0), "Welcome to the library");
    keys.add("Users Filename");
    items.put(keys.get(1), "users.json");
    keys.add("Books Filename");
    items.put(keys.get(2), "books.json");
  }
}
