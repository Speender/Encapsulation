import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    // Method to display all books in the library
    public void displayBooks() {
        for (Book book : books) { 
            book.display();
        }
    }

    // Method to create a new book and add it to the library
    public void createBook() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter book title: ");
        String title = scan.nextLine();

        System.out.println("Enter book author: ");
        String author = scan.nextLine();

        // Variables to hold and validate the ISBN
        String isbn;
        boolean validISBN;
        boolean uniqueISBN;

        // Loop until a valid and unique ISBN is entered
        do {
            System.out.println("Enter book ISBN (format: xxx-xxxx-xx): ");
            isbn = scan.nextLine();

            // ISBN format validation
            validISBN = isbn.matches("\\d{3}-\\d{4}-\\d{2}");
            uniqueISBN = true;

            if (!validISBN) {
                System.out.println("Invalid ISBN format. Please follow xxx-xxxx-xx format.");
            } else {
                // Ensure the ISBN is unique
                for (Book book : books) {
                    if (book.getIsbn().equals(isbn)) {
                        System.out.println("ISBN already exists. Please enter a unique ISBN.");
                        uniqueISBN = false;
                        break;
                    }
                }
            }
        } while (!validISBN || !uniqueISBN);

        // Prompt for number of available copies
        System.out.println("Enter number of available copies: ");
        int availableCopies = scan.nextInt();
        scan.nextLine();

        // Create a new book object and add it to the library
        Book newBook = new Book(title, author, isbn, availableCopies);
        addBook(newBook);

        System.out.println("Book added successfully.");
    }

    // Method to borrow a book from the library using its ISBN
    public void borrowBook(String isbn) {
        Scanner scan = new Scanner(System.in);
        for (Book book : books) { 
            if (book.getIsbn().equals(isbn)) { 
                int numCopies;
                // Loop, to check if the number borrowed exxceeded prompts the user not enough copies and asks again how many to borrow
                do {
                    System.out.print("Enter the number of copies to borrow: ");
                    numCopies = scan.nextInt();
                    scan.nextLine();

                    if (numCopies <= book.getAvailableCopies()) {
                        book.borrowCopies(numCopies); /
                        System.out.println("Book borrowed successfully.");
                        break; 
                    } else {
                        System.out.println("Not enough copies available to borrow. Try again.");
                    }
                } while (true); 
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Method to return a borrowed book to the library
    public void returnBook(String isbn) {
        Scanner scan = new Scanner(System.in);
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) { 
                if (book.getBorrowedCopies() > 0) { // Error checker, if the user has not borrowed anything they cannot return
                    int numCopies;
                    do {
                        System.out.print("Enter the number of copies to return: ");
                        numCopies = scan.nextInt();
                        scan.nextLine();

                        // Ensure they are not returning more than they borrowed
                        if (numCopies > book.getBorrowedCopies()) {
                            System.out.println("You cannot return more copies than you have borrowed.");
                        } else {
                            book.returnCopies(numCopies); 
                            break; 
                        }
                    } while (true); 
                } else {
                    System.out.println("You haven't borrowed any copies of this book.");
                }
                return; 
            }
        }
        // If no book matches the ISBN
        System.out.println("Book not found.");
    }

}

class Book {
    private String title; 
    private String author; 
    private String isbn; 
    private int availableCopies; 
    private int borrowedCopies; 

    // Constructor
    public Book(String title, String author, String isbn, int availableCopies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.availableCopies = availableCopies;
        this.borrowedCopies = 0;
    }

    // Getter for book title
    public String getTitle() {
        return title;
    }

    // Getter for book author
    public String getAuthor() {
        return author;
    }

    // Getter for book ISBN
    public String getIsbn() {
        return isbn;
    }

    // Getter for available copies
    public int getAvailableCopies() {
        return availableCopies;
    }

    // Getter for borrowed copies
    public int getBorrowedCopies() {
        return borrowedCopies;
    }

    // Method for available copies display
    public void display() {
        System.out.println("===============================");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Available Copies: " + availableCopies);
        System.out.println("Borrowed Copies: " + borrowedCopies);
        System.out.println();
    }

    // Method to borrow a number of copies of the book
    public void borrowCopies(int numCopies) {
        if (numCopies <= availableCopies) {
            availableCopies -= numCopies; 
            borrowedCopies += numCopies; 
        }
    }

    // Method to return a number of copies of the book
    public void returnCopies(int numCopies) {
        availableCopies += numCopies;
        borrowedCopies -= numCopies;
        System.out.println("Book returned successfully.");
    }
}
