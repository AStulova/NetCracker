package bsys.repository;

import bsys.model.Client;
import bsys.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findAllByClientOrderByIdOrder(Client client);

/*
    @Modifying
    @Query("update Order set priceOrder = ?1 where idOrder = ?2")
    void updatePriceOrder(double priceOrder, int idOrder);
*/
}
