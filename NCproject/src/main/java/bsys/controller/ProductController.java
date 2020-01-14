package bsys.controller;

import bsys.model.Product;
import bsys.model.Tariff;
import bsys.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/product/{idOrder}")
    public ModelAndView allProducts(@PathVariable int idOrder) {
        List<Product> product = productService.allProducts(idOrder);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ProductPage");
        modelAndView.addObject("productList", product);
        return modelAndView;
    }

    @GetMapping(value = "/product/edit/{id}")
    public ModelAndView editProduct(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.getById(id);
        Tariff tariff = product.getIdTariff(); // ?
        modelAndView.setViewName("ProductEdit");
        modelAndView.addObject("product", product);
        modelAndView.addObject("tariff", tariff);
        return modelAndView;
    }
/*
    @GetMapping(value = "/product-add")
    public ModelAndView addProductPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ProductEdit");
        return modelAndView;
    }

    // Сделать доп jsp
    @PostMapping(value = "/product-add")
    public ModelAndView addProduct(@ModelAttribute("product") Product product) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/product");
        productService.addProduct(product);
        return modelAndView;
    }
*/
    @GetMapping(value = "/product/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/product"); // редирект должен быть с idOrder
        Product product = productService.getById(id);
        productService.deleteProduct(product);
        return modelAndView;
    }

}
