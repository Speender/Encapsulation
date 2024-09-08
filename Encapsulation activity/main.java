import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        Library library = new Library();

        // Adding some pre-determined books to the library
        library.addBook(new Book("Java", "Jewel Gesim", "111-1111-11", 100));
        library.addBook(new Book("Contemporary World", "Theo Pondar", "121-1222-12", 50));
        library.addBook(new Book("Again, But Better", "Sammy Rosal", "004-0024-23", 150));

        // Main Menu
        do {
            System.out.println("********************************");
            System.out.println("[1] Display available books");
            System.out.println("[2] Create book");
            System.out.println("[3] Borrow book");
            System.out.println("[4] Return book");
            System.out.println("[5] Exit program");
            System.out.println("********************************");
            System.out.print("Enter your choice: ");
            
            try {
                choice = scan.nextInt();
                scan.nextLine();

                switch (choice) {
                    case 1:
                        library.displayBooks();
                        break;
                    case 2:
                        library.createBook();
                        break;
                    case 3:
                        System.out.print("Enter the ISBN of the book to borrow: ");
                        String isbnToBorrow = scan.nextLine();
                        library.borrowBook(isbnToBorrow);
                        break;
                    case 4:
                        System.out.print("Enter the ISBN of the book to return: ");
                        String isbnToReturn = scan.nextLine();
                        library.returnBook(isbnToReturn);
                        break;
                    case 5:
                        System.out.println("Program successfully exited.");
                        break;
                    default:
                        // Default error catcher
                        System.out.println("Invalid input. Please enter a number between 1 and 5.");
                }
                // Input string error catcher returns to main menu if invalid
            } catch (InputMismatchException e) {
                // Handle non-integer input for menu choices
                System.out.println("Invalid input. Please enter a valid number.");
                scan.nextLine(); 
            }
        } while (choice != 5); // Continue the loop until the user selects option 5 to exit
    }
}
