package libsys;
/*
 *  Written by : Bin Hong Lee
 *  Last edited : 6/4/2017
 */

import java.util.Calendar;
import org.json.JSONObject;

class Handler
{
  Exception BookNotFound = new Exception("Error 404 : Book not found");
  BookFactory books;
  UserFactory users;
  Calendar cal = Calendar.getInstance();

  /**
   * Creates new empty Handler
   */
  public Handler()
  {

  }

  /**
   * Given User borrows the given Book
   * @param  user          User borrowing the Book
   * @param  book          Book to be borrowed
   * @return If the borrow operation is successful
   */
  public boolean borrowBook(User user, Book book)
  {
    User newUser = user;
    Book newBook = book;

    if(("AVAILABLE".equals(book.getStatus())) && newUser.status() && newBook.rent(calDueDate(10)) && newUser.borrowNewBook(book.getId()))
    {
      books.update(book, newBook);
      users.update(user, newUser);

      return true;
    }

    return false;
  }

  /**
   * Given User returns the given Book
   * @param  user          User returning the Book
   * @param  book          Book to be returned
   * @return If the return operation is successful
   */
  public boolean returnBook(User user, Book book)
  {
    User newUser = user;
    Book newBook = book;

    if(newUser.returnBook(book.getId()))
    {
      book.returned();

      books.update(book, newBook);
      users.update(user, newUser);

      return true;
    }

    return false;
  }

  /**
   * Calculating the due date
   * @param  days          Amount of days to be borrowed
   * @return Amount of days added to the current day
   */
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

  /**
   * Returns the current date in an int array
   * @return date in ([YYYY][MM][DD]) format
   */
  private int[] currentDay()
  {
    int[] currentDay = new int[3];

    currentDay[0] = cal.get(Calendar.YEAR);
    currentDay[1] = cal.get(Calendar.MONTH) + 1;
    currentDay[2] = cal.get(Calendar.DATE);

    return currentDay;
  }

  /**
   * Create a String of all book titles with the given Book ids
   * @param  bookIDs       Array of Book ids
   * @return String of book titles seperated with "; "
   */
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
