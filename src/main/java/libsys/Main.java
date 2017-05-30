package libsys;
/*
 *  Written by : Bin Hong Lee
 *  Last edited : 5/30/2017
 */

class Main
{
  static String bookFilename = "books.json";
  static String userFilename = "users.json";

  public static void main(String[] args)
  {
    Handler handler = new Handler();

    try
    {
      handler.books = new BookFactory(bookFilename);
    }
    catch (Exception e)
    {
      System.out.println("Book Exception");
      handler.books = new BookFactory();
      handler.books.setBookFileName(bookFilename);
    }

    try
    {
      handler.users = new UserFactory(userFilename);
    }
    catch (Exception e)
    {
      System.out.println("User Exception");
      handler.users = new UserFactory();
      handler.users.setUserFileName(userFilename);
    }

    new MainGUI(handler).setVisible(true);
  }
}
