package bsys.service.product;

import bsys.model.Product;
import bsys.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> allProducts(int idOrder) {
        return productRepository.findByIdOrder(idOrder);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    /*
    public void editProductPhoneAndInternet(int sms, int minute, int gb, int speed, int id) {
        productRepository.editProductPhoneAndInternet(sms, minute, gb, speed, id);
    }*/

    public void editProductInternet(int gb, int speed, int id) {
        productRepository.editProductInternet(gb, speed, id);
    }

    public void editProductPhone(int sms, int minute, int id) {
        productRepository.editProductPhone(sms, minute, id);
    }

    public Product getById(int idProduct) {
        return productRepository.getOne(idProduct);
    }
}
