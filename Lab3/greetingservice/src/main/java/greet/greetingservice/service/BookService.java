package greet.greetingservice.service;

import greet.greetingservice.model.Book;
import greet.greetingservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService implements CommandLineRunner {
    @Autowired
    BookRepository bookRepository;

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(String isbn) {
        bookRepository.deleteById(isbn);
    }

    public Book getBook(String isbn) {
        return bookRepository.findById(isbn).get();
    }

    public Collection<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.save(new Book("123", "Book 1", 20.95, "James Brown"));
        bookRepository.save(new Book("124", "Book 2", 20.95, "Mary Jones"));
    }
}
