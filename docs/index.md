# Documentations

- [Book](#book)
- [Book Factory](#book-factory)

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
