package bsys.controller;

import bsys.model.Product;
import bsys.service.order.OrderService;
import bsys.service.product.ProductService;
import bsys.service.tariff.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = "/{idOrder}")
    public ModelAndView allProducts(@PathVariable int idOrder) {
        List<Product> productList = productService.allProducts(idOrder);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ProductPage");
        modelAndView.addObject("productList", productList);
        return modelAndView;
    }

    @GetMapping(value = "/{idOrder}/edit/{idProduct}")
    public ModelAndView editProductPage(@PathVariable int idOrder, @PathVariable int idProduct) {
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.getById(idProduct);
        modelAndView.setViewName("ProductEdit");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping(value = "/{idOrder}/edit")
    public ModelAndView editProduct(@PathVariable int idOrder, @ModelAttribute("product") Product product) {
        ModelAndView modelAndView = new ModelAndView();
        productService.editProduct(product);
        modelAndView.setViewName("redirect:/product/" + idOrder);
        return modelAndView;
    }

    // Для существующего заказа
    @GetMapping(value = "/{idOrder}/add/{idTariff}")
    public ModelAndView addProductPage(@PathVariable int idOrder, @PathVariable int idTariff) {
        ModelAndView modelAndView = new ModelAndView();
        Product product = new Product(orderService.getById(idOrder), tariffService.getById(idTariff), 0);
        modelAndView.addObject("product", product);
        modelAndView.setViewName("ProductEdit");
        return modelAndView;
    }

    // Если новый заказ
    @GetMapping(value = "/add/{idTariff}")
    public ModelAndView addOrderPage(@PathVariable int idTariff) {
        ModelAndView modelAndView = new ModelAndView();
        Product product = new Product(tariffService.getById(idTariff), 0);
        modelAndView.addObject("product", product);
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
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/product/" + idOrder);
        Product product = productService.getById(idProduct);
        productService.deleteProduct(product);
        return modelAndView;
    }
}
