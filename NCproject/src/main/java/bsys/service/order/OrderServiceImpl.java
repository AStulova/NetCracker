package bsys.service.order;

import bsys.model.Client;
import bsys.model.Order;
import bsys.repository.OrderRepository;
import bsys.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private ClientService clientService;
    private OrderRepository orderRepository;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> allOrders() {
        Client client = clientService.getAuthClient();
        return orderRepository.findAllByClient(client);
    }

    public void setStatusSend(int idOrder) {
        orderRepository.setStatusSend(idOrder);
    }

    public void deleteOrder(int idOrder) {
        Order order = getById(idOrder);
        orderRepository.delete(order);
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public Order getById(int idOrder) {
        return orderRepository.getOne(idOrder);
    }
}
