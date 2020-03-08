package bsys.service.order;

import bsys.model.Client;
import bsys.model.Order;
import bsys.model.Product;
import bsys.model.StatusOrder;
import bsys.repository.OrderRepository;
import bsys.service.client.ClientService;
import bsys.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
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
    public List<Order> getOrdersForUpdate() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrders(Client client) {
        return orderRepository.findAllByClientOrderByIdOrder(client);
    }

    @Override
    @Transactional
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public int addOrder(int idClient) {
        Order order = new Order();
        order.setClient(clientService.getById(idClient));
        order.setDiscount(0);
        return orderRepository.save(order).getIdOrder();
    }

    @Override
    public void editDiscount(Order order) {
        saveOrder(order);
        updateOrderPrice(order.getIdOrder());
    }

    @Override
    public void activateOrder(int idOrder) {
        Order order = getById(idOrder);
        order.setStatusOrder(StatusOrder.ACTIVE.ordinal());
        order.setDateOrder(new Date());
        saveOrder(order);
    }

    @Override
    public void cancelOrder(int idOrder) {
        Order order = getById(idOrder);
        order.setStatusOrder(StatusOrder.CANCELED.ordinal());
        order.setDateCancel(new Date());
        saveOrder(order);
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
    public void updateOrderPrice(int idOrder) {
        BigDecimal priceOrder = BigDecimal.ZERO;
        Order order = getById(idOrder);
        List<Product> productList = productService.getProducts(idOrder);
        for (Product product : productList) {
            priceOrder = priceOrder.add(product.getPrice());
        }
        BigDecimal discount = priceOrder.multiply(BigDecimal.valueOf((double) order.getDiscount() / 100));
        priceOrder = priceOrder.subtract(discount);
        order.setPriceOrder(priceOrder);
        saveOrder(order);
    }
}
