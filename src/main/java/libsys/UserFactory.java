package libsys;
/*
 *  Written by : Bin Hong Lee
 *  Last edited : 5/30/2017
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

class UserFactory
{
  private List<User> users = new ArrayList<User>();
  private int id;
  private String userFilename;

  public UserFactory()
  {
    id = 0;
  }

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
    }
    catch (Exception ex)
    {
      System.out.println("Exception importing from json: " + ex.getMessage());
    }

    this.userFilename = userFilename;
    id = getUser(users.size()-1).getId() + 1;
  }

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

  public void setUserFileName(String userFilename)
  {
    this.userFilename = userFilename;
  }

  public User newUser(String name, int limit)
  {
    User temp = new User(name, id, limit);
    users.add(temp);

    id++;
    toJsonFile();

    return temp;
  }

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

  public User getUser(int index)
  {
    for (int i = 0; i < users.size(); i++)
    {
      User temp = users.get(i);

      if(temp.getId() == index)
      {
        return temp;
      }
    }

    throw new NullPointerException();
  }

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
