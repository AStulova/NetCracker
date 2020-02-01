package bsys.service.product;

import bsys.model.Client;
import bsys.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> allProducts(Client client);
    List<Product> allProducts(int idOrder);
    int addProduct(Product product, int idOrder);
    void editProduct(Product product);
    void deleteProduct(Product product);
    Product getById(int idProduct);
}
