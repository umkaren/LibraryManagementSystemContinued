package LMS2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

class User {
    private String name;
    private String libraryCardNumber;
    private List<Book> booksOnLoan;
    private LocalDate returnDate;

    public User(String name, String libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.booksOnLoan = new ArrayList<>(); //initializes the list of  books the user has borrowed
        this.returnDate = null;
    }

    public void addBookOnLoan(Book book) {
        booksOnLoan.add(book); //add book to user's list
        determineReturnDate(); //calculates the return date
    }

    public void removeBookOnLoan(Book book) {
        booksOnLoan.remove(book); //removes book from user's list
        determineReturnDate();
    }

    public boolean hasBookOnLoan(Book book) {
        return booksOnLoan.contains(book); //checks if user has the book
    }

    public void determineReturnDate() {
        returnDate = LocalDate.now().plusWeeks(2); //sets return date to 2 weeks from current date
    }

    public boolean isBookLate(Book book) {
        return returnDate != null && book.isOnLoan() && LocalDate.now().isAfter(returnDate);
        // 1. Return date is set
        // 2. Current date is after the return date
    }

    public double LateFee(Book book) {
        if (isBookLate(book)) {
            long daysLate = ChronoUnit.DAYS.between(returnDate, LocalDate.now()); // Calculate the number of days the book is late
            return daysLate * 5.0; // Assuming a late fee of $5.00 per day, calculate the total late fee
        }
        return 0.0; // If the book is not late, the late fee is 0
    }
}