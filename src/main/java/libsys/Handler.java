package libsys;
/*
 *  Written by : Bin Hong Lee
 *  Last edited : 6/4/2017
 */

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Handles all the background operations of MainGUI, also contains both UserFactory and BookFactory
 */
class Handler
{
  BookFactory books;
  UserFactory users;
  private Calendar cal = Calendar.getInstance();

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
  boolean borrowBook(User user, Book book)
  {
    AtomicReference<User> newUser = new AtomicReference<User>(user);
    AtomicReference<Book> newBook = new AtomicReference<Book>(book);

    if(("AVAILABLE".equals(book.getStatus())) && newUser.get().status() && newBook.get().rent(calDueDate(10)) && newUser.get().borrowNewBook(book.getId()))
    {
      books.update(book, newBook.get());
      users.update(user, newUser.get());

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
  boolean returnBook(User user, Book book)
  {
    AtomicReference<User> newUser = new AtomicReference<User>(user);
    AtomicReference<Book> newBook = new AtomicReference<Book>(book);

    if(newUser.get().returnBook(book.getId()))
    {
      book.returned();

      books.update(book, newBook.get());
      users.update(user, newUser.get());

      return true;
    }

    return false;
  }

  /**
   * Calculating the due date
   * @param  days          Amount of days to be borrowed
   * @return Amount of days added to the current day
   */
  private int[] calDueDate(int days)
  {
    return calDueDate(days, currentDay());
  }

  int[] calDueDate(int days, int[] date)
  {
    for (int i = 0; i < days; i++)
    {
      if(date[2] < 28)
      {
        date[2]++;
      }
      else if(date[1] == 12 && date[2] == 31)
      {
        date[0]++;
        date[1] = 1;
        date[2] = 1;
      }
      else if(date[1] == 2)
      {
        if((date[0] % 4) == 0)
        {
          if(date[2] == 29)
          {
            date[1]++;
            date[2] = 1;
          }
          else
          {
            date[2]++;
          }
        }
        else if(date[2] == 28)
        {
          date[1]++;
          date[2] = 1;
        }
        else
        {
          date[2]++;
        }
      }
      else if(date[1] == 4 || date[1] == 6 || date[1] == 9 || date[1] == 11)
      {
        if(date[2] == 30)
        {
          date[1]++;
          date[2] = 1;
        }
        else
        {
          date[2]++;
        }
      }
      else if(date[2] == 31)
      {
        date[1]++;
        date[2] = 1;
      }
      else
      {
        date[2]++;
      }
    }

    return date;
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
   * @return String of book titles separated with "; "
   */
  String bookIdsToTitlesString(int[] bookIDs)
  {
    StringBuilder titlesString = new StringBuilder();

    for (int bookID : bookIDs) {
      titlesString.append(books.getBook(bookID).getTitle());
      titlesString.append("; ");
    }

    return titlesString.toString();
  }
}
