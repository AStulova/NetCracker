package service;

import model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findByIdBook(int idBook);

    @Modifying
    @Query("update Book b set b.number = ?1 where b.idBook = ?2")
    void setBookNumber(int number, int idBook);

    @Modifying
    @Query("update Book b set b.name =?1, b.price = ?2, b.storage = ?3, b.number = ?4 where b.idBook = ?5")
    void updateBookInfo(String name, double price, int storage, int number, int idBook);
}
