package bsys.controller;

import bsys.model.Product;
import bsys.service.order.OrderService;
import bsys.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/product/{id}")
    public ModelAndView allProducts(@PathVariable int id) {
        List<Product> product = productService.allProducts(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ProductPage");
        modelAndView.addObject("productList", product);
        return modelAndView;
    }

    @PostMapping(value = "/product-edit")
    public ModelAndView editProduct(@ModelAttribute("product") Product product) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/product");
        productService.editProduct(product);
        return modelAndView;
    }

    @GetMapping(value = "/product-add")
    public ModelAndView addProductPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ProductEdit");
        return modelAndView;
    }

    @PostMapping(value = "/product-add")
    public ModelAndView addProduct(@ModelAttribute("product") Product product) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/product");
        productService.addProduct(product);
        return modelAndView;
    }

    @GetMapping(value = "/product-delete/{id}")
    public ModelAndView deleteProduct(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/product");
        Product product = productService.getById(id);
        productService.deleteProduct(product);
        return modelAndView;
    }
}
