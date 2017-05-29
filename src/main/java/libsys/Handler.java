package libsys;
/*
 *  Written by : Bin Hong Lee
 *  Last edited : 5/28/2017
 */

import java.util.Calendar;
import org.json.JSONObject;

class Handler
{
  Exception BookNotFound = new Exception("Error 404 : Book not found");
  BookFactory books = new BookFactory();
  UserFactory users = new UserFactory();
  Calendar cal = Calendar.getInstance();

  public Handler()
  {

  }

  public boolean borrowBook(User user, Book book)
  {
    User newUser = user;
    Book newBook = book;

    if(("AVAILABLE".equals(book.getStatus())) && newUser.status() && newBook.rent(calDueDate(10)) && newUser.borrowNewBook(book.getId()))
    {
      books.update(book, newBook);
      users.update(user, newUser);

      books.toJsonFile("books.json");
      users.toJsonFile("users.json");

      return true;
    }

    return false;
  }

  public boolean returnBook(User user, Book book)
  {
    User newUser = user;
    Book newBook = book;

    if(newUser.returnBook(book.getId()))
    {
      book.returned();

      books.update(book, newBook);
      users.update(user, newUser);

      books.toJsonFile("books.json");
      users.toJsonFile("users.json");

      return true;
    }

    return false;
  }

  public int[] calDueDate(int days)
  {
    int[] dueDate = currentDay();

    for (int i = 0; i < days; i++)
    {
      if(dueDate[2] < 28)
      {
        dueDate[2]++;
      }
      else if(dueDate[1] == 12)
      {
        if(dueDate[2] == 31)
        {
          dueDate[0]++;
          dueDate[1] = 1;
          dueDate[2] = 1;
        }
      }
      else if(dueDate[1] == 2)
      {
        if((dueDate[0] % 4) == 0)
        {
          if(dueDate[2] == 29)
          {
            dueDate[1]++;
            dueDate[2] = 1;
          }
          else
          {
            dueDate[2]++;
          }
        }
        else if(dueDate[2] == 28)
        {
          dueDate[1]++;
          dueDate[2] = 1;
        }
        else
        {
          dueDate[2]++;
        }
      }
      else if(dueDate[1] == 4 || dueDate[1] == 6 || dueDate[1] == 9 || dueDate[1] == 11)
      {
        if(dueDate[2] == 30)
        {
          dueDate[1]++;
          dueDate[2] = 1;
        }
        else
        {
          dueDate[2]++;
        }
      }
      else if(dueDate[2] == 31)
      {
        dueDate[1]++;
        dueDate[2] = 1;
      }
      else
      {
        dueDate[2]++;
      }
    }

    return dueDate;
  }

  public int[] currentDay()
  {
    int[] currentDay = new int[3];

    currentDay[0] = cal.get(Calendar.YEAR);
    currentDay[1] = cal.get(Calendar.MONTH) + 1;
    currentDay[2] = cal.get(Calendar.DATE);

    return currentDay;
  }

  public String bookIdsToTitlesString(int[] bookIDs)
  {
    String titlesString = "";

    for (int i = 0; i < bookIDs.length; i++)
    {
      titlesString += books.getBook(bookIDs[i]).getTitle();
      titlesString += "; ";
    }

    return titlesString;
  }
}
