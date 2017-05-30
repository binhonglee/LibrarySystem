package libsys;
/*
 *  Written by : Bin Hong Lee
 *  Last edited : 5/30/2017
 */

class Book
{
  //Declaring variable storages
  //Book title
  private String title;
  //Book ID
  private int id;
  //( AVAILABLE || RENTED || RESERVED || NOT AVAILABLE)
  private String status;
  //Book due date
  private int[] dueDate = new int[3];

  //Constructor without book title
  public Book(int id)
  {
    this.id = id;
    this.status = "NOT AVAILABLE";
  }

  public Book(String title, int id, String status)
  {
    this.title = title;
    this.id = id;
    this.status = status;
  }

  public Book(int id, String title, String status, int[] dueDate)
  {
    this.title = title;
    this.id = id;
    this.status = status;
    this.dueDate = dueDate;
  }

  //Getters and setters
  public String getTitle()
  {
    if (title!=null)
    {
      return title;
    } else {
      return "UNDEFINED";
    }
  }

  public String getStatus()
  {
    return status;
  }

  public int getId()
  {
    return id;
  }

  public int[] getDueDate()
  {
    return dueDate;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  //Call to rent book, return if renting is successful
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

  //Call to return the book
  public void returned()
  {
    //Update book status
    status = "AVAILABLE";
  }

  //Calculate the overdue fine
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
