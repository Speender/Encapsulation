import java.util.ArrayList;
import java.util.Scanner;

public class Library {
   private ArrayList<Book> books;
   
   public Library() {
      books = new ArrayList<>();
   }

   public void create() {
      Scanner scan = new Scanner(System.in);

      String title, author, isbn;
      int availableCopies;
      boolean uniqueISBN = false;
      
      System.out.println("Enter book title: ");
      title = scan.nextLine();

      System.out.println("Enter book author: ");
      author = scan.nextLine();
      
      do {
         System.out.println("Enter book ISBN: ");
         isbn = scan.nextLine();
         
         uniqueISBN = true;
         for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
               System.out.println("ISBN already exists. Please enter a unique ISBN.");
               uniqueISBN = false;
               break;
            }
         }
      } while (!uniqueISBN);


      System.out.println("Enter number of available copies: ");
      availableCopies = scan.nextInt();

      Book newBook = new Book(title, author, isbn, availableCopies);
      books.add(newBook);

      System.out.println("Book added successfully.");
   }

   public void creationDisplay() {
      if (books.isEmpty()) {
         System.out.println("These are the only books available; there are no books recently added.");
      } else {
         for (Book book : books) {
            book.display();
         }
      }
   }
   public void borrowBook(String isbn){
   for(Book book: books){
      if(book.getIsbn().equals(isbn)){
         book.borrowBook();
         return;
      }
   }
   System.out.println("Book not found.");
 }
   public void returnBook(String isbn){
      for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
