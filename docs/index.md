# Documentations

- [Main](#main)
- [Book](#book)
- [Book Factory](#book-factory)
- [User](#user)
- [User Factory](#user-factory)


# Main

## Functions

| Return | Method | Description |
|:-------|:-------|:------------|
| boolean | borrowBook(User user, Book book) | Return if the borrow of the book on both `BookFactory` and `UserFactory` is successful
| boolean | returnBook(User user, Book book) | Return if the return of the book on both `BookFactory` and `UserFactory` is successful
| int[] | calDueDate(int days) | Calculate the due date from the current date according to user's permission
| int[] | currentDay() | Returns the current date in an array form |

# Book

## Constructors

| Method | Description |
|:-------|:------------|
| Book(int id) | Create a book with a specific id |
| Book(String title, int id) | Create a book with specific id and title |

## Functions

| Return | Method | Description |
|:-------|:-------|:------------|
| String | getTitle() | Returns the title of the book |
| String | getStatus() | Returns the status of the book |
| String | getId() | Returns the id of the book |
| void | setTitle() | Set the title of the book |
| boolean | rent(int[] dueDate) | Returns if the rent action is successful and set the due date to the given input |
| void | returned() | Return the book |
| double | overdueFine(int[] currentDay) | Calculate and return the amount of fine to be charged<br>(Fine rate is 0.25 per day; Max fine is 5) |

# Book Factory

## Constructors

| Method | Description |
|:-------|:------------|
| BookFactory() | Creates an empty BookFactory |

## Functions

| Return | Method | Description |
|:-------|:-------|:------------|
| Book | newBook(String title) | Creates a new Book with the given title and returns it |
| Book | getBook(int index) | Returns the book of the given index if it exist, else throw null pointer exception |
| Book | getBook(String title) | Returns the book of the given title if it exist, else throw null pointer exception |
| void | update(Book newbook) | Replaces the existing book of the same id with this new one |

# User

## Constructors

| Method | Description |
|:-------|:------------|
| User(String name, int id, int limit) | Create a new User with given name, id and limit |

## Functions

| Return | Method | Description |
|:-------|:-------|:------------|
| String | getName() | Returns the name of the user |
| int | getId() | Returns id of the user |
| void | setName() | Set the name of the user |
| boolean | status() | Check if the user reached the limit of amount of books the user can borrow |
| List<Integer> | bookStatus() | Return a list consisting of book ids for all the books rented by the user |
| boolean | borrowNewBook(int id) | Check if the user status if true then add the id to the list of the books borrowed by the user |
| boolean | returnBook(int id) | Check if the book is borrowed by the user then remove it from the list |

# User Factory

## Constructors

| Method | Description |
|:-------|:------------|
| UserFactory() | Creates a new empty factory |

## Functions

| Return | Method | Description |
|:-------|:-------|:------------|
| User | newUser(String name, int limit) | Creates a new user and returns the created user |
| User | getUser(String name) | Gets the user with the given name from the factory |
| User | getUser(int index) | Gets the user with the given id from the factory |
| void | update(User oldUser, User newUser) | Update by replacing the existing user with the new one |
