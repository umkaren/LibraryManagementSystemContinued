package LMS2;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private int pages;
    private String category;
    private boolean isOnLoan;

    public Book(String title, String author, int publicationYear, int pages, String category) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.category = category;
        this.isOnLoan = false;
    }

    //getters and setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getPages() {
        return pages;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isOnLoan() {
        return isOnLoan;
    }

    public void setOnLoan(boolean onLoan) {
        isOnLoan = onLoan;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Publication Year: " + publicationYear +
                ", Pages: " + pages + ", Category: " + category;
    }
}
