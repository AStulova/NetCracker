package bsys.service.order;

import bsys.model.Client;
import bsys.model.Order;
import bsys.model.Product;
import bsys.repository.OrderRepository;
import bsys.service.client.ClientService;
import bsys.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private ClientService clientService;
    private ProductService productService;
    private OrderRepository orderRepository;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> allOrdersForUpdate() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> allOrders(Client client) {
        return orderRepository.findAllByClient(client);
    }

    @Override
    @Transactional
    public void setStatusSend(int idOrder) {
        Order order = getById(idOrder);
        order.setStatusOrder("Sent");
        order.setDateOrder(new Date());
        orderRepository.save(order);
    }

    @Override
    @Transactional
    public void cancelOrder(int idOrder) {
        Order order = getById(idOrder);
        order.setStatusOrder("Canceled");
        orderRepository.save(order);
    }

    @Override
    public int addOrder(int idClient) {
        Order order = new Order();
        order.setClient(clientService.getById(idClient));
        order.setDateOrder(null);
        order.setStatusOrder("Saved");
        return orderRepository.save(order).getIdOrder();
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public Order getById(int idOrder) {
        return orderRepository.getOne(idOrder);
    }

    @Override
    @Transactional
    public void updateOrderPrice(int idOrder) {
        double priceOrder = 0;
        List<Product> productList = productService.allProducts(idOrder);
        for (Product product : productList) {
            priceOrder += product.getPrice();
        }
        orderRepository.updatePriceOrder(priceOrder, idOrder);
    }
}
