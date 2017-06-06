package libsys;
/*
 *  Written by : Bin Hong Lee
 *  Last edited : 6/4/2017
 */

import java.util.List;
import java.util.ArrayList;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONArray;
import java.io.FileInputStream;
import java.io.PrintWriter;

/**
 * Handles all the Book(s)
 */
public class BookFactory
{
  private List<Book> books = new ArrayList<Book>();
  private int id;
  private String bookFilename;

  /**
   * Create a new empty BookFactory
   */
  public BookFactory()
  {
    id = 0;
    bookFilename = "books.json";
  }

  /**
   * Create a new BookFactory and fill it with information from a JSON file
   * @param  bookFilename  Name of the input JSON file
   */
  public BookFactory(String bookFilename)
  {
    try
    {
      FileInputStream in = new FileInputStream(bookFilename);
      JSONObject obj = new JSONObject(new JSONTokener(in));
      String [] ids = JSONObject.getNames(obj);

      for (String id1 : ids) {
        JSONObject jsonBook = obj.getJSONObject(id1);
        int id = Integer.parseInt(id1);
        String title = jsonBook.getString("Title");
        String status = jsonBook.getString("Status");
        JSONArray jsonDueDate = jsonBook.getJSONArray("Due Date");
        int[] dueDate = new int[jsonDueDate.length()];

        for (int j = 0; j < jsonDueDate.length(); j++) {
          dueDate[j] = jsonDueDate.optInt(j);
        }
        books.add(new Book(id, title, status, dueDate));
      }
      in.close();
      id = books.get(books.size() - 1).getId() + 1;
    }
    catch (Exception ex)
    {
      System.out.println(ex.getMessage());
      id = 0;
    }

    this.bookFilename = bookFilename;
  }

  /**
   * Output the data into a JSON file replacing the input file (or if filename not given, "books.json")
   */
  void toJsonFile()
  {
    try
    {
      PrintWriter out = new PrintWriter(bookFilename);
      JSONObject booksObj = new JSONObject();
      for (Book book : books) {
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

  /**
   * Update the output filename for the object
   * @param bookFilename The new filename
   */
  void setBookFileName(String bookFilename)
  {
    this.bookFilename = bookFilename;
  }

  /**
   * Adds a new Book into this class
   * @param  title         Title of the Book
   * @param  status        Status of the Book
   * @return The new Book that is just created
   */
  Book newBook(String title, String status)
  {
    Book temp = new Book(title, id, status);
    books.add(temp);

    id++;
    toJsonFile();

    return temp;
  }

  /**
   * Looks for a Book with the given id
   * @param  index         id of the Book to be found
   * @return Book with the given id
   */
  public Book getBook(int index)
  {
    return search(index, 0, books.size() - 1);
  }

  /**
   * Recursive binary search through the array list for the Book with the given id
   * @param  index         id of the Book to be found
   * @param  start         Starting point to search
   * @param  end           Ending point to search
   * @return Book with the given id
   */
  private Book search(int index, int start, int end)
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

  /**
   * Linear search through the array list for Book with the given Title
   * @param  title         Title of the Book to be found
   * @return Book with the given title
   */
  public Book getBook(String title)
  {
    for (Book temp : books) {
      if (temp.getTitle().equals(title)) {
        return temp;
      }
    }

    throw new NullPointerException();
  }

  /**
   * Replacing a Book in the array list with a new Book
   * @param oldBook Book to be replaced
   * @param newBook Book replacing it
   */
  public void update(Book oldBook, Book newBook)
  {
    boolean found = false;
    for (int i = 0; i < books.size(); i++)
    {
      Book temp = books.get(i);

      if(temp.getId() == oldBook.getId())
      {
        books.set(i, newBook);
        found = true;
      }
    }

    if (!found)
    {
      throw new NullPointerException();
    }

    toJsonFile();
  }
}
