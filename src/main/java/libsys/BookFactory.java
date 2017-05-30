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

class BookFactory
{
  private List<Book> books = new ArrayList<Book>();
  private int id;
  private String bookFilename;

  public BookFactory()
  {
    id = 0;
  }

  public BookFactory(String bookFilename)
  {
    try
    {
      FileInputStream in = new FileInputStream(bookFilename);
      JSONObject obj = new JSONObject(new JSONTokener(in));
      String [] ids = JSONObject.getNames(obj);

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
      in.close();
    }
    catch (Exception ex)
    {
      System.out.println(ex.getMessage());
    }

    this.bookFilename = bookFilename;
    id = books.get(books.size() - 1).getId() + 1;
  }

  public void toJsonFile()
  {
    try
    {
      PrintWriter out = new PrintWriter(bookFilename);
      JSONObject booksObj = new JSONObject();
      for (int i = 0; i < books.size(); i++)
      {
         Book book = books.get(i);
         JSONObject bookObj = new JSONObject();
         bookObj.put("Title", book.getTitle());
         bookObj.put("Status", book.getStatus());
         bookObj.put("Due Date", book.getDueDate());
         booksObj.put(Integer.toString(book.getId()), bookObj);
      }
      out.println(booksObj.toString(4));
      out.close();
    }
    catch (Exception e)
    {
      System.out.println("exception: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public void setBookFileName(String bookFilename)
  {
    this.bookFilename = bookFilename;
  }

  public Book newBook(String title, String status)
  {
    Book temp = new Book(title, id, status);
    books.add(temp);

    id++;
    toJsonFile();

    return temp;
  }

  public Book getBook(int index)
  {
    return search(index, 0, books.size() - 1);
  }

  public Book search(int index, int start, int end)
  {
    if (start == end && books.get(start).getId() == index)
    {
      return books.get(start);
    }

    if (start >= end)
    {
      throw new NullPointerException();
    }

    int currentId = ((start + end) / 2);

    if (books.get(currentId).getId() == index)
    {
      return books.get(currentId);
    }
    else if (books.get(currentId).getId() > index)
    {
      return search(index, start, currentId - 1);
    }
    else
    {
      return search(index, currentId + 1, end);
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

  public void update(Book oldBook, Book newBook)
  {
    for (int i = 0; i < books.size(); i++)
    {
      Book temp = books.get(i);

      if(temp.getId() == oldBook.getId())
      {
        books.set(i, newBook);
      }
    }

    toJsonFile();
  }
}
