package libsys;
/*
 *  Written by : Bin Hong Lee
 *  Last edited : 7/4/2017
 */

/**
 * Main class
 */
public class Main
{
  private static Settings settings = new Settings("settings.txt");
  private static String bookFilename = settings.get("Books Filename");
  private static String userFilename = settings.get("Users Filename");

  /**
   * Start the application
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
