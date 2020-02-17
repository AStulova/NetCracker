package bsys.repository;

import bsys.model.Client;
import bsys.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findAllByClient(Client client);

/*
    @Modifying
    @Query("update Order set priceOrder = ?1 where idOrder = ?2")
    void updatePriceOrder(double priceOrder, int idOrder);
*/

    /*@Modifying
    @Query(value = "insert into orders(id_client, date_order, status) " +
            "values (?1, null, 'Saved') " +
            "returning id_order", nativeQuery = true)
    int createOrder(int idClient);*/
}
