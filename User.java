/*
 *  Written by : Bin Hong Lee
 *  Last edited : 6/4/2016
 */

class User
{
  private String name;
  private int id;
  private int limit;
  private List<int> books = new ArrayList<int>();

  public User(String name, int id, int limit)
  {
    this.name = name;
    this.id = id;
    this.limit = limit;
  }

  public String getName()
  {
    return name;
  }

  public void setName()
  {
    this.name = name;
  }

  public boolean status()
  {
    if (books.size() < limit)
    {
      if (bookStatus)
      {
        return true;
      }
    }

    return false;
  }

  public boolean borrowNewBook(int id)
  {
    if (status)
    {
      books.add(id);
      return true;
    }
    else
    {
      return false;
    }
  }
}
