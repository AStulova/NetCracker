package bsys.service.order;

import bsys.model.Order;
import java.util.List;

public interface OrderService {
    List<Order> allOrders();
    void addOrder(Order order);
    void deleteOrder(Order order);
    void editOrder(Order order);
    Order getById(int idOrder);
}
