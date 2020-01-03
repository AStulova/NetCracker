package controller;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.BookService;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public List<Book> findAll(){
        return bookService.findAllBooks();
    }

    @GetMapping("/book/find")
    public ResponseEntity<Book> findById(@RequestParam int id) {
        Book book = bookService.findBook(id);
        if (book == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return ResponseEntity.ok(book);
        }
    }

    @PostMapping("/book/add")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @PatchMapping("/book/set/{id}/{number}")
    public void setBookNumber(@PathVariable int id, @PathVariable int number) {
        bookService.setBookNumber(number, id);
    }

    @PutMapping("/book/update/{id}/{name}/{price}/{storage}/{number}")
    public void updateBookInfo(@PathVariable int id, @PathVariable String name, @PathVariable double price, @PathVariable int storage, @PathVariable int number) {
        bookService.updateBookInfo(name, price, storage, number, id);
    }

    @DeleteMapping("/book/delete/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }
}
