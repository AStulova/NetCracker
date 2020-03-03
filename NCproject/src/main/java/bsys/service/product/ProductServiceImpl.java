package bsys.service.product;

import bsys.model.Client;
import bsys.model.Order;
import bsys.model.Product;
import bsys.repository.ProductRepository;
import bsys.service.order.OrderService;
import bsys.service.tariff.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private OrderService orderService;
    private TariffService tariffService;
    private ProductRepository productRepository;

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
    public List<Product> getProducts(Client client) {
        return productRepository.getAllByClient(client);
    }

    @Override
    public List<Product> getProducts(int idOrder) {
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
        product.setPrice(calculateProductPrice(product));
        Product product1 = productRepository.save(product);
        orderService.updateOrderPrice(product.getOrder().getIdOrder());
        return product1.getOrder().getIdOrder();
    }

    @Override
    @Transactional
    public void editProduct(Product product) {
        product.setPrice(calculateProductPrice(product));
        productRepository.save(product);
        orderService.updateOrderPrice(product.getOrder().getIdOrder());
    }

    @Override
    @Transactional
    public void deleteProduct(Product product) {
        Order order = orderService.getById(product.getOrder().getIdOrder());
        productRepository.delete(product);
        List<Product> productList = getProducts(order.getIdOrder());
        if (productList.isEmpty() && order.getStatusOrder() == 0) {
                orderService.deleteOrder(order);
        }
        else {
            orderService.updateOrderPrice(order.getIdOrder());
        }
    }

    @Override
    public Product getById(int idProduct) {
        return productRepository.getOne(idProduct);
    }

    @Override
    @Transactional
    public void updateProductPrice(Product product) {
        product.setPrice(calculateProductPrice(product));
        productRepository.save(product);
    }

    private BigDecimal calculateProductPrice (Product product) {
        return tariffService.getById(product.getTariff().getIdTariff()).getPriceTariff()
                .multiply(new BigDecimal(product.getMinute() + product.getSms() + product.getGb() + product.getSpeed()));
    }
}
