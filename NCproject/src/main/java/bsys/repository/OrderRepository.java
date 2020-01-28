package bsys.repository;

import bsys.model.Client;
import bsys.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Modifying
    @Query("update Order o set o.statusOrder = 'Sended' where o.idOrder = ?1")
    void setStatusSend(int id);

    List<Order> findAllByClient(Client client);

    @Modifying
    @Query(value = "insert into orders(id_client, date_order, status) " +
            "values (?1, now(), 'Saved') " +
            "returning id_order", nativeQuery = true)
    int createOrder(int idClient);
}
