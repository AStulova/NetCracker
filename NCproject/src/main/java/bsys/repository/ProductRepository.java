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

    @Query("select p.order.idOrder, p.tariff.nameTariff, p.tariff.typeTariff, p.price from Product p inner join Order o on p.order.idOrder = o.idOrder " +
            "where o.client = ?1 " +
            "order by p.idProduct")
    List<Product> getAllByClient(Client client);
}
