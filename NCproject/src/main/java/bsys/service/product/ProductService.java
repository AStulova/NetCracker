package bsys.service.product;

import bsys.model.Client;
import bsys.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts(Client client);
    List<Product> getProducts(int idOrder);
    int addProduct(Product product, int idOrder);
    void editProduct(Product product);
    void deleteProduct(Product product);
    Product getById(int idProduct);
    void updateProductPrice(Product product);
}
