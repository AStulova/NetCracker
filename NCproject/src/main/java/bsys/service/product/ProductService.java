package bsys.service.product;

import bsys.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> allProducts();
    List<Product> allProducts(int idOrder);
    Product addProduct(Product product, int idOrder);
    void editProduct(int idProduct, Product product);
    double getProductPrice(int idProduct);
    void deleteProduct(Product product);
    Product getById(int idProduct);
}
