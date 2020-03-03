package bsys.service.order;

import bsys.model.Client;
import bsys.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrdersForUpdate();
    List<Order> getOrders(Client client);
    void saveOrder(Order order);
    int addOrder(int idClient);
    void editDiscount(Order order);
    void activateOrder(int idOrder);
    void cancelOrder(int idOrder);
    void deleteOrder(Order order);
    Order getById(int idOrder);
    void updateOrderPrice(int idOrder);
}
