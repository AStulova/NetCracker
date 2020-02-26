package bsys.controller;

import bsys.model.Bill;
import bsys.model.Client;
import bsys.model.Order;
import bsys.model.Product;
import bsys.service.bill.BillService;
import bsys.service.client.ClientService;
import bsys.service.order.OrderService;
import bsys.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/bill")
public class BillController {
    private BillService billService;
    private ProductService productService;
    private OrderService orderService;
    private ClientService clientService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setBillService(BillService billService) {
        this.billService = billService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ModelAndView getBillsPageByAuthClient() {
        return getModelAndView(clientService.getAuthClient());
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping(value = "/{idClient}")
    public ModelAndView BillsPage(@PathVariable int idClient) {
        return getModelAndView(clientService.getById(idClient));
    }

    private ModelAndView getModelAndView(Client client) {
        List<Bill> billList = billService.getBills(client);
        List<Product> productList = productService.getProducts(client);
        List<Order> orderList = orderService.getOrders(client);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("BillPage");
        modelAndView.addObject("billList", billList);
        modelAndView.addObject("productList", productList);
        modelAndView.addObject("orderList", orderList);
        modelAndView.addObject("client", client);
        modelAndView.addObject("role", clientService.getAuthClient().getRole());
        return modelAndView;
    }
}
