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
    Book temp = new Book(id, "NOT AVAILABLE");
    books.add(temp);

    id++;
  }

  public Book getBook(int index)
  {
    return books.get(index);
  }
}
