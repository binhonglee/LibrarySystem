class Book
{
  private int id;
  //( AVAILABLE || RENTED || RESERVED || NOT AVAILABLE)
  private String status;
  private int[] dueDate = new int[3];

  public Book(int id, String status)
  {
    this.id = id;
    this.status = status;
  }

  public String getStatus()
  {
    return status;
  }

  public boolean rent(int[] dueDate)
  {
    if(status != "AVAILABLE")
    {
      return false;
    }

    this.dueDate = dueDate;
    status = "RENTED";
    return true;
  }

  public void returned()
  {
    status = "AVAILABLE";
  }

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
