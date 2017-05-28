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

class BookFactory
{
  private List<Book> books = new ArrayList<Book>();
  private int id;

  public BookFactory()
  {
    id = 0;
  }

  public BookFactory(String jsonFileName)
  {
    try
    {
      System.out.println("Reading data from file...");
      FileInputStream in = new FileInputStream(jsonFileName);
      JSONObject obj = new JSONObject(new JSONTokener(in));
      String [] ids = JSONObject.getNames(obj);
      System.out.println();

      System.out.println("Parsing data into ArrayList...");
      for (int i = 0; i < ids.length; i++)
      {
        JSONObject jsonBook = obj.getJSONObject(ids[i]);
        int id = Integer.parseInt(ids[i]);
        String title = jsonBook.getString("Title");
        String status = jsonBook.getString("Status");
        JSONArray jsonDueDate = jsonBook.getJSONArray("Due Date");
        int [] dueDate = new int[jsonDueDate.length()];

        for (int j = 0; j < jsonDueDate.length(); j++)
        {
          dueDate[j] = jsonDueDate.optInt(j);
        }
        books.add(new Book(id, title, status, dueDate));
      }
      System.out.println();
    }
    catch (Exception ex)
    {
      System.out.println(ex.getMessage());
    }
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
