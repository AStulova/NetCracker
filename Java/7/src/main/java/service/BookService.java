package service;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBook(int idBook) {
        return bookRepository.findByIdBook(idBook);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void setBookNumber(int number, int idBook) {
        bookRepository.setBookNumber(number, idBook);
    }

    public void updateBookInfo(String name, double price, int storage, int number, int idBook) {
        bookRepository.updateBookInfo(name, price, storage, number, idBook);
    }

    public void deleteBook(int idBook) {
        bookRepository.deleteById(idBook);
    }
}
