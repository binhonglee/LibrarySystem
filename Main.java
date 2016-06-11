/*
 *  Written by : Bin Hong Lee
 *  Last edited : 5/31/2016
 */

import java.util.Date;

class Main
{
  Exception BookNotFound = new Exception("Error 404 : Book not found");
  static BookFactory books = new BookFactory();
  static UserFactory users = new UserFactory();
  static Date date = new Date();

  public static void main(String[] args)
  {

  }

  public static boolean returnBook(User user, Book book)
  {
    User newUser = user;

    if(newUser.returnBook(book.getId()))
    {
      book.returned();

      books.update(book);
      users.update(user, newUser);

      return true;
    }

    return false;
  }

  public static int[] calDueDate(int days)
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

  public static int[] currentDay()
  {
    int[] currentDay = new int[3];

    currentDay[0] = date.getYear() + 1900;
    currentDay[1] = date.getMonth() + 1;
    currentDay[2] = date.getDate();

    return currentDay;
  }
}
