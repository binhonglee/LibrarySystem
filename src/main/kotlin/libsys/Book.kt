package libsys

/*
 *  Written by : Bin Hong Lee
 *  Last edited : 7/4/2017
 */

/**
 * Book object
 */
class Book
{
    /**
     * Title of the Book
     */
    var title: String? = null
        set
        get()
        {
            if (field != null)
            {
                return field
            }
            else
            {
                return "UNDEFINED"
            }
        }

    /**
     * ID of the Book
     */
    var id: Int = 0
        private set
    /**
     * Status of the Book ( AVAILABLE | NOT AVAILABLE | RESERVED | RENTED )
     */
    var status: String? = null
        private set
    /**
     * Due date for the book to be returned (if rented)
     */
    var dueDate = IntArray(3)
        private set
        get

    /**
     * Create new Book with given id (Usually used as placeholders)
     * @param  id            Identification number of the Book
     */
    constructor(id: Int) {
        this.id = id
        this.status = "NOT AVAILABLE"
    }

    /**
     * Create new Book with given title, id and status (Usually used for new Book creation)
     * @param  title         Title of the Book
     * @param  id            Identification number of the Book
     * @param  status        Status of the Book
     */
    constructor(title: String, id: Int, status: String) {
        this.title = title
        this.id = id
        this.status = status
    }

    /**
     * Create new Book with given id, title, status and dueDate (Usually used for initialization from database)
     * @param  id            Identification number of the Book
     * @param  title         Title of the Book
     * @param  status        Status of the Book
     * @param  dueDate       Due date of the Book
     */
    constructor(id: Int, title: String, status: String, dueDate: IntArray) {
        this.title = title
        this.id = id
        this.status = status
        this.dueDate = dueDate
    }

    /**
     * Call to rent book, return if renting is successful
     * @param  dueDate       The new due date of the Book
     * @return if renting is successful
     */
    fun rent(dueDate: IntArray): Boolean {
        //Check if the book is available to be rented
        if ("AVAILABLE" != status) {
            return false
        }

        //Update the due date of the book
        this.dueDate = dueDate
        //Update book status
        status = "RENTED"
        return true
    }

    /**
     * Return the Book to the shelf
     */
     fun returned() {
        //Update book status
        status = "AVAILABLE"
    }

    /*
     * Calculate the overdue fine
     * @param  currentDay    Today's date
     * @return Price of the fine
     */

    /*
      public double overdueFine(int[] currentDay)
      {
        double fine;

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
      */
}
