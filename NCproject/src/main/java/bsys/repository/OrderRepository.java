package bsys.repository;

import bsys.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Modifying
    @Query("update Order o set o.statusOrder = ?1 where o.idOrder = ?2")
    void editOrderStatus(String statusOrder, int id);
}
