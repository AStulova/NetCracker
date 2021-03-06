package bsys.controller;

import bsys.model.Order;
import bsys.model.Product;
import bsys.service.Validator.FieldsValidator;
import bsys.service.client.ClientService;
import bsys.service.order.OrderService;
import bsys.service.product.ProductService;
import bsys.service.tariff.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    private ProductService productService;
    private OrderService orderService;
    private TariffService tariffService;
    private ClientService clientService;
    private FieldsValidator fieldsValidator;

    @Autowired
    private void setFieldsValidator(FieldsValidator fieldsValidator) {
        this.fieldsValidator = fieldsValidator;
    }

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
        fieldsValidator.verifyClient(idOrder);
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
            modelAndView.addObject("errorMessage", fieldsValidator.getErrorMap(bindingResult));
            getModelAndView(order, modelAndView);
        }
        else {
            Map<String, String> errorMessage = fieldsValidator.orderValidate(order);
            if (!errorMessage.isEmpty()) {
                modelAndView.addObject("errorMessage", errorMessage);
                getModelAndView(order, modelAndView);
            }
            else {
                orderService.editDiscount(order);
                modelAndView.setViewName("redirect:/product/" + order.getIdOrder());
            }
        }
        return modelAndView;
    }

    private void getModelAndView(Order order, ModelAndView modelAndView) {
        List<Product> productList = productService.getProducts(order.getIdOrder());
        Order curOrder = orderService.getById(order.getIdOrder());
        modelAndView.addObject("newDiscount", order.getDiscount());
        modelAndView.addObject("order", curOrder);
        modelAndView.addObject("productList", productList);
        modelAndView.addObject("role", clientService.getAuthClient().getRole());
        modelAndView.setViewName("ProductPage");
    }

    @GetMapping(value = "/{idOrder}/edit/{idProduct}")
    public ModelAndView editProductPage(@PathVariable int idOrder, @PathVariable int idProduct) {
        fieldsValidator.verifyClient(idOrder);
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
        fieldsValidator.verifyClient(idOrder);
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
        fieldsValidator.verifyClient(idOrder);
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.getById(idProduct);
        productService.deleteProduct(product);
        if (productService.getProducts(product.getOrder().getIdOrder()).isEmpty()) {
            if (clientService.getAuthClient().getRole().equals("EMPLOYEE")) {
                modelAndView.setViewName("redirect:/order/" + product.getOrder().getClient().getIdClient());
            }
            else {
                modelAndView.setViewName("redirect:/order");
            }
        }
        else {
            modelAndView.setViewName("redirect:/product/" + idOrder);
        }
        return modelAndView;
    }
}
