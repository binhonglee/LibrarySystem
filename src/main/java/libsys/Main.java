package libsys;
/*
 *  Written by : Bin Hong Lee
 *  Last edited : 5/28/2017
 */

class Main
{
  static String bookFilename = "books.json";
  static String userFilename = "users.json";

  public static void main(String[] args)
  {
    Handler handler = new Handler();
    handler.books = new BookFactory(bookFilename);
    handler.users = new UserFactory(userFilename);
    new MainGUI(handler).setVisible(true);
  }
}
