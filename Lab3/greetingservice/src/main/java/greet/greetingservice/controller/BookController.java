package greet.greetingservice.controller;

import greet.greetingservice.model.Book;
import greet.greetingservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public void addBook(Book book) {
        bookService.addBook(book);
    }

    @RequestMapping(value = "/book/{isbn}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable("isbn") String isbn) {
        bookService.deleteBook(isbn);
    }

    @RequestMapping(value = "/book/{isbn}", method = RequestMethod.GET)
    public Book getBook(@PathVariable("isbn") String isbn) {
        return bookService.getBook(isbn);
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public Collection<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}
