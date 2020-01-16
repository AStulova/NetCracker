package bsys.service.product;

import bsys.model.Product;
import bsys.repository.OrderRepository;
import bsys.repository.ProductRepository;
import bsys.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private OrderService orderService;
    private ProductRepository productRepository;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> allProducts(int idOrder) {
        return productRepository.findByOrder(orderService.getById(idOrder));
    }

    @Override
    @Transactional
    public int addProduct(Product product, int idOrder) {
        if (idOrder == 0) {
            int idCurOrder = orderService.createOrder();
            product.setOrder(orderService.getById(idCurOrder));
            productRepository.save(product);
            return idCurOrder;
        }
        else {
            product.setOrder(orderService.getById(idOrder));
            productRepository.save(product);
            return idOrder;
        }
    }

    @Override
    @Transactional
    public void editProduct(int idProduct, Product product) {
        switch (productRepository.getOne(idProduct).getTariff().getTypeTariff()) {
            case "Mobile connection and Internet":
                productRepository.editPhoneAndInternet(product.getSms(), product.getMinute(), product.getGb(), product.getSpeed(), idProduct);
                break;
            case "Internet":
                productRepository.editInternet(product.getGb(), product.getSpeed(), idProduct);
                break;
            case "Phone":
                productRepository.editPhone(product.getSms(), product.getMinute(), idProduct);
                break;
        }
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
