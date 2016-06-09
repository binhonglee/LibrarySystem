/*
 *  Written by : Bin Hong Lee
 *  Last edited : 6/7/2016
 */

import java.util.*;

class UserFactory
{
  private List<User> users = new ArrayList<User>();
  private int id;

  public UserFactory()
  {
    id = 0;
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
