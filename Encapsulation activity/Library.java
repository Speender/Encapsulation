import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Display all books in the library
    public void displayBooks() {
        for (Book book : books) {
            book.display();
        }
    }

    // Create a new book and add it to the library
    public void createBook() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter book title: ");
        String title = scan.nextLine();

        System.out.println("Enter book author: ");
        String author = scan.nextLine();

        String isbn;
        boolean uniqueISBN;
        do {
            System.out.println("Enter book ISBN: ");
            isbn = scan.nextLine();

            uniqueISBN = true;
            // Unique ISBN error catching
            for (Book book : books) {
                if (book.getIsbn().equals(isbn)) {
                    System.out.println("ISBN already exists. Please enter a unique ISBN.");
                    uniqueISBN = false;
                    break;
                }
            }
        } while (!uniqueISBN);

        System.out.println("Enter number of available copies: ");
        int availableCopies = scan.nextInt();
        scan.nextLine();

        Book newBook = new Book(title, author, isbn, availableCopies);
        addBook(newBook);

        System.out.println("Book added successfully.");
    }

    // Borrow a book from the library
    public void borrowBook(String isbn) {
        Scanner scan = new Scanner(System.in);
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                System.out.print("Enter the number of copies to borrow: ");
                int numCopies = scan.nextInt();
                scan.nextLine();

                if (numCopies <= book.getAvailableCopies()) {
                    book.borrowCopies(numCopies);
                    System.out.println("Book borrowed successfully.");
                } else {
                    System.out.println("Not enough copies available to borrow.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Return a book to the library
    public void returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

class Book {
    private String title;
    private String author;
    private String isbn;
    private int availableCopies;

    public Book(String title, String author, String isbn, int availableCopies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.availableCopies = availableCopies;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    // Display book details
    public void display() {
        System.out.println("===============================");
        System.out.println("\nTitle: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Available Copies: " + availableCopies);
        System.out.println();
    }

    // Borrow copies of the book
    public void borrowCopies(int numCopies) {
        if (numCopies <= availableCopies) {
            availableCopies -= numCopies;
        }
    }

    // Return a book
    public void returnBook() {
        availableCopies++;
        System.out.println("Book returned successfully.");
    }
}
