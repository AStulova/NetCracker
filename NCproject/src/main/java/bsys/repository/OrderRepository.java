package bsys.repository;

import bsys.model.Client;
import bsys.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Modifying
    @Query("update Order o set o.statusOrder = 'Sended' where o.idOrder = ?1")
    void setStatusSend(int id);

    @Query("select o.idOrder, o.dateOrder, o.statusOrder from Order o where o.idClient = ?1")
    List<Order> findAllByIdClient(Client idClient);
}
