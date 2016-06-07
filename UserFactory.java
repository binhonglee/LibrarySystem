/*
 *  Written by : Bin Hong Lee
 *  Last edited : 6/6/2016
 */

import java.util.*;

class UserFactory
{
  private List<User> users = new List<User>;
  private int id;

  public UserFactory()
  {
    id = 0;
  }

  public User newUser(String name; int limit)
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

  public void update(User old, User new)
  {
    for (int i = 0; i < users.size(); i++)
    {
      User temp = users.get(i);

      if(temp.getId() == old.getId())
      {
        users.set(i, new);
      }
    }
  }
}
