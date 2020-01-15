package bsys.service.product;

import bsys.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> allProducts(int idOrder);
    int addProduct(Product product);
    void editProduct(int idProduct, Product product);
    void deleteProduct(Product product);
    Product getById(int idProduct);
}
