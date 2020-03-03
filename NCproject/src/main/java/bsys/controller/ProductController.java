package bsys.controller;

import bsys.model.Client;
import bsys.model.Order;
import bsys.model.Product;
import bsys.service.client.ClientService;
import bsys.service.order.OrderService;
import bsys.service.product.ProductService;
import bsys.service.tariff.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
    public ModelAndView productsPage(@PathVariable int idOrder) {
        verifyClient(idOrder);
        Order order = orderService.getById(idOrder);
        List<Product> productList = productService.getProducts(idOrder);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ProductPage");
        modelAndView.addObject("order", order);
        modelAndView.addObject("productList", productList);
        modelAndView.addObject("role", clientService.getAuthClient().getRole());
        return modelAndView;
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @PostMapping(value = "/edit/discount")
    public ModelAndView editDiscount(@Valid @ModelAttribute("order") Order order, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            getErrorMap(order, bindingResult, modelAndView);
            List<Product> productList = productService.getProducts(order.getIdOrder());
            modelAndView.addObject("productList", productList);
            modelAndView.addObject("role", clientService.getAuthClient().getRole());
            modelAndView.setViewName("ProductPage");
        }
        else {
            orderService.editDiscount(order);
            modelAndView.setViewName("redirect:/product/" + order.getIdOrder());
        }
        return modelAndView;
    }

    private void getErrorMap(@Valid @ModelAttribute("order") Order order, BindingResult bindingResult, ModelAndView modelAndView) {
        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                FieldError::getField,
                FieldError::getDefaultMessage
        );
        Map<String, String> errors = bindingResult.getFieldErrors().stream().collect(collector);
        modelAndView.addObject("errorMessage", errors);
        modelAndView.addObject("newDiscount", order.getDiscount());
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
        return getModelAndView(product);
    }

    // For new order
    @GetMapping(value = "/add/{idTariff}")
    public ModelAndView addProductPage(@PathVariable int idTariff) {
        Product product = new Product(tariffService.getById(idTariff), clientService.getAuthClient());
        return getModelAndView(product);
    }

    // For new order of current client
    @PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping(value = "/add/{idClient}/{idTariff}")
    public ModelAndView addProductForClientPage(@PathVariable int idClient, @PathVariable int idTariff) {
        Product product = new Product(tariffService.getById(idTariff), clientService.getById(idClient));
        return getModelAndView(product);
    }

    private ModelAndView getModelAndView(Product product) {
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
