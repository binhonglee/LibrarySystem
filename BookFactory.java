/*
 *  Written by : Bin Hong Lee
 *  Last edited : 4/27/2016
 */

import java.util.*;

class BookFactory
{
  private List<Book> books = new ArrayList<Book>();
  private int id;

  public BookFactory()
  {
    id = 0;
  }

  public void newBook()
  {
    Book temp = new Book(id);
    books.add(temp);

    id++;
  }

  public void newBook(String title)
  {
    Book temp = new Book(title, id);
    books.add(temp);

    id++;
  }

  public Book getBook(int index)
  {
    return books.get(index);
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

    System.out.println("Error 404 : Book not found");

    Book empty = new Book();
    return empty;
  }
}
