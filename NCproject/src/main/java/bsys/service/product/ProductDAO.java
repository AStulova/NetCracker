package bsys.service.product;

import bsys.model.Product;
import java.util.List;

public interface ProductDAO {
    List<Product> allProducts(final int idOrder);
    void addProduct(Product product);
    void deleteProduct(Product product);
    void editProduct(Product product);
    Product getById(int idProduct);
}
