package bsys.service.order;

import bsys.model.Client;
import bsys.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> allOrdersForUpdate();
    List<Order> allOrders(Client client);
    void activateOrder(int idOrder);
    int addOrder(int idClient);
    void cancelOrder(int idOrder);
    void deleteOrder(Order order);
    Order getById(int idOrder);
    void updateOrderPrice(int idOrder);
}
