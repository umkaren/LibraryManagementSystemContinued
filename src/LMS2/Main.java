package LMS2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create some books
        Book book1 = new Book("Sleep", "Karen", 2021, 620, "Fiction");
        Book book2 = new Book("Cook", "Karein", 2011, 100, "Non-Fiction");
        Book book3 = new Book("Crime", "Caran", 2011, 550, "Fiction");

        // Create a library
        Library library = new Library();

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Remove a book from the library
        library.removeBook("Cook");

        // Find books by publication year
        List<Book> booksByYear = library.findBooksByPublicationYear(2011);
        System.out.println(booksByYear);

        // Find books by author
        List<Book> booksByAuthor = library.booksByAuthor("Karen");
        System.out.println(booksByAuthor);

        // Find the book with the most pages
        Book bookWithMostPages = library.mostPages();
        System.out.println(bookWithMostPages);

        // Find books with more than a certain page count
        List<Book> booksByPageCount = library.byPageCount(100);
        System.out.println(booksByPageCount);

        // Get all book titles sorted alphabetically
        List<String> sortedTitles = library.titlesSorted();
        System.out.println(sortedTitles);

        // Find books by category
        List<Book> booksByCategory = library.byCategory("Fiction");
        System.out.println(booksByCategory);

        // Create some users
        User user1 = new User("User 1", "123456");
        User user2 = new User("User 2", "789012");

        // Loan a book to a user
        library.loanBook(book1, user1);

        // Return a book from a user
        library.returnBook(book1, user1);
    }
}
