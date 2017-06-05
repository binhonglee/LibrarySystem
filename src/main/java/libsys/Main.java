package libsys;
/*
 *  Written by : Bin Hong Lee
 *  Last edited : 6/4/2017
 */

public class Main
{
  static Settings settings = new Settings("settings.txt");
  static String bookFilename = settings.get("Books Filename");
  static String userFilename = settings.get("Users Filename");

  /**
   * Start the applicationn
   * @param args
   */
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

    new MainGUI(handler, settings).setVisible(true);
  }
}
