package greet.greetingservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Book {
    @Id
    private String isbn;
    private String tittle;
    private double price;
    private String author;

    public Book() {
    }

    public Book(String isbn, String tittle, double price, String author) {
        this.isbn = isbn;
        this.tittle = tittle;
        this.price = price;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", tittle='" + tittle + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}
