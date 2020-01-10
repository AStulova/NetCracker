package app.repos;

import app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findByIdBook(int idBook);

    @Modifying
    @Query("update Book b set b.number = ?1 where b.idBook = ?2")
    void setBookNumber(int number, int idBook);

    @Modifying
    @Query("update Book b set b.name = ?1, b.price = ?2, b.storage = ?3, b.number = ?4 where b.idBook = ?5")
    void updateBookInfo(String name, double price, String storage, int number, int idBook);

    @Query("select b.name, b.price from Book b")
    List<Book> findNameAndPrice();

    @Query("select b.name, b.price from Book b where b.name like '%Windows%' or b.price > ?1 order by  b.name, b.price")
    List<Book> findByNameOrPrice(double price);

    @Query("select b.name, b.storage, b.number, b.price " +
            "from Book b inner join Purchase p on b.idBook = p.idBook inner join Store s on p.idStore = s.idStore " +
            "where b.storage = s.placement and b.number > 10 ")
    List<Book> findBooksInStorage();
}
