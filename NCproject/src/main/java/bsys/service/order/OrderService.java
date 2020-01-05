package bsys.service.order;

import bsys.model.Order;
import java.util.List;

public interface OrderService {
    List<Order> allOrders();
    void addOrder(Order order);
    void deleteOrder(Order order);
    void editOrderStatus(String statusOrder, int id);
    Order getById(int idOrder);
}
