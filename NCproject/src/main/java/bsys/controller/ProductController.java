package bsys.controller;

import bsys.model.Client;
import bsys.model.Product;
import bsys.service.client.ClientService;
import bsys.service.order.OrderService;
import bsys.service.product.ProductService;
import bsys.service.tariff.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    private ProductService productService;
    private OrderService orderService;
    private TariffService tariffService;
    private ClientService clientService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setTariffService(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/{idOrder}")
    public ModelAndView allProducts(@PathVariable int idOrder) {
        verifyClient(idOrder);
        List<Product> productList = productService.allProducts(idOrder);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ProductPage");
        modelAndView.addObject("productList", productList);
        modelAndView.addObject("role", clientService.getAuthClient().getRole());
        return modelAndView;
    }

    @GetMapping(value = "/{idOrder}/edit/{idProduct}")
    public ModelAndView editProductPage(@PathVariable int idOrder, @PathVariable int idProduct) {
        verifyClient(idOrder);
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.getById(idProduct);
        modelAndView.setViewName("ProductEdit");
        modelAndView.addObject("product", product);
        modelAndView.addObject("role", clientService.getAuthClient().getRole());
        return modelAndView;
    }

    @PostMapping(value = "/{idOrder}/edit")
    public ModelAndView editProduct(@PathVariable int idOrder, @ModelAttribute("product") Product product) {
        ModelAndView modelAndView = new ModelAndView();
        productService.editProduct(product);
        modelAndView.setViewName("redirect:/product/" + idOrder);
        return modelAndView;
    }

    // For current order
    @GetMapping(value = "/{idOrder}/add/{idTariff}")
    public ModelAndView addProductPage(@PathVariable int idOrder, @PathVariable int idTariff) {
        verifyClient(idOrder);
        Product product = new Product(orderService.getById(idOrder), tariffService.getById(idTariff));
        return getInfoPage(product);
    }

    // For new order
    @GetMapping(value = "/add/{idTariff}")
    public ModelAndView addProductPage(@PathVariable int idTariff) {
        Product product = new Product(tariffService.getById(idTariff), clientService.getAuthClient());
        return getInfoPage(product);
    }

    // For new order of current client
    @PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping(value = "/add/{idClient}/{idTariff}")
    public ModelAndView addClientProductPage(@PathVariable int idClient, @PathVariable int idTariff) {
        Product product = new Product(tariffService.getById(idTariff), clientService.getById(idClient));
        return getInfoPage(product);
    }

    private ModelAndView getInfoPage(Product product) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", product);
        modelAndView.addObject("role", clientService.getAuthClient().getRole());
        modelAndView.setViewName("ProductEdit");
        return modelAndView;
    }

    @PostMapping(value = "/{idOrder}/add/{idTariff}")
    public ModelAndView addProduct(@PathVariable int idOrder, @PathVariable int idTariff, @ModelAttribute("product") Product product) {
        ModelAndView modelAndView = new ModelAndView();
        product.setTariff(tariffService.getById(idTariff));
        int idCurOrder = productService.addProduct(product, idOrder);
        modelAndView.setViewName("redirect:/product/" + idCurOrder);
        return modelAndView;
    }

    @GetMapping(value = "/{idOrder}/delete/{idProduct}")
    public ModelAndView deleteProduct(@PathVariable int idOrder, @PathVariable int idProduct) {
        verifyClient(idOrder);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/product/" + idOrder);
        Product product = productService.getById(idProduct);
        productService.deleteProduct(product);
        return modelAndView;
    }

    public void verifyClient(int idOrder) {
        Client curClient = clientService.getAuthClient();
        if (curClient.getRole().equals("USER") && curClient.getIdClient() != orderService.getById(idOrder).getClient().getIdClient()) {
            throw new SecurityException("Access denied");
        }
    }
}
