package libsys;
/*
 *  Written by : Bin Hong Lee
 *  Last edited : 5/28/2017
 */

import java.util.*;
import org.json.JSONString;
import org.json.JSONObject;
import org.json.JSONTokener;

class BookFactory
{
  private List<Book> books = new ArrayList<Book>();
  private int id;

  public BookFactory()
  {
    id = 0;
  }

  public Book newBook(String title)
  {
    Book temp = new Book(title, id);
    books.add(temp);

    id++;

    return temp;
  }

  public Book getBook(int index)
  {
    try
    {
      return books.get(index);
    }
    catch (Exception e)
    {
      throw new NullPointerException();
    }
  }

  public Book getBook(String title)
  {
    for (int i = 0; i < books.size(); i++)
    {
      Book temp = books.get(i);

      if(temp.getTitle() == title)
      {
        return temp;
      }
    }

    throw new NullPointerException();
  }

  public void update(Book newBook)
  {
    for (int i = 0; i < books.size(); i++)
    {
      Book temp = books.get(i);

      if(temp.getId() == newBook.getId())
      {
        books.set(i, newBook);
      }
    }
  }
}
