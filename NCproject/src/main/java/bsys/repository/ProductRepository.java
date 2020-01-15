package bsys.repository;

import bsys.model.Order;
import bsys.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    //Product getProductByIdProductAndOrder(int idProduct, Order order);

    List<Product> findByOrder(Order order);

    @Modifying
    @Query("update Product p set p.sms = ?1, p.minute = ?2, p.gb = ?3, p.speed = ?4 where p.idProduct = ?5")
    void editPhoneAndInternet(int sms, int minute, int gb, int speed, int id);


    @Modifying
    @Query("update Product p set p.gb = ?1, p.speed = ?2 where p.idProduct = ?3")
    void editInternet(int gb, int speed, int id);

    @Modifying
    @Query("update Product p set p.sms = ?1, p.minute = ?2 where p.idProduct = ?3")
    void editPhone(int sms, int minute, int id);
}
