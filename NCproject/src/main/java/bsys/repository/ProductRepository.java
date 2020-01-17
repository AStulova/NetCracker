package bsys.repository;

import bsys.model.Client;
import bsys.model.Order;
import bsys.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByOrder(Order order);

    @Query("select p.order.idOrder, p.tariff.nameTariff, p.tariff.typeTariff from Product p inner join Order o on p.order.idOrder = o.idOrder " +
            "where o.client = ?1")
    List<Product> getAllByClient(Client client);

    @Modifying
    @Query("update Product p set p.sms = ?1, p.minute = ?2, p.gb = ?3, p.speed = ?4 where p.idProduct = ?5")
    void editPhoneAndInternet(int sms, int minute, int gb, int speed, int id);

    @Modifying
    @Query("update Product p set p.gb = ?1, p.speed = ?2 where p.idProduct = ?3")
    void editInternet(int gb, int speed, int id);

    @Modifying
    @Query("update Product p set p.sms = ?1, p.minute = ?2 where p.idProduct = ?3")
    void editPhone(int sms, int minute, int id);

    @Query("select ((p.minute + p.sms + p.gb + p.speed) * t.priceTariff)" +
            "from Product p inner join Tariff t on p.tariff.idTariff = t.idTariff " +
            "where p.idProduct = ?1")
    double getProductPrice(int idProduct);

}
