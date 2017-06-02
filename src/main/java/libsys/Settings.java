package libsys;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.ArrayList;

public class Settings
{
  private HashMap<String, String> items = new HashMap();
  private ArrayList<String> keys = new ArrayList();
  private String settingsFileName;

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

  public void toFile()
  {
    try
    {
      PrintWriter out = new PrintWriter(settingsFileName);
      for (int i = 0; i < keys.size(); i++)
      {
        out.println(keys.get(i) + ":" + items.get(keys.get(i)));
      }
      out.close();
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
      setDefault();
    }
  }

  public void update(String key, String newValue)
  {
    items.remove(key);
    items.put(key, newValue);
    toFile();
  }

  public int size()
  {
    return keys.size();
  }

  public String getKey(int location)
  {
    return keys.get(location);
  }

  public String get(String key)
  {
    return items.get(key);
  }

  public void setTitle(String newTitle)
  {
    update("Title", newTitle);
  }

  public void setUsersFilename(String newUsersFilename)
  {
    update("Users Filename", newUsersFilename);
  }

  public void setBooksFilename(String newBooksFilename)
  {
    update("Books Filename", newBooksFilename);
  }

  public void setDefault()
  {
    keys.add("Title");
    items.put(keys.get(0), "Welcome to the library");
    keys.add("Users Filename");
    items.put(keys.get(1), "users.json");
    keys.add("Books Filename");
    items.put(keys.get(2), "books.json");
  }
}
