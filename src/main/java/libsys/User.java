package libsys;
/*
 *  Written by : Bin Hong Lee
 *  Last edited : 6/6/2016
 */

import java.util.*;

class User
{
  private String name;
  private int id;
  private int limit;
  private List<Integer> books = new ArrayList<Integer>();

  public User(String name, int id, int limit)
  {
    this.name = name;
    this.id = id;
    this.limit = limit;
  }

  public String getName()
  {
    return name;
  }

  public int getId()
  {
    return id;
  }

  public void setName()
  {
    this.name = name;
  }

  public boolean status()
  {
    if (books.size() < limit)
    {
      return true;
    }

    return false;
  }

  public List<Integer> bookStatus()
  {
    return books;
  }

  public boolean borrowNewBook(int id)
  {
    if (status())
    {
      books.add(id);
      return true;
    }
    else
    {
      return false;
    }
  }

  public boolean returnBook(int id)
  {
    for (int i = 0; i < books.size(); i++)
    {
      if (books.get(i) == id)
      {
        books.remove(i);
        return true;
      }
    }

    return false;
  }
}
