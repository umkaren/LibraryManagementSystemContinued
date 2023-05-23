package LMS2;

import LMS2.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.List;
class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>(); //initializes book list
        users = new ArrayList<>(); //initializies user list
    }

    public void addBook(Book book) {
        books.add(book); // Add the book to the library
    }

    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    } //removes book from library if title matches

    public List<Book> findBooksByPublicationYear(int year) {
        return books.stream()
                .filter(book -> book.getPublicationYear() == year)
                .collect(Collectors.toList()); //filter books based on year and returns list of matching books
    }

    public List<Book> booksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList()); //returns books based on author's name
    }

    public Book mostPages() {
        return books.stream()
                .max(Comparator.comparingInt(Book::getPages)) //finds book with the max number of pages
                .orElse(null); // returns null if the library is empty
    }

    public List<Book> byPageCount(int pageCount) {
        return books.stream()
                .filter(book -> book.getPages() > pageCount) //filters books with a min page count and returns matching cases in a list
                .collect(Collectors.toList());
    }

    public List<String> titlesSorted() {
        return books.stream()
                .map(Book::getTitle) //gets book titles
                .sorted() //sorts a-z
                .collect(Collectors.toList()); //returns sorted list
    }

    public List<Book> byCategory(String category) {
        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList()); // filters based on category
    }

    public void loanBook(Book book, User user) {
        if (!book.isOnLoan()) {
            book.setOnLoan(true); //loan status to true when book is checked out
            user.addBookOnLoan(book); //add book to user list
        }
    }

    public void returnBook(Book book, User user) {
        if (book.isOnLoan() && user.hasBookOnLoan(book)) {
            book.setOnLoan(false); //loan status is false when returned
            user.removeBookOnLoan(book); // remove from user list
            addBook(book); //add back to library
        }
    }
}