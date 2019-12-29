package bsys.service.product;

import bsys.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO;

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Transactional
    public List<Product> allProducts(final int idOrder) {
        return productDAO.allProducts(idOrder);
    }

    @Transactional
    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    @Transactional
    public void deleteProduct(Product product) {
        productDAO.deleteProduct(product);
    }

    @Transactional
    public void editProduct(Product product) {
        productDAO.editProduct(product);
    }

    @Transactional
    public Product getById(int idProduct) {
        return productDAO.getById(idProduct);
    }
}
