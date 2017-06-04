package libsys;
/*
 *  Written by : Bin Hong Lee
 *  Last edited : 6/3/2017
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

  public User(String name, int id, int limit, ArrayList<Integer> books)
  {
    this.name = name;
    this.id = id;
    this.limit = limit;
    this.books = books;
  }

  public String getName()
  {
    return name;
  }

  public int getId()
  {
    return id;
  }

  public int getLimit()
  {
    return limit;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setLimit(int limit)
  {
    this.limit = limit;
  }

  public boolean status()
  {
    if (books.size() < limit)
    {
      return true;
    }

    return false;
  }

  public int[] bookStatus()
  {
    int[] currentBooks = new int[books.size()];

    for (int i = 0; i < books.size(); i++)
    {
      currentBooks[i] = books.get(i).intValue();
    }

    return currentBooks;
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
