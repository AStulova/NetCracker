package bsys.service.product;

import bsys.model.Client;
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
    public List<Product> allProducts() {
        Client client = clientService.getAuthClient();
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
            int idCurOrder = orderService.addOrder();
            product.setOrder(orderService.getById(idCurOrder));
        }
        else {
            product.setOrder(orderService.getById(idOrder));
        }
        product.setPrice((product.getMinute() + product.getSms() + product.getGb() + product.getSpeed()) * product.getTariff().getPriceTariff());
        Product product1 = productRepository.save(product);
        return product1.getOrder().getIdOrder();
    }

    @Override
    @Transactional
    public void editProduct(Product product) {
        product.setPrice((product.getMinute() + product.getSms() + product.getGb() + product.getSpeed())
                * tariffService.getById(product.getTariff().getIdTariff()).getPriceTariff());
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Product getById(int idProduct) {
        return productRepository.getOne(idProduct);
    }
}
