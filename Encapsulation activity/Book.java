// Wont be using this all classes are put in library class file
public class Book{
   private String title;
   private String author;
   private String isbn;
   private int availability;
   
   public Book (String title, String author, String isbn, int availability){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.availability = availability;
      }
   public String getTitle(){
      return this.title;
   }
   public String getAuthor(){
      return this.author;
   }
   public String getIsbn(){
      return this.isbn;
   }
   public int getAvailability(){
      return this.availability;
   }
   public void display(){
      System.out.println("Title: " + title);
      System.out.println("Author: " + author);
      System.out.println("International Standard Book Number: " + isbn);
      System.out.println("Available books: " + availability);
      System.out.println();
   }
   public void borrowBook() {
   if (availability > 0) {
      availability--;
      System.out.println("Book borrowed successfully.");
   } else {
      System.out.println("No available copies to borrow.");
   }
}
   public void returnBook() {
       availability++;
       System.out.println("Book returned successfully.");
    }
}
