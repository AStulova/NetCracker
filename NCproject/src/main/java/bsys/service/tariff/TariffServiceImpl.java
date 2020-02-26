package bsys.service.tariff;

import bsys.model.Order;
import bsys.model.Product;
import bsys.model.Tariff;
import bsys.repository.TariffRepository;
import bsys.service.order.OrderService;
import bsys.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TariffServiceImpl implements TariffService {
    private OrderService orderService;
    private ProductService productService;
    private TariffRepository tariffRepository;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setTariffRepository(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    @Override
    public List<Tariff> getTariffs() {
        return tariffRepository.findAll(Sort.by(Sort.Direction.ASC, "idTariff"));
    }

    @Override
    @Transactional
    public void addTariff(Tariff tariff) {
        tariffRepository.saveAndFlush(tariff);
        // Updating price for clients
        if (tariff.getIdTariff() != 0) {
            List<Order> orderList = orderService.getOrdersForUpdate();
            for (Order order : orderList) {
                List<Product> productList = productService.getProducts(order.getIdOrder());
                for (Product product : productList) {
                    productService.updateProductPrice(product);
                }
                orderService.updateOrderPrice(order.getIdOrder());
            }
        }
    }

    @Override
    public Tariff getById(int idTariff) {
        return tariffRepository.findByIdTariff(idTariff);
    }
}
