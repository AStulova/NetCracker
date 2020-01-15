package bsys.service.order;

import bsys.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> allOrders();
    void setStatusSend(int idOrder);
    int createOrder();
    void addOrder(Order order);
    void deleteOrder(int idOrder);
    Order getById(int idOrder);
}
