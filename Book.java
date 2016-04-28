/*
 *  Written by : Bin Hong Lee
 *  Last edited : 4/27/2016
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

  //Constructor with book title
  public Book(String title, int id)
  {
    this.title = title;
    this.id = id;
    this.status = "AVAILABLE";
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

  public void setTitle(String title)
  {
    this.title = title;
  }

  //Call to rent book, return if renting is successful
  public boolean rent(int[] dueDate)
  {
    //Check if the book is available to be rented
    if(status != "AVAILABLE")
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

    if(currentDay[0] > dueDate[0] || currentDay[1] > (dueDate[1] + 1))
    {
      return 5;
    }
    else if(currentDay[1] > dueDate[1])
    {
      fine = (double)(currentDay[2] + 30 - dueDate[2]) * 0.25;
    }
    else
    {
      fine = (double)(currentDay[2] - dueDate[2]) * 0.25;
    }

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
