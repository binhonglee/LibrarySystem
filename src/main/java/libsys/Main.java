package libsys;
/*
 *  Written by : Bin Hong Lee
 *  Last edited : 5/28/2017
 */

class Main
{
  public static void main(String[] args)
  {
    Handler handler = new Handler();
    handler.books = new BookFactory("books.json");
    new MainGUI(handler).setVisible(true);
  }
}
