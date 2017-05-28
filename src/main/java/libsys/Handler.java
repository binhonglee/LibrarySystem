package libsys;

import java.util.Calendar;
import org.json.JSONObject;

class Handler
{
  Exception BookNotFound = new Exception("Error 404 : Book not found");
  BookFactory books = new BookFactory();
  UserFactory users = new UserFactory();
  Calendar cal;

  public boolean borrowBook(User user, Book book)
  {
    User newUser = user;

    if(book.getStatus() == "AVAILABLE" && newUser.status())
    {
      book.rent(calDueDate(10));
      newUser.borrowNewBook(book.getId());

      books.update(book);
      users.update(user, newUser);

      return true;
    }

    return false;
  }

  public boolean returnBook(User user, Book book)
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

    currentDay[0] = cal.get(Calendar.YEAR) + 1900;
    currentDay[1] = cal.get(Calendar.MONTH) + 1;
    currentDay[2] = cal.get(Calendar.DAY_OF_MONTH);

    return currentDay;
  }
}
