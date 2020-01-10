package app.controller;

import app.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import app.service.BookService;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> findAll(){
        return bookService.findAllBooks();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Book> findById(@PathVariable int id) {
        Book book = bookService.findBook(id);
        if (book == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(book);
        }
    }

    @PostMapping("/add")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @PatchMapping("/set/{id}")
    public void setBookNumber(@PathVariable int id, @RequestBody Book book) {
        bookService.setBookNumber(book.getNumber(), id);
    }

    @PutMapping("/update/{id}")
    public void updateBookInfo(@PathVariable int id, @RequestBody Book book) {
        bookService.updateBookInfo(book.getName(), book.getPrice(), book.getStorage(), book.getNumber(), id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/name-price")
    public List<Book> findNameAndPriceBook() {
        return bookService.findNameAndPrice();
    }

    @GetMapping("/name-or-price")
    public List<Book> findBookByNameOrPrice() {
        return bookService.findByNameOrPrice();
    }

    @GetMapping("/storage-store")
    public List<Book> findBooksInStorage() {
        return bookService.findBooksInStorage();
    }
}
