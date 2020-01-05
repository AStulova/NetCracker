package bsys.service.order;

import bsys.model.Order;
import bsys.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> allOrders() {
        return orderRepository.findAll();
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }

    public void editOrderStatus(String statusOrder, int id) {
        orderRepository.editOrderStatus(statusOrder, id);
    }

    public Order getById(int idOrder) {
        return orderRepository.getOne(idOrder);
    }
}
