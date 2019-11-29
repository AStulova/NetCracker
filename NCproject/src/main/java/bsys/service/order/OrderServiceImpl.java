package bsys.service.order;

import bsys.model.Order;
import bsys.service.order.OrderDAO;
import bsys.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO;

    @Autowired
    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Transactional
    public List<Order> allOrders() {
        return orderDAO.allOrders();
    }

    @Transactional
    public void addOrder(Order order) {
        orderDAO.addOrder(order);
    }

    @Transactional
    public void deleteOrder(Order order) {
        orderDAO.deleteOrder(order);
    }

    @Transactional
    public void editOrder(Order order) {
        orderDAO.editOrder(order);
    }

    @Transactional
    public Order getById(int idOrder) {
        return orderDAO.getById(idOrder);
    }
}
