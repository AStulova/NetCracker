package bsys.repository;

import bsys.model.Order;
import bsys.model.Product;
import bsys.model.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByIdProduct(int idProduct);

    List<Product> findByOrder(Order order);

/*
    @Modifying
    @Query("update Product p set p.sms = ?1, p.minute = ?2, p.gb = ?3, p.speed = ?4 where p.idProduct = ?5 and Tariff.typeTariff = 'Mobile connection and Internet'")
    void editProductPhoneAndInternet(int sms, int minute, int gb, int speed, int id);
*/

    /*@Modifying
    @Query("update Product p set p.gb = ?1, p.speed = ?2 where p.tariff = ?3")
    void editProductInternet(int gb, int speed, int id);

    @Modifying
    @Query("update Product p set p.sms = ?1, p.minute = ?2 where p.tariff = ?3")
    void editProductPhone(int sms, int minute, Tariff tariff);*/
}
