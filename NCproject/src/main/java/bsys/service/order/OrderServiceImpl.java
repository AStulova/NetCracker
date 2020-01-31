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

    @Override
    public List<Order> allOrders() {
        Client client = clientService.getAuthClient();
        return orderRepository.findAllByClient(client);
    }

    @Override
    @Transactional
    public void setStatusSend(int idOrder) {
        orderRepository.setStatusSend(idOrder);
    }

    @Override
    @Transactional
    public void deleteOrder(int idOrder) {
        Order order = getById(idOrder);
        orderRepository.delete(order);
    }

    @Override
    public int addOrder() {
        Order order = new Order();
        order.setClient(clientService.getAuthClient());
        order.setDateOrder(null);
        order.setStatusOrder("Saved");
        return orderRepository.save(order).getIdOrder();
    }

    /*@Override
    public int createOrder() {
        return orderRepository.createOrder(clientService.getAuthClient().getIdClient());
    }*/

    @Override
    public Order getById(int idOrder) {
        return orderRepository.getOne(idOrder);
    }
}
