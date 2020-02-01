package bsys.service.order;

import bsys.model.Client;
import bsys.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> allOrders(Client client);
    void setStatusSend(int idOrder);
    int addOrder(int idClient);
    void cancelOrder(int idOrder);
    Order getById(int idOrder);
}
