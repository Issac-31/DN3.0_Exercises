import java.util.Arrays;

public class LibraryManagementSystem {
    private Book[] books;
    private int size;

    public LibraryManagementSystem(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    // Add a book to the list
    public void addBook(Book book) {
        if (size < books.length) {
            books[size] = book;
            size++;
            System.out.println("Book added: " + book);
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    // Linear search to find books by title
    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    // Binary search to find books by title (assuming the list is sorted)
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Sort books by title for binary search
    public void sortBooksByTitle() {
        Arrays.sort(books, 0, size, (book1, book2) -> book1.getTitle().compareToIgnoreCase(book2.getTitle()));
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem(5);

        Book book1 = new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("B002", "To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("B003", "1984", "George Orwell");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        System.out.println("\nPerforming Linear Search for '1984':");
        Book searchedBook = library.linearSearchByTitle("1984");
        if (searchedBook != null) {
            System.out.println("Book found: " + searchedBook);
        } else {
            System.out.println("Book not found.");
        }

        library.sortBooksByTitle();

        System.out.println("\nPerforming Binary Search for '1984':");
        searchedBook = library.binarySearchByTitle("1984");
        if (searchedBook != null) {
            System.out.println("Book found: " + searchedBook);
        } else {
            System.out.println("Book not found.");
        }
    }
}


class Book {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

