package libsys;
/*
 *  Written by : Bin Hong Lee
 *  Last edited : 5/28/2017
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
      System.out.println();

      System.out.println("Parsing data into ArrayList...");
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
      System.out.println();
      in.close();
    }
    catch (Exception ex)
    {
      System.out.println("Exception importing from json: " + ex.getMessage());
    }
  }

  public User newUser(String name, int limit)
  {
    User temp = new User(name, id, limit);
    users.add(temp);

    id++;

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
  }
}
