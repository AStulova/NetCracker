package bsys.service.product;

import bsys.model.Client;
import bsys.model.Order;
import bsys.model.Product;
import bsys.model.Tariff;
import bsys.repository.ProductRepository;
import bsys.service.client.ClientService;
import bsys.service.order.OrderService;
import bsys.service.tariff.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ClientService clientService;
    private OrderService orderService;
    private TariffService tariffService;
    private ProductRepository productRepository;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setTariffService(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> allProducts(Client client) {
        return productRepository.getAllByClient(client);
    }

    @Override
    public List<Product> allProducts(int idOrder) {
        return productRepository.findByOrder(orderService.getById(idOrder));
    }

    @Override
    @Transactional
    public int addProduct(Product product, int idOrder) {
        if (idOrder == 0) {
            int idCurOrder = orderService.addOrder(product.getOrder().getClient().getIdClient());
            product.setOrder(orderService.getById(idCurOrder));
        }
        else {
            product.setOrder(orderService.getById(idOrder));
        }
        product.setPrice((product.getMinute() + product.getSms() + product.getGb() + product.getSpeed()) * product.getTariff().getPriceTariff());
        Product product1 = productRepository.save(product);
        orderService.updateOrderPrice(product.getOrder().getIdOrder());
        return product1.getOrder().getIdOrder();
    }

    @Override
    @Transactional
    public void editProduct(Product product) {
        product.setPrice((product.getMinute() + product.getSms() + product.getGb() + product.getSpeed())
                * tariffService.getById(product.getTariff().getIdTariff()).getPriceTariff());
        productRepository.save(product);
        orderService.updateOrderPrice(product.getOrder().getIdOrder());
    }

    @Override
    @Transactional
    public void deleteProduct(Product product) {
        Order order = orderService.getById(product.getOrder().getIdOrder());
        productRepository.delete(product);
        orderService.updateOrderPrice(order.getIdOrder());
        List<Product> productList = allProducts(order.getIdOrder());
        if (productList.isEmpty()) {
            if (order.getStatusOrder().equals("Saved")) {
                orderService.deleteOrder(order);
            }
            else if (order.getStatusOrder().equals("Sent")) {
                orderService.sendOrder(order.getIdOrder());
            }
        }
    }

    @Override
    public Product getById(int idProduct) {
        return productRepository.getOne(idProduct);
    }

    @Override
    @Transactional
    public void updateProductPrice(Product product) {
        double price = 0;
        price = (product.getMinute() + product.getSms() + product.getGb() + product.getSpeed())
                * tariffService.getById(product.getTariff().getIdTariff()).getPriceTariff();
        productRepository.updateProductPrice(price, product.getIdProduct());
    }
}
