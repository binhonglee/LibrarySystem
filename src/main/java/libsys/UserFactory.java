package libsys;
/*
 *  Written by : Bin Hong Lee
 *  Last edited : 6/4/2017
 */

import java.util.List;
import java.util.ArrayList;
import org.json.JSONString;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONArray;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.File;
import java.util.Enumeration;
import java.io.Serializable;

public class UserFactory
{
  private List<User> users = new ArrayList<User>();
  private int id;
  private String userFilename;

  /**
   * Create a new empty UserFactory
   */
  public UserFactory()
  {
    id = 0;
    userFilename = "users,json";
  }

  /**
   * Create a new UserFactory and fill it with information from a JSON file
   * @param  userFilename  Name of the input JSON file
   */
  public UserFactory(String userFilename)
  {
    try
    {
      FileInputStream in = new FileInputStream(userFilename);
      JSONObject obj = new JSONObject(new JSONTokener(in));
      String [] ids = JSONObject.getNames(obj);

      for (int i = 0; i < ids.length; i++)
      {
        JSONObject jsonUser = obj.getJSONObject(ids[i]);
        int id = Integer.parseInt(ids[i]);
        String name = jsonUser.getString("Name");
        int limit = jsonUser.getInt("Limit");

        JSONArray jsonBooks = jsonUser.getJSONArray("Books");
        ArrayList<Integer> books = new ArrayList<Integer>();
        for (int j = 0; j < jsonBooks.length(); j++)
        {
          books.add(Integer.parseInt(jsonBooks.get(j).toString()));
        }

        users.add(new User(name, id, limit, books));
      }
      in.close();
      id = getUser(users.size()-1).getId() + 1;
    }
    catch (Exception ex)
    {
      System.out.println("Exception importing from json: " + ex.getMessage());
      id = 0;
    }

    this.userFilename = userFilename;
  }

  /**
   * Output the data into a JSON file replacing the input file (or if filename not given, "users.json")
   */
  public void toJsonFile()
  {
    try
    {
      PrintWriter out = new PrintWriter(userFilename);
      JSONObject usersObj = new JSONObject();
      for (int i = 0; i < users.size(); i++)
      {
         User user = users.get(i);
         JSONObject userObj = new JSONObject();
         userObj.put("Name", user.getName());
         userObj.put("Limit", user.getLimit());
         userObj.put("Books", user.bookStatus());
         usersObj.put(Integer.toString(user.getId()), userObj);
      }
      out.println(usersObj.toString(4));
      out.close();
    }
    catch (Exception e)
    {
      System.out.println("exception: " + e.getMessage());
      e.printStackTrace();
    }
  }

  /**
   * Update the output filename for the object
   * @param userFilename The new filename
   */
  public void setUserFileName(String userFilename)
  {
    this.userFilename = userFilename;
  }

  /**
   * Adds a new User into this class
   * @param  name          Name of the User
   * @param  limit         Limit of Book the User can borrow
   * @return The new User that is just created
   */
  public User newUser(String name, int limit)
  {
    User temp = new User(name, id, limit);
    users.add(temp);

    id++;
    toJsonFile();

    return temp;
  }

  /**
   * Looks for the User with the given name
   * @param  name          Name of the User to be found
   * @return User with the given name
   */
  public User getUser(String name)
  {
    for (int i = 0; i < users.size(); i++)
    {
      User temp = users.get(i);

      if(temp.getName() == name)
      {
        return temp;
      }
    }

    throw new NullPointerException();
  }

  /**
   * Looks for a User with the given id
   * @param  index         id of the User to be found
   * @return User with the given id
   */
  public User getUser(int index)
  {
    return search(index, 0, users.size() - 1);
  }

  /**
   * Recursive binary search through the array list for the User with the given id
   * @param  index         id of the User to be found
   * @param  start         Starting point to search
   * @param  end           Ending point to search
   * @return User with the given id
   */
  private User search(int index, int start, int end)
  {
    if (start == end && users.get(start).getId() == index)
    {
      return users.get(start);
    }

    if (start >= end)
    {
      throw new NullPointerException();
    }

    int currentId = ((start + end) / 2);

    if (users.get(currentId).getId() == index)
    {
      return users.get(currentId);
    }
    else if (users.get(currentId).getId() > index)
    {
      return search(index, start, currentId - 1);
    }
    else
    {
      return search(index, currentId + 1, end);
    }
  }

  /**
   * Replacing a User in the array list with a new User
   * @param oldUser User to be replaced
   * @param newUser User replacing it
   */
  public void update(User oldUser, User newUser)
  {
    for (int i = 0; i < users.size(); i++)
    {
      User temp = users.get(i);

      if(temp.getId() == oldUser.getId())
      {
        users.set(i, newUser);
      }
    }

    toJsonFile();
  }
}
