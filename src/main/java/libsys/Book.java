package libsys;
/*
 *  Written by : Bin Hong Lee
 *  Last edited : 6/4/2017
 */

public class Book
{
  private String title;
  private int id;
  private String status;
  private int[] dueDate = new int[3];

  /**
   * Create new Book with given id (Usually used as placeholders)
   * @param  id            Identification number of the Book
   */
  public Book(int id)
  {
    this.id = id;
    this.status = "NOT AVAILABLE";
  }

  /**
   * Create new Book with given title, id and status (Usually used for new Book creation)
   * @param  title         Title of the Book
   * @param  id            Identification number of the Book
   * @param  status        Status of the Book
   */
  public Book(String title, int id, String status)
  {
    this.title = title;
    this.id = id;
    this.status = status;
  }

  /**
   * Create new Book with given id, title, status and dueDate (Usually used for initialization from database)
   * @param  id            Identification number of the Book
   * @param  title         Title of the Book
   * @param  status        Status of the Book
   * @param  dueDate       Due date of the Book
   */
  public Book(int id, String title, String status, int[] dueDate)
  {
    this.title = title;
    this.id = id;
    this.status = status;
    this.dueDate = dueDate;
  }

  /**
   * Returns the title of the Book
   * @return title
   */
  public String getTitle()
  {
    if (title!=null)
    {
      return title;
    } else {
      return "UNDEFINED";
    }
  }

  /**
   * Returns the status of the Book
   * @return status (AVAILABLE || RENTED || RESERVED || NOT AVAILABLE)
   */
  public String getStatus()
  {
    return status;
  }

  /**
   * Returns the id of the Book
   * @return id
   */
  public int getId()
  {
    return id;
  }

  /**
   * Returns the due date of the Book
   * @return due date ([yyyy][mm][dd])
   */
  public int[] getDueDate()
  {
    return dueDate;
  }

  /**
   * Set the title to the given title
   * @param title The new title of the Book
   */
  public void setTitle(String title)
  {
    this.title = title;
  }

  /**
   * Call to rent book, return if renting is successful
   * @param  dueDate       The new due date of the Book
   * @return if renting is successful
   */
  public boolean rent(int[] dueDate)
  {
    //Check if the book is available to be rented
    if(!"AVAILABLE".equals(status))
    {
      return false;
    }

    //Update the due date of the book
    this.dueDate = dueDate;
    //Update book status
    status = "RENTED";
    return true;
  }

  /**
   * Return the Book to the shelf
   */
  public void returned()
  {
    //Update book status
    status = "AVAILABLE";
  }

  /**
   * Calculate the overdue fine
   * @param  currentDay    Today's date
   * @return Price of the fine
   */
  public double overdueFine(int[] currentDay)
  {
    double fine;
    boolean monChange = false;

    if(currentDay[0] < dueDate[0] || (currentDay[0] == dueDate[0] && currentDay[1] < dueDate[1]) || (currentDay[0] == dueDate[0] && currentDay[1] == dueDate[1] && currentDay[2] <= dueDate[2]))
    {
      return 0;
    }

    while(currentDay[0] > dueDate[0])
    {
      currentDay[0]--;
      currentDay[1]+=12;
    }

    while(currentDay[1] > dueDate[1])
    {
      int mon = currentDay[1] % 12;

      if(mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12)
      {
        currentDay[2]+=31;
      }
      else if(mon == 2)
      {
        currentDay[2]+=28;
      }
      else
      {
        currentDay[2]+=30;
      }

      currentDay[1]--;
    }

    fine = (double)(currentDay[2] - dueDate[2]) * 0.25;

    if(fine > 5)
    {
      return 5;
    }
    else
    {
      return fine;
    }
  }
}
