import java.util.*;

interface Logs {
    void log(String message);
}

class ImplementLog implements Logs {
    @Override
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}


class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrow() {
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable;
    }
}


class Library {
    private Map<String, Book> books;
    private Logs logs;

    public Library(Logs logs) {
        this.books = new HashMap<>();
        this.logs = logs;
    }

    public void addBook(String bookId, String title, String author) {
        if (bookId == null || bookId.isEmpty() || title == null || title.isEmpty() || author == null || author.isEmpty()) {
            logs.log("Error: Book details are invalid.");
            return;
        }
        if (books.containsKey(bookId)) {
            logs.log("Error: Book ID must be unique.");
            return;
        }
        books.put(bookId, new Book(bookId, title, author));
        logs.log("Book added successfully: " + title);
    }

    public void borrowBook(String bookId) {
        Book book = books.get(bookId);
        if (book == null) {
            logs.log("Error: Book with ID " + bookId + " does not exist.");
            return;
        }
        if (!book.isAvailable()) {
            logs.log("Error: Book " + book.getTitle() + " is already borrowed.");
            return;
        }
        book.borrow();
        logs.log("Book borrowed successfully: " + book.getTitle());
    }

    public void returnBook(String bookId) {
        Book book = books.get(bookId);
        if (book == null) {
            logs.log("Error: Book with ID " + bookId + " does not belong to the library.");
            return;
        }
        if (book.isAvailable()) {
            logs.log("Error: Book " + book.getTitle() + " was not borrowed.");
            return;
        }
        book.returnBook();
        logs.log("Book returned successfully: " + book.getTitle());
    }

    public void viewAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books.values()) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }
}
public class LibraryManagementSystem{
    public static void main(String [] args){
        Logs logs = new ImplementLog();
        Library library = new Library(logs);
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View Available Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(bookId, title, author);
                    break;
                case 2:
                    System.out.print("Enter Book ID to borrow: ");
                    bookId = sc.nextLine();
                    library.borrowBook(bookId);
                    break;
                case 3:
                    System.out.print("Enter Book ID to return: ");
                    bookId = sc.nextLine();
                    library.returnBook(bookId);
                    break;
                case 4:
                    library.viewAvailableBooks();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }
}