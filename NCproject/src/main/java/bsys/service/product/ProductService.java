package bsys.service.product;

import bsys.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> allProducts(int idOrder);
    void addProduct(Product product);
    void deleteProduct(Product product);
    //void editProductPhoneAndInternet(int sms, int minute, int gb, int speed, int id);
    //void editProductInternet(int gb, int speed, int id);
    //void editProductPhone(int sms, int minute, int id);
    Product getById(int idProduct);
}
