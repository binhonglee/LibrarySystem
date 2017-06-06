package libsys;
/*
 *  Written by : Bin Hong Lee
 *  Last edited : 6/4/2017
 */

import java.util.*;

/**
 * User object
 */
public class User
{
  private String name;
  private int id;
  private int limit;
  private List<Integer> books = new ArrayList<Integer>();

  /**
   * Creates a new User with name, id and limit (usually used to add new User)
   * @param  name          Name of this User
   * @param  id            id of this User
   * @param  limit         Limit of Book this User can borrow
   */
  public User(String name, int id, int limit)
  {
    this.name = name;
    this.id = id;
    this.limit = limit;
  }

  /**
   * Creates a new User with name, id, limit and books (usually used to initialize from database)
   * @param  name          Name of this User
   * @param  id            id of this User
   * @param  limit         Limit of Book this User can borrow
   * @param  books         ArrayList of Book ids borrowed by the User
   */
  public User(String name, int id, int limit, ArrayList<Integer> books)
  {
    this.name = name;
    this.id = id;
    this.limit = limit;
    this.books = books;
  }

  /**
   * Gets name of this User
   * @return Name
   */
  public String getName()
  {
    return name;
  }

  /**
   * Gets id of this User
   * @return id
   */
  public int getId()
  {
    return id;
  }

  /**
   * Gets limit of Book this User can borrow
   * @return Book borrowing limit
   */
  public int getLimit()
  {
    return limit;
  }

  /**
   * Change name of this User
   * @param name New name of the User
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * Change limit of this User
   * @param limit New limit of the User
   */
  public void setLimit(int limit)
  {
    this.limit = limit;
  }

  /**
   * Check status of the User
   * @return If the User is already at the borrowing limit
   */
  public boolean status()
  {
    return books.size() < limit;

  }

  /**
   * Get Book ids of the books
   * @return Array of Book ids borrowed by this User
   */
  public int[] bookStatus()
  {
    int[] currentBooks = new int[books.size()];

    for (int i = 0; i < books.size(); i++)
    {
      currentBooks[i] = books.get(i);
    }

    return currentBooks;
  }

  /**
   * User borrows a Book
   * @param  id            id of the Book to tbe borrowed
   * @return If the borrowing operation is successful
   */
  boolean borrowNewBook(int id)
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

  /**
   * User returns a Book
   * @param  id            id of the Book to be returned
   * @return If the returning operation is successful
   */
  boolean returnBook(int id)
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
