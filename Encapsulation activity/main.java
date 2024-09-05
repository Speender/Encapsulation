import java.util.Scanner;
public class main{
   public static void main (String... args){
      Scanner scan = new Scanner (System.in);
      int choice;
      Library library = new Library();
      Book b1 = new Book("Java", "Jewel Gesim", "111-1111-11", 100);
      Book b2 = new Book("Contemporary World", "Theo Pondar", "121-1222-12", 50);
      Book b3 = new Book("Again, But Better", "Sammy Rosal", "004-0024-2023", 150);
      
   
      do{
        System.out.println("-------WELCOME-------");
        System.out.println("[1] Display available books");
        System.out.println("[2] Create book");
        System.out.println("[3] Borrow book");
        System.out.println("[4] Return book");
        System.out.println("[5] Exit program");
        
        System.out.print("Enter your choice: ");
        choice = scan.nextInt();
      
      switch (choice){
         case 1:
            b1.display();
            b2.display();
            b3.display();
            library.creationDisplay(); 
            break;
         case 2:
            library.create();
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
            System.out.println("Program sucsessfully exited....");
            break;
          default:
               System.out.println("Invalid input");
      }
      }while(choice != 5);
   }
}